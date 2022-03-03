package com.github.danwiseman.kafka.connect.scryfall.model;

public class Card_Face {

    private String artist;
    private String cmc;
    private String color_indicator;
    private String colors;
    private String flavor_text;
    private String illustration_id;
    private String layout;
    private String mana_cost;
    private String name;
    private String object;
    private String oracle_id;
    private String oracle_text;
    private String power;
    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private String toughness;
    private String type_line;
    private String watermark;
    private Card_Image_Uris image_uris;


    public Card_Face(String artist, String cmc, String color_indicator, String colors, String flavor_text, String illustration_id, String layout, String mana_cost, String name, String object, String oracle_id, String oracle_text, String power, String printed_name, String printed_text, String printed_type_line, String toughness, String type_line, String watermark, Card_Image_Uris image_uris) {
        this.artist = artist;
        this.cmc = cmc;
        this.color_indicator = color_indicator;
        this.colors = colors;
        this.flavor_text = flavor_text;
        this.illustration_id = illustration_id;
        this.layout = layout;
        this.mana_cost = mana_cost;
        this.name = name;
        this.object = object;
        this.oracle_id = oracle_id;
        this.oracle_text = oracle_text;
        this.power = power;
        this.printed_name = printed_name;
        this.printed_text = printed_text;
        this.printed_type_line = printed_type_line;
        this.toughness = toughness;
        this.type_line = type_line;
        this.watermark = watermark;
        this.image_uris = image_uris;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCmc() {
        return cmc;
    }

    public void setCmc(String cmc) {
        this.cmc = cmc;
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

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public String getIllustration_id() {
        return illustration_id;
    }

    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
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

    public String getOracle_text() {
        return oracle_text;
    }

    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
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

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public Card_Image_Uris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(Card_Image_Uris image_uris) {
        this.image_uris = image_uris;
    }
}