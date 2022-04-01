package com.github.danwiseman.kafka.connect.scryfall;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSchemas.*;

import com.github.danwiseman.kafka.connect.scryfall.model.*;
import com.github.danwiseman.kafka.connect.scryfall.utils.DateUtils;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScryfallSourceTask extends SourceTask {

  /*    Your connector should never use System.out for logging. All of your classes should use slf4j
    for logging*/

  static final Logger log = LoggerFactory.getLogger(ScryfallSourceTask.class);
  public ScryfallSourceConnectorConfig config;
  public ScryfallAPIHttpClient scryfallAPIHttpClient;

  protected Instant nextQuerySince;
  protected String lastCardId;
  protected String nextPageToVisit;
  protected String lastReleaseAt;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new ScryfallSourceConnectorConfig(map);
    initializeLastVariables();
    scryfallAPIHttpClient = new ScryfallAPIHttpClient(config);
  }

  private void initializeLastVariables() {
    Map<String, Object> lastSourceOffset = null;
    lastSourceOffset = context.offsetStorageReader().offset(sourcePartition());
    if (lastSourceOffset == null) {
      nextQuerySince = config.getSince();
    } else {
      Object updatedAt = lastSourceOffset.get(CARD_RELEASED_AT); // will need updated to set if that is added
      Object cardId = lastSourceOffset.get(CARD_ID_FIELD);
      Object nextPage = lastSourceOffset.get(NEXT_PAGE_FIELD);

      if (updatedAt != null && (updatedAt instanceof String)) {
        nextQuerySince = DateUtils.InstantFromScryFallDate((String) updatedAt);
      }
      if (cardId != null && (cardId instanceof String)) {
        lastCardId = (String) cardId;
      }
      if (nextPage != null && (nextPage instanceof String)) {
        nextPageToVisit = (String) nextPage;
      }
    }
  }

  @Override
  public List<SourceRecord> poll() throws InterruptedException {
    scryfallAPIHttpClient.sleepIfNeed();

    final ArrayList<SourceRecord> records = new ArrayList<>();
    JSONArray cards = scryfallAPIHttpClient.getNextCards(
      nextPageToVisit,
      nextQuerySince
    );

    int i = 0;
    for (Object obj : cards) {
      Card card = Card.fromJson((JSONObject) obj);

      SourceRecord sourceRecord = generateSourceRecord(card);
      records.add(sourceRecord);
      i += 1;
      lastReleaseAt = card.getReleased_at();
    }
    if (i > 0) log.info(String.format("Fetched %s cards", i));
    if (i == 175) {
      nextPageToVisit = scryfallAPIHttpClient.getNextPageFromResponse();
    } else {
      nextQuerySince =
        DateUtils
          .InstantFromScryFallDate(lastReleaseAt)
          .plus(1, ChronoUnit.DAYS);
      nextPageToVisit = scryfallAPIHttpClient.constructUrl("", nextQuerySince);
      scryfallAPIHttpClient.sleep();
    }
    return records;
  }

  private SourceRecord generateSourceRecord(Card card) {
    return new SourceRecord(
      sourcePartition(),
      sourceOffset(card.getReleasedAtAsInstant()),
      config.getTopic(),
      null,
      KEY_SCHEMA,
      buildRecordKey(card),
      VALUE_SCHEMA,
      buildRecordValue(card),
      card.getReleasedAtAsInstant().toEpochMilli()
    );
  }

  private Struct buildRecordValue(Card card) {
    Struct valueStruct = new Struct(VALUE_SCHEMA)
      .put(CARD_ID_FIELD, card.getId())
      .put(CARD_LANG_FIELD, card.getLang())
      .put(CARD_ARENA_ID_FIELD, card.getArena_id())
      .put(CARD_MTGO_ID, card.getMtgo_id())
      .put(CARD_MTGO_FOIL_ID, card.getMtgo_foil_id())
      .put(CARD_MULTIVERSE_IDS, card.getMultiverse_ids())
      .put(CARD_OBJECT, card.getObject())
      .put(CARD_ORACLE_ID, card.getOracle_id())
      .put(CARD_PRINTS_SEARCH_URI, card.getPrints_search_uri())
      .put(CARD_RULINGS_URI, card.getRulings_uri())
      .put(CARD_SCRYFALL_URI, card.getScryfall_uri())
      .put(CARD_URI, card.getUri())
      .put(CARD_CMC, card.getCmc())
      .put(CARD_COLOR_IDENTITY, card.getColor_identity())
      .put(CARD_COLOR_INDICATOR, card.getColor_indicator())
      .put(CARD_COLORS, card.getColors())
      .put(CARD_EDHREC_RANK, card.getEdhrec_rank())
      .put(CARD_HAND_MODIFIER, card.getHand_modifier())
      .put(CARD_KEYWORDS, card.getKeywords())
      .put(CARD_LAYOUT, card.getLayout())
      .put(CARD_LIFE_MODIFIER, card.getLife_modifier())
      .put(CARD_LOYALTY, card.getLoyalty())
      .put(CARD_MANA_COST, card.getMana_cost())
      .put(CARD_NAME, card.getName())
      .put(CARD_ORACLE_TEXT, card.getOracle_text())
      .put(CARD_OVERSIZED, card.getOversized())
      .put(CARD_POWER, card.getPower())
      .put(CARD_PRODUCED_MANA, card.getProduced_mana())
      .put(CARD_RESERVED, card.getReserved())
      .put(CARD_TOUGHNESS, card.getToughness())
      .put(CARD_TYPE_LINE, card.getType_line())
      .put(CARD_ARTIST, card.getArtist())
      .put(CARD_BOOSTER, card.getBooster())
      .put(CARD_BORDER_COLOR, card.getBorder_color())
      .put(CARD_BACK_ID, card.getBack_id())
      .put(CARD_COLLECTOR_NUMBER, card.getCollector_number())
      .put(CARD_CONTENT_WARNING, card.getContent_warning())
      .put(CARD_DIGITAL, card.getDigital())
      .put(CARD_FINISHES, card.getFinishes())
      .put(CARD_FLAVOR_NAME, card.getFlavor_name())
      .put(CARD_FLAVOR_TEXT, card.getFlavor_text())
      .put(CARD_FRAME, card.getFrame())
      .put(CARD_FULL_ART, card.getFull_art())
      .put(CARD_GAMES, card.getGames())
      .put(CARD_HIGHRES_IMAGE, card.getHighres_image())
      .put(CARD_ILLUSTRATION_ID, card.getIllustration_id())
      .put(CARD_IMAGE_STATUS, card.getImage_status())
      .put(CARD_PRINTED_NAME, card.getPrinted_name())
      .put(CARD_PRINTED_TEXT, card.getPrinted_text())
      .put(CARD_PRINTED_TYPE_LINE, card.getPrinted_type_line())
      .put(CARD_PROMO, card.getPromo())
      .put(CARD_PROMO_TYPES, card.getPromo_types())
      .put(CARD_RARITY, card.getRarity())
      .put(CARD_RELEASED_AT, card.getReleased_at())
      .put(CARD_REPRINT, card.getReprint())
      .put(CARD_SCRYFALL_SET_URI, card.getScryfall_set_uri())
      .put(CARD_SET_NAME, card.getSet_name())
      .put(CARD_SET_SEARCH_URI, card.getSet_search_uri())
      .put(CARD_SET_TYPE, card.getSet_type())
      .put(CARD_SET_URI, card.getSet_uri())
      .put(CARD_SET, card.getSet())
      .put(CARD_SET_ID, card.getSet_id())
      .put(CARD_STORY_SPOTLIGHT, card.getStory_spotlight())
      .put(CARD_TEXTLESS, card.getTextless())
      .put(CARD_VARIATION, card.getVariation())
      .put(CARD_VARIATION_OF, card.getVariation_of())
      .put(CARD_SECURITY_STAMP, card.getSecurity_stamp())
      .put(CARD_WATERMARK, card.getWatermark())
      .put(CARD_PREVIEW_PREVIEWED_AT, card.getPreview_previewed_at())
      .put(CARD_PREVIEW_SOURCE_URI, card.getPreview_source_uri())
      .put(CARD_PREVIEW_SOURCE, card.getPreview_source());

    // optional related uris
    Card_Related_Uris card_related_uris = card.getRelated_uris();
    if (card_related_uris != null) {
      Struct relatedUrisStruct = new Struct(RELATED_URIS_SCHEMA)
        .put(CARD_RELATED_URIS_GATHERER, card_related_uris.getGatherer())
        .put(CARD_RELATED_URIS_EDHREC, card_related_uris.getEdhrec())
        .put(CARD_RELATED_URIS_MTGTOP8, card_related_uris.getMtgtop8())
        .put(
          CARD_RELATED_URIS_TCG_INF_ART,
          card_related_uris.getTcgplayer_infinite_articles()
        )
        .put(
          CARD_RELATED_URIS_TCG_ING_DECKS,
          card_related_uris.getTcgplayer_infinite_decks()
        );
      valueStruct.put(CARD_RELATED_URIS, relatedUrisStruct);
    }

    Card_Purchase_Uris card_purchase_uris = card.getPurchase_uris();
    if (card_purchase_uris != null) {
      Struct purchaseUrisStruct = new Struct(PURCHASE_URIS_SCHEMA)
        .put(
          CARD_PURCHASE_URIS_CARDHOARDER,
          card_purchase_uris.getCardhoarder()
        )
        .put(CARD_PURCHASE_URIS_CARDMARKET, card_purchase_uris.getCardmarket())
        .put(CARD_PURCHASE_URIS_TCGPLAYER, card_purchase_uris.getTcgplayer());
      valueStruct.put(CARD_PURCHASE_URIS, purchaseUrisStruct);
    }

    Card_Prices card_prices = card.getPrices();
    if (card_prices != null) {
      Struct cardPricesStruct = new Struct(PRICES_SCHEMA)
        .put(CARD_PRICES_USD, card_prices.getUsd())
        .put(CARD_PRICES_USD_FOIL, card_prices.getUsd_foil())
        .put(CARD_PRICES_USD_ETCHED, card_prices.getUsd_etched())
        .put(CARD_PRICES_EUR, card_prices.getEur())
        .put(CARD_PRICES_EUR_FOIL, card_prices.getEur_foil())
        .put(CARD_PRICES_TIX, card_prices.getTix());
      valueStruct.put(CARD_PRICES, cardPricesStruct);
    }

    Card_Image_Uris card_image_uris = card.getImage_uris();
    if (card_image_uris != null) {
      Struct cardImagesStruct = new Struct(IMAGE_URIS_SCHEMA)
        .put(CARD_IMAGE_URI_PNG, card_image_uris.getPng())
        .put(CARD_IMAGE_URI_BORDER_CROP, card_image_uris.getBorder_crop())
        .put(CARD_IMAGE_URI_ART_CROP, card_image_uris.getArt_crop())
        .put(CARD_IMAGE_URI_LARGE, card_image_uris.getLarge())
        .put(CARD_IMAGE_URI_NORMAL, card_image_uris.getNormal())
        .put(CARD_IMAGE_URI_SMALL, card_image_uris.getSmall());
      valueStruct.put(CARD_IMAGE_URIS, cardImagesStruct);
    }

    List<Card_Face> card_faces = card.getCard_faces();
    if (card_faces != null) {
      List<Struct> cardFacesList = new ArrayList<>();
      for (Card_Face card_face : card_faces) {
        Struct cardFaceStruct = new Struct(CARD_FACE_SCHEMA)
          .put(CARD_FACE_ARTIST, card_face.getArtist())
          .put(CARD_FACE_CMC, card_face.getCmc())
          .put(CARD_FACE_COLOR_INDICATOR, card_face.getColor_indicator())
          .put(CARD_FACE_COLORS, card_face.getColors())
          .put(CARD_FACE_FLAVOR_TEXT, card_face.getFlavor_text())
          .put(CARD_FACE_ILLUSTRATION_ID, card_face.getIllustration_id())
          .put(CARD_FACE_LAYOUT, card_face.getLayout())
          .put(CARD_FACE_LOYALTY, card_face.getLoyalty())
          .put(CARD_FACE_MANA_COST, card_face.getMana_cost())
          .put(CARD_FACE_NAME, card_face.getName())
          .put(CARD_FACE_OBJECT, card_face.getObject())
          .put(CARD_FACE_ORACLE_ID, card_face.getOracle_id())
          .put(CARD_FACE_ORACLE_TEXT, card_face.getOracle_text())
          .put(CARD_FACE_POWER, card_face.getPower())
          .put(CARD_FACE_PRINTED_NAME, card_face.getPrinted_name())
          .put(CARD_FACE_PRINTED_TEXT, card_face.getPrinted_text())
          .put(CARD_FACE_PRINTED_TYPE_LINE, card_face.getPrinted_type_line())
          .put(CARD_FACE_TOUGHNESS, card_face.getToughness())
          .put(CARD_FACE_TYPE_LINE, card_face.getType_line())
          .put(CARD_FACE_WATERMARK, card_face.getWatermark());

        Card_Image_Uris cf_images = card_face.getImage_uris();
        if (cf_images != null) {
          Struct cfCardImagesStruct = new Struct(IMAGE_URIS_SCHEMA)
            .put(CARD_IMAGE_URI_PNG, cf_images.getPng())
            .put(CARD_IMAGE_URI_BORDER_CROP, cf_images.getPng())
            .put(CARD_IMAGE_URI_ART_CROP, cf_images.getPng())
            .put(CARD_IMAGE_URI_LARGE, cf_images.getPng())
            .put(CARD_IMAGE_URI_NORMAL, cf_images.getPng())
            .put(CARD_IMAGE_URI_SMALL, cf_images.getPng());

          cardFaceStruct.put(CARD_FACE_IMAGE_URIS, cfCardImagesStruct);
        }
        cardFacesList.add(cardFaceStruct);
      }
      valueStruct.put(CARD_FACES, cardFacesList);
    }

    List<Card_All_Parts> card_all_parts = card.getAll_parts();
    if (card_all_parts != null) {
      List<Struct> cardAllPartsList = new ArrayList<>();
      for (Card_All_Parts card_all_part : card_all_parts) {
        Struct cardAllPartStruct = new Struct(ALL_PART_SCHEMA)
          .put(CARD_ALL_PARTS_ID, card_all_part.getId())
          .put(CARD_ALL_PARTS_OBJECT, card_all_part.getObject())
          .put(CARD_ALL_PARTS_COMPONENT, card_all_part.getComponent())
          .put(CARD_ALL_PARTS_NAME, card_all_part.getName())
          .put(CARD_ALL_PARTS_TYPE_LINE, card_all_part.getType_line())
          .put(CARD_ALL_PARTS_URI, card_all_part.getUri());

        cardAllPartsList.add(cardAllPartStruct);
      }
      valueStruct.put(CARD_ALL_PARTS, cardAllPartsList);
    }

    Card_Legalities card_legalities = card.getLegalities();
    if (card_legalities != null) {
      Struct cardLegalitiesStruct = new Struct(LEGALITIES_SCHEMA)
        .put(CARD_LEGALITIES_STANDARD, card_legalities.getStandard())
        .put(CARD_LEGALITIES_FUTURE, card_legalities.getStandard())
        .put(CARD_LEGALITIES_HISTORIC, card_legalities.getStandard())
        .put(CARD_LEGALITIES_GLADIATOR, card_legalities.getStandard())
        .put(CARD_LEGALITIES_PIONEER, card_legalities.getStandard())
        .put(CARD_LEGALITIES_MODERN, card_legalities.getStandard())
        .put(CARD_LEGALITIES_LEGACY, card_legalities.getStandard())
        .put(CARD_LEGALITIES_PAUPER, card_legalities.getStandard())
        .put(CARD_LEGALITIES_VINTAGE, card_legalities.getStandard())
        .put(CARD_LEGALITIES_PENNY, card_legalities.getStandard())
        .put(CARD_LEGALITIES_COMMANDER, card_legalities.getStandard())
        .put(CARD_LEGALITIES_BRAWL, card_legalities.getStandard())
        .put(CARD_LEGALITIES_HISTORICALBRAWL, card_legalities.getStandard())
        .put(CARD_LEGALITIES_ALCHEMY, card_legalities.getStandard())
        .put(CARD_LEGALITIES_PAUPERCOMMANDER, card_legalities.getStandard())
        .put(CARD_LEGALITIES_DUEL, card_legalities.getStandard())
        .put(CARD_LEGALITIES_OLDSCHOOL, card_legalities.getStandard())
        .put(CARD_LEGALITIES_PREMODERN, card_legalities.getStandard());

      valueStruct.put(CARD_LEGALITIES, cardLegalitiesStruct);
    }

    return valueStruct;
  }

  private Struct buildRecordKey(Card card) {
    Struct key = new Struct(KEY_SCHEMA).put(CARD_ID_FIELD, card.getId());

    return key;
  }

  @Override
  public void stop() {
    //TODO: Do whatever is required to stop your task.
  }

  private Map<String, String> sourcePartition() {
    Map<String, String> map = new HashMap<>();
    map.put(PULL_TYPE_FIELD, config.getPullType());

    return map;
  }

  private Map<String, String> sourceOffset(Instant updatedAt) {
    Map<String, String> map = new HashMap<>();
    map.put(
      CARD_RELEASED_AT,
      DateUtils.ScryFallDateFromInstant(
        DateUtils.MaxInstant(updatedAt, nextQuerySince)
      )
    );
    map.put(NEXT_PAGE_FIELD, nextPageToVisit);
    return map;
  }
}
