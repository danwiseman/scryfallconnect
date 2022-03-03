package com.github.danwiseman.kafka.connect.scryfall.model;

public class Card {

    private String id;
    private String lang;
    private Integer arena_id;
    private Integer mtgo_id;
    private Integer mtgo_foil_id;
    private Integer[] multiverse_ids;
    private String object;
    private String oracle_id;
    private String prints_search_uri;
    private String rulings_uri;
    private String scryfall_uri;
    private String uri;

    // all parts
    private Card_All_Parts[] all_parts;

    // card faces
    private Card_Face[] card_faces;

    private Integer cmc;
    private String color_identity;
    private String color_indicator;
    private String colors;
    private Integer edhrec_rank;
    private String hand_modifier;
    private String keywords;
    private String layout;

    private Card_Legalities legalities;

    private String life_modifier;
    private String loyalty;
    private String mana_cost;
    private String name;
    private String oracle_text;
    private Boolean oversized;
    private String power;
    private String produced_mana;
    private Boolean reserved;
    private String toughness;
    private String type_line;
    private String artist;
    private Boolean booster;
    private String border_color;
    private String back_id;
    private String collector_number;
    private Boolean content_warning;
    private Boolean digital;
    private String finishes;
    private String flavor_name;
    private String flavor_text;
    private String frame_effects;
    private String frame;
    private Boolean full_art;
    private String games;
    private Boolean highres_image;
    private String illustration_id;
    private String image_status;

    private Card_Image_Uris image_uris;

    private Card_Prices prices;

    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private Boolean promo;
    private String promo_types;

    private Card_Purchase_Uris purchase_uris;

    private String rarity;

    private Card_Related_Uris related_uris;

    private String released_at;
    private Boolean reprint;
    private String scryfall_set_uri;
    private String set_name;
    private String set_search_uri;
    private String set_type;
    private String set_uri;
    private String set;
    private String set_id;
    private Boolean story_spotlight;
    private Boolean textless;
    private Boolean variation;
    private String variation_of;
    private String security_stamp;
    private String watermark;
    private String preview_previewed_at;
    private String preview_source_uri;
    private String preview_source;


    /**
     * @param id
     * @param arena_id
     * @param lang
     * @param mtgo_id
     * @param mtgo_foil_id
     * @param multiverse_ids
     * @param object
     * @param oracle_id
     * @param prints_search_uri
     * @param rulings_uri
     * @param scryfall_uri
     * @param uri
     * @param all_parts
     * @param card_faces
     * @param cmc
     * @param color_identity
     * @param color_indicator
     * @param colors
     * @param edhrec_rank
     * @param hand_modifier
     * @param keywords
     * @param layout
     * @param legalities
     * @param life_modifier
     * @param loyalty
     * @param mana_cost
     * @param name
     * @param oracle_text
     * @param oversized
     * @param power
     * @param produced_mana
     * @param reserved
     * @param toughness
     * @param type_line
     * @param artist
     * @param booster
     * @param border_color
     * @param back_id
     * @param collector_number
     * @param content_warning
     * @param digital
     * @param finishes
     * @param flavor_name
     * @param flavor_text
     * @param frame_effects
     * @param frame
     * @param full_art
     * @param games
     * @param highres_image
     * @param illustration_id
     * @param image_status
     * @param image_uris
     * @param prices
     * @param printed_name
     * @param printed_text
     * @param printed_type_line
     * @param promo
     * @param promo_types
     * @param purchase_uris
     * @param rarity
     * @param related_uris
     * @param released_at
     * @param reprint
     * @param scryfall_set_uri
     * @param set_name
     * @param set_search_uri
     * @param set_type
     * @param set_uri
     * @param set
     * @param set_id
     * @param story_spotlight
     * @param textless
     * @param variation
     * @param variation_of
     * @param security_stamp
     * @param watermark
     * @param preview_previewed_at
     * @param preview_source_uri
     * @param preview_source
     */
    public Card(String id, Integer arena_id, String lang, Integer mtgo_id, Integer mtgo_foil_id,
                Integer[] multiverse_ids, String object, String oracle_id, String prints_search_uri,
                String rulings_uri, String scryfall_uri, String uri, Card_All_Parts[] all_parts, Card_Face[] card_faces, Integer cmc, String color_identity,
                String color_indicator, String colors, Integer edhrec_rank, String hand_modifier, String keywords,
                String layout, Card_Legalities legalities, String life_modifier, String loyalty, String mana_cost, String name, String oracle_text,
                Boolean oversized, String power, String produced_mana, Boolean reserved, String toughness, String type_line,
                String artist, Boolean booster, String border_color, String back_id, String collector_number,
                Boolean content_warning, Boolean digital, String finishes, String flavor_name, String flavor_text,
                String frame_effects, String frame, Boolean full_art, String games, Boolean highres_image, String illustration_id,
                String image_status, Card_Image_Uris image_uris, Card_Prices prices, String printed_name, String printed_text, String printed_type_line, Boolean promo,
                String promo_types, Card_Purchase_Uris purchase_uris, String rarity, Card_Related_Uris related_uris, String released_at, Boolean reprint, String scryfall_set_uri, String set_name,
                String set_search_uri, String set_type, String set_uri, String set, String set_id, Boolean story_spotlight,
                Boolean textless, Boolean variation, String variation_of, String security_stamp, String watermark, String preview_previewed_at,
                String preview_source_uri, String preview_source)
    {
        this.id = id;
        this.arena_id = arena_id;
        this.lang = lang;
        this.mtgo_id = mtgo_id;
        this.mtgo_foil_id = mtgo_foil_id;
        this.multiverse_ids = multiverse_ids;
        this.object = object;
        this.oracle_id = oracle_id;
        this.prints_search_uri = prints_search_uri;
        this.rulings_uri = rulings_uri;
        this.scryfall_uri = scryfall_uri;
        this.uri = uri;
        this.all_parts = all_parts;
        this.card_faces = card_faces;
        this.cmc = cmc;
        this.color_identity = color_identity;
        this.color_indicator = color_indicator;
        this.colors = colors;
        this.edhrec_rank = edhrec_rank;
        this.hand_modifier = hand_modifier;
        this.keywords = keywords;
        this.layout = layout;
        this.legalities = legalities;
        this.life_modifier = life_modifier;
        this.loyalty = loyalty;
        this.mana_cost = mana_cost;
        this.name = name;
        this.oracle_text = oracle_text;
        this.oversized = oversized;
        this.power = power;
        this.produced_mana = produced_mana;
        this.reserved = reserved;
        this.toughness = toughness;
        this.type_line = type_line;
        this.artist = artist;
        this.booster = booster;
        this.border_color = border_color;
        this.back_id = back_id;
        this.collector_number = collector_number;
        this.content_warning = content_warning;
        this.digital = digital;
        this.finishes = finishes;
        this.flavor_name = flavor_name;
        this.flavor_text = flavor_text;
        this.frame_effects = frame_effects;
        this.frame = frame;
        this.full_art = full_art;
        this.games = games;
        this.highres_image = highres_image;
        this.illustration_id = illustration_id;
        this.image_status = image_status;
        this.image_uris = image_uris;
        this.prices = prices;
        this.printed_name = printed_name;
        this.printed_text = printed_text;
        this.printed_type_line = printed_type_line;
        this.promo = promo;
        this.promo_types = promo_types;
        this.purchase_uris = purchase_uris;
        this.rarity = rarity;
        this.related_uris = related_uris;
        this.released_at = released_at;
        this.reprint = reprint;
        this.scryfall_set_uri = scryfall_set_uri;
        this.set_name = set_name;
        this.set_search_uri = set_search_uri;
        this.set_type = set_type;
        this.set_uri = set_uri;
        this.set = set;
        this.set_id = set_id;
        this.story_spotlight = story_spotlight;
        this.textless = textless;
        this.variation = variation;
        this.variation_of = variation_of;
        this.security_stamp = security_stamp;
        this.watermark = watermark;
        this.preview_previewed_at = preview_previewed_at;
        this.preview_source_uri = preview_source_uri;
        this.preview_source = preview_source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getArena_id() {
        return arena_id;
    }

    public void setArena_id(Integer arena_id) {
        this.arena_id = arena_id;
    }

    public Integer getMtgo_id() {
        return mtgo_id;
    }

    public void setMtgo_id(Integer mtgo_id) {
        this.mtgo_id = mtgo_id;
    }

    public Integer getMtgo_foil_id() {
        return mtgo_foil_id;
    }

    public void setMtgo_foil_id(Integer mtgo_foil_id) {
        this.mtgo_foil_id = mtgo_foil_id;
    }

    public Integer[] getMultiverse_ids() {
        return multiverse_ids;
    }

    public void setMultiverse_ids(Integer[] multiverse_ids) {
        this.multiverse_ids = multiverse_ids;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOracle_id() {
        return oracle_id;
    }

    public void setOracle_id(String oracle_id) {
        this.oracle_id = oracle_id;
    }

    public String getPrints_search_uri() {
        return prints_search_uri;
    }

    public void setPrints_search_uri(String prints_search_uri) {
        this.prints_search_uri = prints_search_uri;
    }

    public String getRulings_uri() {
        return rulings_uri;
    }

    public void setRulings_uri(String rulings_uri) {
        this.rulings_uri = rulings_uri;
    }

    public String getScryfall_uri() {
        return scryfall_uri;
    }

    public void setScryfall_uri(String scryfall_uri) {
        this.scryfall_uri = scryfall_uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getCmc() {
        return cmc;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public String getColor_identity() {
        return color_identity;
    }

    public void setColor_identity(String color_identity) {
        this.color_identity = color_identity;
    }

    public String getColor_indicator() {
        return color_indicator;
    }

    public void setColor_indicator(String color_indicator) {
        this.color_indicator = color_indicator;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getEdhrec_rank() {
        return edhrec_rank;
    }

    public void setEdhrec_rank(Integer edhrec_rank) {
        this.edhrec_rank = edhrec_rank;
    }

    public String getHand_modifier() {
        return hand_modifier;
    }

    public void setHand_modifier(String hand_modifier) {
        this.hand_modifier = hand_modifier;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLife_modifier() {
        return life_modifier;
    }

    public void setLife_modifier(String life_modifier) {
        this.life_modifier = life_modifier;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOracle_text() {
        return oracle_text;
    }

    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }

    public Boolean getOversized() {
        return oversized;
    }

    public void setOversized(Boolean oversized) {
        this.oversized = oversized;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getProduced_mana() {
        return produced_mana;
    }

    public void setProduced_mana(String produced_mana) {
        this.produced_mana = produced_mana;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.type_line = type_line;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Boolean getBooster() {
        return booster;
    }

    public void setBooster(Boolean booster) {
        this.booster = booster;
    }

    public String getBorder_color() {
        return border_color;
    }

    public void setBorder_color(String border_color) {
        this.border_color = border_color;
    }

    public String getBack_id() {
        return back_id;
    }

    public void setBack_id(String back_id) {
        this.back_id = back_id;
    }

    public String getCollector_number() {
        return collector_number;
    }

    public void setCollector_number(String collector_number) {
        this.collector_number = collector_number;
    }

    public Boolean getContent_warning() {
        return content_warning;
    }

    public void setContent_warning(Boolean content_warning) {
        this.content_warning = content_warning;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public String getFinishes() {
        return finishes;
    }

    public void setFinishes(String finishes) {
        this.finishes = finishes;
    }

    public String getFlavor_name() {
        return flavor_name;
    }

    public void setFlavor_name(String flavor_name) {
        this.flavor_name = flavor_name;
    }

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public String getFrame_effects() {
        return frame_effects;
    }

    public void setFrame_effects(String frame_effects) {
        this.frame_effects = frame_effects;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public Boolean getFull_art() {
        return full_art;
    }

    public void setFull_art(Boolean full_art) {
        this.full_art = full_art;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public Boolean getHighres_image() {
        return highres_image;
    }

    public void setHighres_image(Boolean highres_image) {
        this.highres_image = highres_image;
    }

    public String getIllustration_id() {
        return illustration_id;
    }

    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }

    public String getImage_status() {
        return image_status;
    }

    public void setImage_status(String image_status) {
        this.image_status = image_status;
    }

    public String getPrinted_name() {
        return printed_name;
    }

    public void setPrinted_name(String printed_name) {
        this.printed_name = printed_name;
    }

    public String getPrinted_text() {
        return printed_text;
    }

    public void setPrinted_text(String printed_text) {
        this.printed_text = printed_text;
    }

    public String getPrinted_type_line() {
        return printed_type_line;
    }

    public void setPrinted_type_line(String printed_type_line) {
        this.printed_type_line = printed_type_line;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public String getPromo_types() {
        return promo_types;
    }

    public void setPromo_types(String promo_types) {
        this.promo_types = promo_types;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getReleased_at() {
        return released_at;
    }

    public void setReleased_at(String released_at) {
        this.released_at = released_at;
    }

    public Boolean getReprint() {
        return reprint;
    }

    public void setReprint(Boolean reprint) {
        this.reprint = reprint;
    }

    public String getScryfall_set_uri() {
        return scryfall_set_uri;
    }

    public void setScryfall_set_uri(String scryfall_set_uri) {
        this.scryfall_set_uri = scryfall_set_uri;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String getSet_search_uri() {
        return set_search_uri;
    }

    public void setSet_search_uri(String set_search_uri) {
        this.set_search_uri = set_search_uri;
    }

    public String getSet_type() {
        return set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public String getSet_uri() {
        return set_uri;
    }

    public void setSet_uri(String set_uri) {
        this.set_uri = set_uri;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSet_id() {
        return set_id;
    }

    public void setSet_id(String set_id) {
        this.set_id = set_id;
    }

    public Boolean getStory_spotlight() {
        return story_spotlight;
    }

    public void setStory_spotlight(Boolean story_spotlight) {
        this.story_spotlight = story_spotlight;
    }

    public Boolean getTextless() {
        return textless;
    }

    public void setTextless(Boolean textless) {
        this.textless = textless;
    }

    public Boolean getVariation() {
        return variation;
    }

    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    public String getVariation_of() {
        return variation_of;
    }

    public void setVariation_of(String variation_of) {
        this.variation_of = variation_of;
    }

    public String getSecurity_stamp() {
        return security_stamp;
    }

    public void setSecurity_stamp(String security_stamp) {
        this.security_stamp = security_stamp;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getPreview_previewed_at() {
        return preview_previewed_at;
    }

    public void setPreview_previewed_at(String preview_previewed_at) {
        this.preview_previewed_at = preview_previewed_at;
    }

    public String getPreview_source_uri() {
        return preview_source_uri;
    }

    public void setPreview_source_uri(String preview_source_uri) {
        this.preview_source_uri = preview_source_uri;
    }

    public String getPreview_source() {
        return preview_source;
    }

    public void setPreview_source(String preview_source) {
        this.preview_source = preview_source;
    }

    public Card_All_Parts[] getAll_parts() {
        return all_parts;
    }

    public void setAll_parts(Card_All_Parts[] all_parts) {
        this.all_parts = all_parts;
    }

    public Card_Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Card_Legalities legalities) {
        this.legalities = legalities;
    }

    public Card_Face[] getCard_faces() {
        return card_faces;
    }

    public void setCard_faces(Card_Face[] card_faces) {
        this.card_faces = card_faces;
    }

    public Card_Image_Uris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(Card_Image_Uris image_uris) {
        this.image_uris = image_uris;
    }

    public Card_Prices getPrices() {
        return prices;
    }

    public void setPrices(Card_Prices prices) {
        this.prices = prices;
    }

    public Card_Purchase_Uris getPurchase_uris() {
        return purchase_uris;
    }

    public void setPurchase_uris(Card_Purchase_Uris purchase_uris) {
        this.purchase_uris = purchase_uris;
    }

    public Card_Related_Uris getRelated_uris() {
        return related_uris;
    }

    public void setRelated_uris(Card_Related_Uris related_uris) {
        this.related_uris = related_uris;
    }
}
