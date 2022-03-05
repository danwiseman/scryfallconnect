package com.github.danwiseman.kafka.connect.scryfall.model;

import org.json.JSONObject;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSchemas.*;

public class Card_Purchase_Uris {

    private String tcgplayer;
    private String cardmarket;
    private String cardhoarder;

    public  Card_Purchase_Uris() {

    }

    public Card_Purchase_Uris(String tcgplayer, String cardmarket, String cardhoarder) {
        this.tcgplayer = tcgplayer;
        this.cardmarket = cardmarket;
        this.cardhoarder = cardhoarder;
    }

    public static Card_Purchase_Uris fromJson(JSONObject jsonObject) {
        Card_Purchase_Uris card_purchase_uris = new Card_Purchase_Uris();

        card_purchase_uris.setCardhoarder(jsonObject.getString(CARD_PURCHASE_URIS_CARDHOARDER));
        card_purchase_uris.setCardmarket(jsonObject.getString(CARD_PURCHASE_URIS_CARDMARKET));
        card_purchase_uris.setTcgplayer(jsonObject.getString(CARD_PURCHASE_URIS_TCGPLAYER));

        return card_purchase_uris;
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
