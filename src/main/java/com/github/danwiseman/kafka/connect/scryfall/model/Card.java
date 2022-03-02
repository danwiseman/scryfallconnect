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

    // TODO: ALL PARTS HERE

    // TODO: CARD FACES HERE

    private Integer cmc;
    private String color_identity;
    private String color_indicator;
    private String colors;
    private Integer edhrec_rank;
    private String hand_modifier;
    private String keywords;
    private String layout;

    // TODO: LEGALITIES HERE

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

    // TODO: IMAGE URIS HERE

    // TODO: PRICES HERE

    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private Boolean promo;
    private String promo_types;

    // TODO: PURCHASE URIS HERE

    private String rarity;

    // TODO: RELATED URIS HERE

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
     * @param cmc
     * @param color_identity
     * @param color_indicator
     * @param colors
     * @param edhrec_rank
     * @param hand_modifier
     * @param keywords
     * @param layout
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
     * @param printed_name
     * @param printed_text
     * @param printed_type_line
     * @param promo
     * @param promo_types
     * @param rarity
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
                String rulings_uri, String scryfall_uri, String uri, Integer cmc, String color_identity,
                String color_indicator, String colors, Integer edhrec_rank, String hand_modifier, String keywords,
                String layout, String life_modifier, String loyalty, String mana_cost, String name, String oracle_text,
                Boolean oversized, String power, String produced_mana, Boolean reserved, String toughness, String type_line,
                String artist, Boolean booster, String border_color, String back_id, String collector_number,
                Boolean content_warning, Boolean digital, String finishes, String flavor_name, String flavor_text,
                String frame_effects, String frame, Boolean full_art, String games, Boolean highres_image, String illustration_id,
                String image_status, String printed_name, String printed_text, String printed_type_line, Boolean promo,
                String promo_types, String rarity, String released_at, Boolean reprint, String scryfall_set_uri, String set_name,
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
        this.cmc = cmc;
        this.color_identity = color_identity;
        this.color_indicator = color_indicator;
        this.colors = colors;
        this.edhrec_rank = edhrec_rank;
        this.hand_modifier = hand_modifier;
        this.keywords = keywords;
        this.layout = layout;
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
        this.printed_name = printed_name;
        this.printed_text = printed_text;
        this.printed_type_line = printed_type_line;
        this.promo = promo;
        this.promo_types = promo_types;
        this.rarity = rarity;
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
}
