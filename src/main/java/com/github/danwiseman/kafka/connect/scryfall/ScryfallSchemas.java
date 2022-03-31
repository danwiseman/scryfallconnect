package com.github.danwiseman.kafka.connect.scryfall;


import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;

import static org.apache.kafka.connect.data.Schema.*;

public class ScryfallSchemas {

    public static final String NEXT_PAGE_FIELD = "next_page";
    public static final String PULL_TYPE_FIELD = "cards";

    // Card Fields
    public static final String CARD_ID_FIELD = "id";
    public static final String CARD_LANG_FIELD = "lang";
    public static final String CARD_ARENA_ID_FIELD = "arena_id";
    public static final String CARD_MTGO_ID = "mtgo_id";
    public static final String CARD_MTGO_FOIL_ID = "mtgo_foil_id";
    public static final String CARD_MULTIVERSE_IDS = "multiverse_ids";
    public static final String CARD_OBJECT = "object";
    public static final String CARD_ORACLE_ID = "oracle_id";
    public static final String CARD_PRINTS_SEARCH_URI = "prints_search_uri";
    public static final String CARD_RULINGS_URI = "rulings_uri";
    public static final String CARD_SCRYFALL_URI = "scryfall_uri";
    public static final String CARD_URI = "uri";

    // ALL PARTS FIELDS
    public static final String CARD_ALL_PARTS = "all_parts";
    public static final String CARD_ALL_PARTS_ID = "id";
    public static final String CARD_ALL_PARTS_OBJECT = "object";
    public static final String CARD_ALL_PARTS_COMPONENT = "component";
    public static final String CARD_ALL_PARTS_NAME = "name";
    public static final String CARD_ALL_PARTS_TYPE_LINE = "type_line";
    public static final String CARD_ALL_PARTS_URI = "uri";

    // GAMEPLAY FIELDS
    public static final String CARD_CMC = "cmc";
    public static final String CARD_COLOR_IDENTITY = "color_identity";
    public static final String CARD_COLOR_INDICATOR = "color_indicator";
    public static final String CARD_COLORS = "colors";
    public static final String CARD_EDHREC_RANK = "edhrec_rank";
    public static final String CARD_HAND_MODIFIER = "hand_modifier";
    public static final String CARD_KEYWORDS = "keywords";
    public static final String CARD_LAYOUT = "layout";

    // LEGALITIES
    public static final String CARD_LEGALITIES = "legalities";
    public static final String CARD_LEGALITIES_STANDARD = "standard";
    public static final String CARD_LEGALITIES_FUTURE = "future";
    public static final String CARD_LEGALITIES_HISTORIC = "historic";
    public static final String CARD_LEGALITIES_GLADIATOR = "gladiator";
    public static final String CARD_LEGALITIES_PIONEER = "pioneer";
    public static final String CARD_LEGALITIES_MODERN = "modern";
    public static final String CARD_LEGALITIES_LEGACY = "legacy";
    public static final String CARD_LEGALITIES_PAUPER = "pauper";
    public static final String CARD_LEGALITIES_VINTAGE = "vintage";
    public static final String CARD_LEGALITIES_PENNY = "penny";
    public static final String CARD_LEGALITIES_COMMANDER = "commander";
    public static final String CARD_LEGALITIES_BRAWL = "brawl";
    public static final String CARD_LEGALITIES_HISTORICALBRAWL = "historicbrawl";
    public static final String CARD_LEGALITIES_ALCHEMY = "alchemy";
    public static final String CARD_LEGALITIES_PAUPERCOMMANDER = "paupercommander";
    public static final String CARD_LEGALITIES_DUEL = "duel";
    public static final String CARD_LEGALITIES_OLDSCHOOL = "oldschool";
    public static final String CARD_LEGALITIES_PREMODERN = "premodern";


    // MORE GAMEPLAY FIELDS
    public static final String CARD_LIFE_MODIFIER = "life_modifier";
    public static final String CARD_LOYALTY = "loyalty";
    public static final String CARD_MANA_COST = "mana_cost";
    public static final String CARD_NAME = "name";
    public static final String CARD_ORACLE_TEXT = "oracle_text";
    public static final String CARD_OVERSIZED = "oversized";
    public static final String CARD_POWER = "power";
    public static final String CARD_PRODUCED_MANA = "produced_mana";
    public static final String CARD_RESERVED = "reserved";
    public static final String CARD_TOUGHNESS = "toughness";
    public static final String CARD_TYPE_LINE = "type_line";

    // PRINT FIELDS
    public static final String CARD_ARTIST = "artist";
    public static final String CARD_BOOSTER = "booster";
    public static final String CARD_BORDER_COLOR = "border_color";
    public static final String CARD_BACK_ID = "card_back_id";
    public static final String CARD_COLLECTOR_NUMBER = "collector_number";
    public static final String CARD_CONTENT_WARNING = "content_warning";
    public static final String CARD_DIGITAL = "digital";
    public static final String CARD_FINISHES = "finishes";
    public static final String CARD_FLAVOR_NAME = "flavor_name";
    public static final String CARD_FLAVOR_TEXT = "flavor_text";
    public static final String CARD_FRAME_EFFECTS = "frame_effects";
    public static final String CARD_FRAME = "frame";
    public static final String CARD_FULL_ART = "full_art";
    public static final String CARD_GAMES = "games";
    public static final String CARD_HIGHRES_IMAGE = "highres_image";
    public static final String CARD_ILLUSTRATION_ID = "illustration_id";
    public static final String CARD_IMAGE_STATUS = "image_status";
    public static final String CARD_PRINTED_NAME = "printed_name";
    public static final String CARD_PRINTED_TEXT = "printed_text";
    public static final String CARD_PRINTED_TYPE_LINE = "printed_type_line";
    public static final String CARD_PROMO = "promo";
    public static final String CARD_PROMO_TYPES = "promo_types";
    public static final String CARD_RARITY = "rarity";
    public static final String CARD_RELEASED_AT = "released_at";
    public static final String CARD_REPRINT = "reprint";
    public static final String CARD_SCRYFALL_SET_URI = "scryfall_set_uri";
    public static final String CARD_SET_NAME = "set_name";
    public static final String CARD_SET_SEARCH_URI = "set_search_uri";
    public static final String CARD_SET_TYPE = "set_type";
    public static final String CARD_SET_URI = "set_uri";
    public static final String CARD_SET = "set";
    public static final String CARD_SET_ID = "set_id";
    public static final String CARD_STORY_SPOTLIGHT = "story_spotlight";
    public static final String CARD_TEXTLESS = "textless";
    public static final String CARD_VARIATION = "variation";
    public static final String CARD_VARIATION_OF = "variation_of";
    public static final String CARD_SECURITY_STAMP = "security_stamp";
    public static final String CARD_WATERMARK = "watermark";
    public static final String CARD_PREVIEW_PREVIEWED_AT = "preview.previewed_at";
    public static final String CARD_PREVIEW_SOURCE_URI = "preview.source_uri";
    public static final String CARD_PREVIEW_SOURCE = "preview.source";

    // Card Face Objects
    public static final String CARD_FACES = "card_faces";
    public static final String CARD_FACE_ARTIST = "artist";
    public static final String CARD_FACE_CMC = "cmc";
    public static final String CARD_FACE_COLOR_INDICATOR = "color_indicator";
    public static final String CARD_FACE_COLORS = "colors";
    public static final String CARD_FACE_FLAVOR_TEXT = "flavor_text";
    public static final String CARD_FACE_ILLUSTRATION_ID = "illustration_id";
    public static final String CARD_FACE_IMAGE_URIS = "image_uris";
    public static final String CARD_FACE_LAYOUT = "layout";
    public static final String CARD_FACE_LOYALTY = "loyalty";
    public static final String CARD_FACE_MANA_COST = "mana_cost";
    public static final String CARD_FACE_NAME = "name";
    public static final String CARD_FACE_OBJECT = "object";
    public static final String CARD_FACE_ORACLE_ID = "oracle_id";
    public static final String CARD_FACE_ORACLE_TEXT = "oracle_text";
    public static final String CARD_FACE_POWER = "power";
    public static final String CARD_FACE_PRINTED_NAME = "printed_name";
    public static final String CARD_FACE_PRINTED_TEXT = "printed_text";
    public static final String CARD_FACE_PRINTED_TYPE_LINE = "printed_type_line";
    public static final String CARD_FACE_TOUGHNESS = "toughness";
    public static final String CARD_FACE_TYPE_LINE = "type_line";
    public static final String CARD_FACE_WATERMARK = "watermark";

    // image uris
    public static final String CARD_IMAGE_URIS = "image_uris";
    public static final String CARD_IMAGE_URI_PNG = "png";
    public static final String CARD_IMAGE_URI_BORDER_CROP = "border_crop";
    public static final String CARD_IMAGE_URI_ART_CROP = "art_crop";
    public static final String CARD_IMAGE_URI_LARGE = "large";
    public static final String CARD_IMAGE_URI_NORMAL = "normal";
    public static final String CARD_IMAGE_URI_SMALL = "small";

    // prices
    public static final String CARD_PRICES = "prices";
    public static final String CARD_PRICES_USD = "usd";
    public static final String CARD_PRICES_USD_FOIL = "usd_foil";
    public static final String CARD_PRICES_USD_ETCHED = "usd_etched";
    public static final String CARD_PRICES_EUR = "eur";
    public static final String CARD_PRICES_EUR_FOIL = "eur_foil";
    public static final String CARD_PRICES_TIX = "tix";

    // purchase uris
    public static final String CARD_PURCHASE_URIS = "purchase_uris";
    public static final String CARD_PURCHASE_URIS_TCGPLAYER = "tcgplayer";
    public static final String CARD_PURCHASE_URIS_CARDMARKET = "cardmarket";
    public static final String CARD_PURCHASE_URIS_CARDHOARDER = "cardhoarder";

    // related uris
    public static final String CARD_RELATED_URIS = "related_uris";
    public static final String CARD_RELATED_URIS_GATHERER = "gatherer";
    public static final String CARD_RELATED_URIS_TCG_INF_ART = "tcgplayer_infinite_articles";
    public static final String CARD_RELATED_URIS_TCG_ING_DECKS = "tcgplayer_infinite_decks";
    public static final String CARD_RELATED_URIS_EDHREC = "edhrec";
    public static final String CARD_RELATED_URIS_MTGTOP8 = "mtgtop8";

    // schemas
    public static final String SCHEMA_KEY = "com.github.danwiseman.kafka.connect.scryfall.CardKey";
    public static final String SCHEMA_VALUE_RELATED_URIS = "com.github.danwiseman.kafka.connect.scryfall.RelatedUris";
    public static final String SCHEMA_VALUE_PURCHASE_URIS = "com.github.danwiseman.kafka.connect.scryfall.PurchaseUris";
    public static final String SCHEMA_VALUE_PRICES = "com.github.danwiseman.kafka.connect.scryfall.Prices";
    public static final String SCHEMA_VALUE_IMAGE_URIS = "com.github.danwiseman.kafka.connect.scryfall.ImageUris";
    public static final String SCHEMA_VALUE_CARD_FACES = "com.github.danwiseman.kafka.connect.scryfall.CardFaces";
    public static final String SCHEMA_VALUE_ALL_PARTS = "com.github.danwiseman.kafka.connect.scryfall.AllParts";
    public static final String SCHEMA_VALUE_LEGALITIES = "com.github.danwiseman.kafka.connect.scryfall.Legalities";
    public static final String SCHEMA_VALUE_CARD = "com.github.danwiseman.kafka.connect.scryfall.Card";

    // key schema
    public static final Schema KEY_SCHEMA = SchemaBuilder.struct().name(SCHEMA_KEY)
            .version(1)
            .field(CARD_ID_FIELD, STRING_SCHEMA)
            .build();

    public static final Schema CARD_COLORS_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();
    public static final Schema CARD_KEYWORDS_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();
    public static final Schema CARD_MULTIVERSE_IDS_SCHEMA = SchemaBuilder.array(INT32_SCHEMA).optional().build();
    public static final Schema CARD_FINISHES_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();
    public static final Schema CARD_FRAME_EFFECTS_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();
    public static final Schema CARD_GAMES_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();
    public static final Schema CARD_PROMO_TYPES_SCHEMA = SchemaBuilder.array(STRING_SCHEMA).optional().build();



    // related uris schema
    public static final Schema RELATED_URIS_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_RELATED_URIS)
            .version(1)
            .field(CARD_RELATED_URIS_GATHERER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_RELATED_URIS_EDHREC, OPTIONAL_STRING_SCHEMA)
            .field(CARD_RELATED_URIS_MTGTOP8, OPTIONAL_STRING_SCHEMA)
            .field(CARD_RELATED_URIS_TCG_INF_ART, OPTIONAL_STRING_SCHEMA)
            .field(CARD_RELATED_URIS_TCG_ING_DECKS, OPTIONAL_STRING_SCHEMA)
            .optional()
            .build();

    // purchase uris schema
    public static final Schema PURCHASE_URIS_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_PURCHASE_URIS)
            .version(1)
            .field(CARD_PURCHASE_URIS_CARDHOARDER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PURCHASE_URIS_CARDMARKET, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PURCHASE_URIS_TCGPLAYER, OPTIONAL_STRING_SCHEMA)
            .optional()
            .build();

    // prices schema
    public static final Schema PRICES_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_PRICES)
            .version(1)
            .field(CARD_PRICES_USD, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRICES_USD_FOIL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRICES_USD_ETCHED, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRICES_EUR, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRICES_EUR_FOIL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRICES_TIX, OPTIONAL_STRING_SCHEMA)
            .optional()
            .build();

    public static final Schema IMAGE_URIS_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_IMAGE_URIS)
            .version(1)
            .field(CARD_IMAGE_URI_PNG, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_URI_BORDER_CROP, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_URI_ART_CROP, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_URI_LARGE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_URI_NORMAL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_URI_SMALL, OPTIONAL_STRING_SCHEMA)
            .optional()
            .build();

    public static final Schema CARD_FACE_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_CARD_FACES)
            .version(1)
            .field(CARD_FACE_ARTIST, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_CMC, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_COLOR_INDICATOR, CARD_COLORS_SCHEMA)
            .field(CARD_FACE_COLORS, CARD_COLORS_SCHEMA)
            .field(CARD_FACE_FLAVOR_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_ILLUSTRATION_ID, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_LAYOUT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_LOYALTY, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_MANA_COST, STRING_SCHEMA)
            .field(CARD_FACE_NAME, STRING_SCHEMA)
            .field(CARD_FACE_OBJECT, STRING_SCHEMA)
            .field(CARD_FACE_ORACLE_ID, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_ORACLE_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_POWER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_PRINTED_NAME, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_PRINTED_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_PRINTED_TYPE_LINE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_TOUGHNESS, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_TYPE_LINE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_WATERMARK, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FACE_IMAGE_URIS, IMAGE_URIS_SCHEMA)
            .optional()
            .build();

    public static final Schema CARD_FACES_SCHEMA = SchemaBuilder.array(CARD_FACE_SCHEMA).optional().build();

    public static final Schema ALL_PART_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_ALL_PARTS)
            .field(CARD_ALL_PARTS_ID, OPTIONAL_STRING_SCHEMA)
            .field(CARD_ALL_PARTS_OBJECT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_ALL_PARTS_COMPONENT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_ALL_PARTS_NAME, OPTIONAL_STRING_SCHEMA)
            .field(CARD_ALL_PARTS_TYPE_LINE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_ALL_PARTS_URI, OPTIONAL_STRING_SCHEMA)
            .optional()
            .build();
    public static final Schema ALL_PARTS_SCHEMA = SchemaBuilder.array(ALL_PART_SCHEMA).optional().build();

    public static final Schema LEGALITIES_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_LEGALITIES)
            .field(CARD_LEGALITIES_STANDARD, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_FUTURE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_HISTORIC, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_GLADIATOR, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_PIONEER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_MODERN, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_LEGACY, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_PAUPER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_VINTAGE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_PENNY, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_COMMANDER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_BRAWL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_HISTORICALBRAWL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_ALCHEMY, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_PAUPERCOMMANDER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_DUEL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_OLDSCHOOL, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LEGALITIES_PREMODERN, OPTIONAL_STRING_SCHEMA)
            .build();

    // full card
    public static final Schema VALUE_SCHEMA = SchemaBuilder.struct().name(SCHEMA_VALUE_CARD)
            .version(1)
            .field(CARD_ID_FIELD, STRING_SCHEMA)
            .field(CARD_LANG_FIELD, STRING_SCHEMA)
            .field(CARD_ARENA_ID_FIELD, OPTIONAL_INT32_SCHEMA)
            .field(CARD_MTGO_ID, OPTIONAL_INT32_SCHEMA)
            .field(CARD_MTGO_FOIL_ID, OPTIONAL_INT32_SCHEMA)
            .field(CARD_MULTIVERSE_IDS, CARD_MULTIVERSE_IDS_SCHEMA)
            .field(CARD_OBJECT, STRING_SCHEMA)
            .field(CARD_ORACLE_ID, STRING_SCHEMA)
            .field(CARD_PRINTS_SEARCH_URI, STRING_SCHEMA)
            .field(CARD_RULINGS_URI, STRING_SCHEMA)
            .field(CARD_SCRYFALL_URI, STRING_SCHEMA)
            .field(CARD_URI, STRING_SCHEMA)
            .field(CARD_ALL_PARTS, ALL_PARTS_SCHEMA)
            .field(CARD_FACES, CARD_FACES_SCHEMA)
            .field(CARD_CMC, OPTIONAL_STRING_SCHEMA)
            .field(CARD_COLOR_IDENTITY, CARD_COLORS_SCHEMA)
            .field(CARD_COLOR_INDICATOR, CARD_COLORS_SCHEMA)
            .field(CARD_COLORS, CARD_COLORS_SCHEMA)
            .field(CARD_EDHREC_RANK, OPTIONAL_INT32_SCHEMA)
            .field(CARD_HAND_MODIFIER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_KEYWORDS, CARD_KEYWORDS_SCHEMA)
            .field(CARD_LAYOUT, STRING_SCHEMA)
            .field(CARD_LEGALITIES, LEGALITIES_SCHEMA)
            .field(CARD_LIFE_MODIFIER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_LOYALTY, OPTIONAL_STRING_SCHEMA)
            .field(CARD_MANA_COST, OPTIONAL_STRING_SCHEMA)
            .field(CARD_NAME, STRING_SCHEMA)
            .field(CARD_ORACLE_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_OVERSIZED, BOOLEAN_SCHEMA)
            .field(CARD_POWER, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRODUCED_MANA, OPTIONAL_STRING_SCHEMA)
            .field(CARD_RESERVED, BOOLEAN_SCHEMA)
            .field(CARD_TOUGHNESS, OPTIONAL_STRING_SCHEMA)
            .field(CARD_TYPE_LINE, STRING_SCHEMA)
            .field(CARD_ARTIST, OPTIONAL_STRING_SCHEMA)
            .field(CARD_BOOSTER, BOOLEAN_SCHEMA)
            .field(CARD_BORDER_COLOR, STRING_SCHEMA)
            .field(CARD_BACK_ID, STRING_SCHEMA)
            .field(CARD_COLLECTOR_NUMBER, STRING_SCHEMA)
            .field(CARD_CONTENT_WARNING, OPTIONAL_BOOLEAN_SCHEMA)
            .field(CARD_DIGITAL, BOOLEAN_SCHEMA)
            .field(CARD_FINISHES, CARD_FINISHES_SCHEMA)
            .field(CARD_FLAVOR_NAME, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FLAVOR_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_FRAME_EFFECTS, CARD_FRAME_EFFECTS_SCHEMA)
            .field(CARD_FRAME, STRING_SCHEMA)
            .field(CARD_FULL_ART, BOOLEAN_SCHEMA)
            .field(CARD_GAMES, CARD_GAMES_SCHEMA)
            .field(CARD_HIGHRES_IMAGE, BOOLEAN_SCHEMA)
            .field(CARD_ILLUSTRATION_ID, OPTIONAL_STRING_SCHEMA)
            .field(CARD_IMAGE_STATUS, STRING_SCHEMA)
            .field(CARD_IMAGE_URIS, IMAGE_URIS_SCHEMA)
            .field(CARD_PRICES, PRICES_SCHEMA)
            .field(CARD_PRINTED_NAME, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRINTED_TEXT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PRINTED_TYPE_LINE, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PROMO, BOOLEAN_SCHEMA)
            .field(CARD_PROMO_TYPES, CARD_PROMO_TYPES_SCHEMA)
            .field(CARD_PURCHASE_URIS, PURCHASE_URIS_SCHEMA)
            .field(CARD_RARITY, STRING_SCHEMA)
            .field(CARD_RELATED_URIS, RELATED_URIS_SCHEMA)
            .field(CARD_RELEASED_AT, STRING_SCHEMA)
            .field(CARD_REPRINT, BOOLEAN_SCHEMA)
            .field(CARD_SCRYFALL_SET_URI, STRING_SCHEMA)
            .field(CARD_SET_NAME, STRING_SCHEMA)
            .field(CARD_SET_SEARCH_URI, STRING_SCHEMA)
            .field(CARD_SET_TYPE, STRING_SCHEMA)
            .field(CARD_SET_URI, STRING_SCHEMA)
            .field(CARD_SET, STRING_SCHEMA)
            .field(CARD_SET_ID, STRING_SCHEMA)
            .field(CARD_STORY_SPOTLIGHT, BOOLEAN_SCHEMA)
            .field(CARD_TEXTLESS, BOOLEAN_SCHEMA)
            .field(CARD_VARIATION, BOOLEAN_SCHEMA)
            .field(CARD_VARIATION_OF, OPTIONAL_STRING_SCHEMA)
            .field(CARD_SECURITY_STAMP, OPTIONAL_STRING_SCHEMA)
            .field(CARD_WATERMARK, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PREVIEW_PREVIEWED_AT, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PREVIEW_SOURCE_URI, OPTIONAL_STRING_SCHEMA)
            .field(CARD_PREVIEW_SOURCE, OPTIONAL_STRING_SCHEMA)
            .build();

}
