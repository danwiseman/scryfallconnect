package com.github.danwiseman.kafka.connect.scryfall.model;

public class Card_Image_Uris {

    private String png;
    private String border_crop;
    private String art_crop;
    private String large;
    private String normal;
    private String small;


    public Card_Image_Uris(String png, String border_crop, String art_crop, String large, String normal, String small) {
        this.png = png;
        this.border_crop = border_crop;
        this.art_crop = art_crop;
        this.large = large;
        this.normal = normal;
        this.small = small;
    }


    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getBorder_crop() {
        return border_crop;
    }

    public void setBorder_crop(String border_crop) {
        this.border_crop = border_crop;
    }

    public String getArt_crop() {
        return art_crop;
    }

    public void setArt_crop(String art_crop) {
        this.art_crop = art_crop;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
