package com.github.danwiseman.kafka.connect.scryfall.model;

public class Card_Purchase_Uris {

    private String tcgplayer;
    private String cardmarket;
    private String cardhoarder;


    public Card_Purchase_Uris(String tcgplayer, String cardmarket, String cardhoarder) {
        this.tcgplayer = tcgplayer;
        this.cardmarket = cardmarket;
        this.cardhoarder = cardhoarder;
    }

    public String getTcgplayer() {
        return tcgplayer;
    }

    public void setTcgplayer(String tcgplayer) {
        this.tcgplayer = tcgplayer;
    }

    public String getCardmarket() {
        return cardmarket;
    }

    public void setCardmarket(String cardmarket) {
        this.cardmarket = cardmarket;
    }

    public String getCardhoarder() {
        return cardhoarder;
    }

    public void setCardhoarder(String cardhoarder) {
        this.cardhoarder = cardhoarder;
    }
}
