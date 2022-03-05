package com.github.danwiseman.kafka.connect.scryfall.model;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private String cardStr = "{\n" +
            "  \"object\": \"card\",\n" +
            "  \"id\": \"f8e702db-8c73-4947-9c13-5dcb50f4efab\",\n" +
            "  \"oracle_id\": \"0925e112-c089-4aa4-9878-6d6fb0a263c8\",\n" +
            "  \"multiverse_ids\": [\n" +
            "    417743\n" +
            "  ],\n" +
            "  \"mtgo_id\": 61727,\n" +
            "  \"mtgo_foil_id\": 61728,\n" +
            "  \"tcgplayer_id\": 123172,\n" +
            "  \"cardmarket_id\": 292859,\n" +
            "  \"name\": \"Take Down\",\n" +
            "  \"lang\": \"en\",\n" +
            "  \"released_at\": \"2016-09-30\",\n" +
            "  \"uri\": \"https://api.scryfall.com/cards/f8e702db-8c73-4947-9c13-5dcb50f4efab\",\n" +
            "  \"scryfall_uri\": \"https://scryfall.com/card/kld/170/take-down?utm_source=api\",\n" +
            "  \"layout\": \"normal\",\n" +
            "  \"highres_image\": true,\n" +
            "  \"image_status\": \"highres_scan\",\n" +
            "  \"image_uris\": {\n" +
            "    \"small\": \"https://c1.scryfall.com/file/scryfall-cards/small/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.jpg?1576382690\",\n" +
            "    \"normal\": \"https://c1.scryfall.com/file/scryfall-cards/normal/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.jpg?1576382690\",\n" +
            "    \"large\": \"https://c1.scryfall.com/file/scryfall-cards/large/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.jpg?1576382690\",\n" +
            "    \"png\": \"https://c1.scryfall.com/file/scryfall-cards/png/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.png?1576382690\",\n" +
            "    \"art_crop\": \"https://c1.scryfall.com/file/scryfall-cards/art_crop/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.jpg?1576382690\",\n" +
            "    \"border_crop\": \"https://c1.scryfall.com/file/scryfall-cards/border_crop/front/f/8/f8e702db-8c73-4947-9c13-5dcb50f4efab.jpg?1576382690\"\n" +
            "  },\n" +
            "  \"mana_cost\": \"{G}\",\n" +
            "  \"cmc\": 1.0,\n" +
            "  \"type_line\": \"Sorcery\",\n" +
            "  \"oracle_text\": \"Choose one —\\n• Take Down deals 4 damage to target creature with flying.\\n• Take Down deals 1 damage to each creature with flying.\",\n" +
            "  \"colors\": [\n" +
            "    \"G\"\n" +
            "  ],\n" +
            "  \"color_identity\": [\n" +
            "    \"G\"\n" +
            "  ],\n" +
            "  \"keywords\": [\n" +
            "\n" +
            "  ],\n" +
            "  \"legalities\": {\n" +
            "    \"standard\": \"not_legal\",\n" +
            "    \"future\": \"not_legal\",\n" +
            "    \"historic\": \"not_legal\",\n" +
            "    \"gladiator\": \"not_legal\",\n" +
            "    \"pioneer\": \"legal\",\n" +
            "    \"modern\": \"legal\",\n" +
            "    \"legacy\": \"legal\",\n" +
            "    \"pauper\": \"legal\",\n" +
            "    \"vintage\": \"legal\",\n" +
            "    \"penny\": \"legal\",\n" +
            "    \"commander\": \"legal\",\n" +
            "    \"brawl\": \"not_legal\",\n" +
            "    \"historicbrawl\": \"not_legal\",\n" +
            "    \"alchemy\": \"not_legal\",\n" +
            "    \"paupercommander\": \"legal\",\n" +
            "    \"duel\": \"legal\",\n" +
            "    \"oldschool\": \"not_legal\",\n" +
            "    \"premodern\": \"not_legal\"\n" +
            "  },\n" +
            "  \"games\": [\n" +
            "    \"paper\",\n" +
            "    \"mtgo\"\n" +
            "  ],\n" +
            "  \"reserved\": false,\n" +
            "  \"foil\": true,\n" +
            "  \"nonfoil\": true,\n" +
            "  \"finishes\": [\n" +
            "    \"nonfoil\",\n" +
            "    \"foil\"\n" +
            "  ],\n" +
            "  \"oversized\": false,\n" +
            "  \"promo\": false,\n" +
            "  \"reprint\": false,\n" +
            "  \"variation\": false,\n" +
            "  \"set_id\": \"d667e468-be8f-411f-a030-473d148deb74\",\n" +
            "  \"set\": \"kld\",\n" +
            "  \"set_name\": \"Kaladesh\",\n" +
            "  \"set_type\": \"expansion\",\n" +
            "  \"set_uri\": \"https://api.scryfall.com/sets/d667e468-be8f-411f-a030-473d148deb74\",\n" +
            "  \"set_search_uri\": \"https://api.scryfall.com/cards/search?order=set&q=e%3Akld&unique=prints\",\n" +
            "  \"scryfall_set_uri\": \"https://scryfall.com/sets/kld?utm_source=api\",\n" +
            "  \"rulings_uri\": \"https://api.scryfall.com/cards/f8e702db-8c73-4947-9c13-5dcb50f4efab/rulings\",\n" +
            "  \"prints_search_uri\": \"https://api.scryfall.com/cards/search?order=released&q=oracleid%3A0925e112-c089-4aa4-9878-6d6fb0a263c8&unique=prints\",\n" +
            "  \"collector_number\": \"170\",\n" +
            "  \"digital\": false,\n" +
            "  \"rarity\": \"common\",\n" +
            "  \"flavor_text\": \"The drake flew true. The arrow flew truer.\",\n" +
            "  \"card_back_id\": \"0aeebaf5-8c7d-4636-9e82-8c27447861f7\",\n" +
            "  \"artist\": \"Izzy\",\n" +
            "  \"artist_ids\": [\n" +
            "    \"2c3d2473-ff5d-4309-8194-e0b2def2ab65\"\n" +
            "  ],\n" +
            "  \"illustration_id\": \"49c38171-f55d-4108-8b08-6b62ad690cd4\",\n" +
            "  \"border_color\": \"black\",\n" +
            "  \"frame\": \"2015\",\n" +
            "  \"full_art\": false,\n" +
            "  \"textless\": false,\n" +
            "  \"booster\": true,\n" +
            "  \"story_spotlight\": false,\n" +
            "  \"edhrec_rank\": 18948,\n" +
            "  \"prices\": {\n" +
            "    \"usd\": \"0.02\",\n" +
            "    \"usd_foil\": \"0.04\",\n" +
            "    \"usd_etched\": null,\n" +
            "    \"eur\": \"0.01\",\n" +
            "    \"eur_foil\": \"0.10\",\n" +
            "    \"tix\": \"0.04\"\n" +
            "  },\n" +
            "  \"related_uris\": {\n" +
            "    \"gatherer\": \"https://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=417743\",\n" +
            "    \"tcgplayer_infinite_articles\": \"https://infinite.tcgplayer.com/search?contentMode=article&game=magic&partner=scryfall&q=Take+Down&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"tcgplayer_infinite_decks\": \"https://infinite.tcgplayer.com/search?contentMode=deck&game=magic&partner=scryfall&q=Take+Down&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"edhrec\": \"https://edhrec.com/route/?cc=Take+Down\",\n" +
            "    \"mtgtop8\": \"https://mtgtop8.com/search?MD_check=1&SB_check=1&cards=Take+Down\"\n" +
            "  },\n" +
            "  \"purchase_uris\": {\n" +
            "    \"tcgplayer\": \"https://shop.tcgplayer.com/product/productsearch?id=123172&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"cardmarket\": \"https://www.cardmarket.com/en/Magic/Products/Search?referrer=scryfall&searchString=Take+Down&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall\",\n" +
            "    \"cardhoarder\": \"https://www.cardhoarder.com/cards/61727?affiliate_id=scryfall&ref=card-profile&utm_campaign=affiliate&utm_medium=card&utm_source=scryfall\"\n" +
            "  }\n" +
            "}";

    private String cardStr2 = "{\n" +
            "  \"object\": \"card\",\n" +
            "  \"id\": \"50d4b0df-a1d8-494f-a019-70ce34161320\",\n" +
            "  \"oracle_id\": \"f227ce07-7e96-4a36-ab7c-9be6e777d649\",\n" +
            "  \"multiverse_ids\": [\n" +
            "    535002,\n" +
            "    535003\n" +
            "  ],\n" +
            "  \"mtgo_id\": 93418,\n" +
            "  \"arena_id\": 78573,\n" +
            "  \"tcgplayer_id\": 247801,\n" +
            "  \"cardmarket_id\": 574728,\n" +
            "  \"name\": \"Arlinn, the Pack's Hope // Arlinn, the Moon's Fury\",\n" +
            "  \"lang\": \"en\",\n" +
            "  \"released_at\": \"2021-09-24\",\n" +
            "  \"uri\": \"https://api.scryfall.com/cards/50d4b0df-a1d8-494f-a019-70ce34161320\",\n" +
            "  \"scryfall_uri\": \"https://scryfall.com/card/mid/211/arlinn-the-packs-hope-arlinn-the-moons-fury?utm_source=api\",\n" +
            "  \"layout\": \"transform\",\n" +
            "  \"highres_image\": true,\n" +
            "  \"image_status\": \"highres_scan\",\n" +
            "  \"cmc\": 4.0,\n" +
            "  \"type_line\": \"Legendary Planeswalker — Arlinn // Legendary Planeswalker — Arlinn\",\n" +
            "  \"color_identity\": [\n" +
            "    \"G\",\n" +
            "    \"R\"\n" +
            "  ],\n" +
            "  \"keywords\": [\n" +
            "    \"Daybound\",\n" +
            "    \"Nightbound\"\n" +
            "  ],\n" +
            "  \"produced_mana\": [\n" +
            "    \"G\",\n" +
            "    \"R\"\n" +
            "  ],\n" +
            "  \"card_faces\": [\n" +
            "    {\n" +
            "      \"object\": \"card_face\",\n" +
            "      \"name\": \"Arlinn, the Pack's Hope\",\n" +
            "      \"mana_cost\": \"{2}{R}{G}\",\n" +
            "      \"type_line\": \"Legendary Planeswalker — Arlinn\",\n" +
            "      \"oracle_text\": \"Daybound (If a player casts no spells during their own turn, it becomes night next turn.)\\n+1: Until your next turn, you may cast creature spells as though they had flash, and each creature you control enters the battlefield with an additional +1/+1 counter on it.\\n−3: Create two 2/2 green Wolf creature tokens.\",\n" +
            "      \"colors\": [\n" +
            "        \"G\",\n" +
            "        \"R\"\n" +
            "      ],\n" +
            "      \"loyalty\": \"4\",\n" +
            "      \"artist\": \"Anna Steinbauer\",\n" +
            "      \"artist_id\": \"3516496c-c279-4b56-8239-720683d03ae0\",\n" +
            "      \"illustration_id\": \"810f9359-c82f-4962-9f42-0d0a79ee4cae\",\n" +
            "      \"image_uris\": {\n" +
            "        \"small\": \"https://c1.scryfall.com/file/scryfall-cards/small/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"normal\": \"https://c1.scryfall.com/file/scryfall-cards/normal/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"large\": \"https://c1.scryfall.com/file/scryfall-cards/large/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"png\": \"https://c1.scryfall.com/file/scryfall-cards/png/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.png?1644855247\",\n" +
            "        \"art_crop\": \"https://c1.scryfall.com/file/scryfall-cards/art_crop/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"border_crop\": \"https://c1.scryfall.com/file/scryfall-cards/border_crop/front/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"object\": \"card_face\",\n" +
            "      \"name\": \"Arlinn, the Moon's Fury\",\n" +
            "      \"flavor_name\": \"\",\n" +
            "      \"mana_cost\": \"\",\n" +
            "      \"type_line\": \"Legendary Planeswalker — Arlinn\",\n" +
            "      \"oracle_text\": \"Nightbound (If a player casts at least two spells during their own turn, it becomes day next turn.)\\n+2: Add {R}{G}.\\n0: Until end of turn, Arlinn, the Moon's Fury becomes a 5/5 Werewolf creature with trample, indestructible, and haste.\",\n" +
            "      \"colors\": [\n" +
            "        \"G\",\n" +
            "        \"R\"\n" +
            "      ],\n" +
            "      \"color_indicator\": [\n" +
            "        \"G\",\n" +
            "        \"R\"\n" +
            "      ],\n" +
            "      \"loyalty\": \"4\",\n" +
            "      \"artist\": \"Anna Steinbauer\",\n" +
            "      \"artist_id\": \"3516496c-c279-4b56-8239-720683d03ae0\",\n" +
            "      \"illustration_id\": \"9d3b73cb-6d91-48f1-ab96-89971207556d\",\n" +
            "      \"image_uris\": {\n" +
            "        \"small\": \"https://c1.scryfall.com/file/scryfall-cards/small/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"normal\": \"https://c1.scryfall.com/file/scryfall-cards/normal/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"large\": \"https://c1.scryfall.com/file/scryfall-cards/large/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"png\": \"https://c1.scryfall.com/file/scryfall-cards/png/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.png?1644855247\",\n" +
            "        \"art_crop\": \"https://c1.scryfall.com/file/scryfall-cards/art_crop/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\",\n" +
            "        \"border_crop\": \"https://c1.scryfall.com/file/scryfall-cards/border_crop/back/5/0/50d4b0df-a1d8-494f-a019-70ce34161320.jpg?1644855247\"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"all_parts\": [\n" +
            "    {\n" +
            "      \"object\": \"related_card\",\n" +
            "      \"id\": \"50d4b0df-a1d8-494f-a019-70ce34161320\",\n" +
            "      \"component\": \"combo_piece\",\n" +
            "      \"name\": \"Arlinn, the Pack's Hope // Arlinn, the Moon's Fury\",\n" +
            "      \"type_line\": \"Legendary Planeswalker — Arlinn // Legendary Planeswalker — Arlinn\",\n" +
            "      \"uri\": \"https://api.scryfall.com/cards/50d4b0df-a1d8-494f-a019-70ce34161320\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"object\": \"related_card\",\n" +
            "      \"id\": \"364e04d9-9a8a-49df-921c-7a9bf62dc731\",\n" +
            "      \"component\": \"token\",\n" +
            "      \"name\": \"Wolf\",\n" +
            "      \"type_line\": \"Token Creature — Wolf\",\n" +
            "      \"uri\": \"https://api.scryfall.com/cards/364e04d9-9a8a-49df-921c-7a9bf62dc731\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"legalities\": {\n" +
            "    \"standard\": \"legal\",\n" +
            "    \"future\": \"legal\",\n" +
            "    \"historic\": \"legal\",\n" +
            "    \"gladiator\": \"legal\",\n" +
            "    \"pioneer\": \"legal\",\n" +
            "    \"modern\": \"legal\",\n" +
            "    \"legacy\": \"legal\",\n" +
            "    \"pauper\": \"not_legal\",\n" +
            "    \"vintage\": \"legal\",\n" +
            "    \"penny\": \"not_legal\",\n" +
            "    \"commander\": \"legal\",\n" +
            "    \"brawl\": \"legal\",\n" +
            "    \"historicbrawl\": \"legal\",\n" +
            "    \"alchemy\": \"legal\",\n" +
            "    \"paupercommander\": \"not_legal\",\n" +
            "    \"duel\": \"legal\",\n" +
            "    \"oldschool\": \"not_legal\",\n" +
            "    \"premodern\": \"not_legal\"\n" +
            "  },\n" +
            "  \"games\": [\n" +
            "    \"arena\",\n" +
            "    \"paper\",\n" +
            "    \"mtgo\"\n" +
            "  ],\n" +
            "  \"reserved\": false,\n" +
            "  \"foil\": true,\n" +
            "  \"nonfoil\": true,\n" +
            "  \"finishes\": [\n" +
            "    \"nonfoil\",\n" +
            "    \"foil\"\n" +
            "  ],\n" +
            "  \"oversized\": false,\n" +
            "  \"promo\": false,\n" +
            "  \"reprint\": false,\n" +
            "  \"variation\": false,\n" +
            "  \"set_id\": \"44b8eb8f-fa23-401a-98b5-1fbb9871128e\",\n" +
            "  \"set\": \"mid\",\n" +
            "  \"set_name\": \"Innistrad: Midnight Hunt\",\n" +
            "  \"set_type\": \"expansion\",\n" +
            "  \"set_uri\": \"https://api.scryfall.com/sets/44b8eb8f-fa23-401a-98b5-1fbb9871128e\",\n" +
            "  \"set_search_uri\": \"https://api.scryfall.com/cards/search?order=set&q=e%3Amid&unique=prints\",\n" +
            "  \"scryfall_set_uri\": \"https://scryfall.com/sets/mid?utm_source=api\",\n" +
            "  \"rulings_uri\": \"https://api.scryfall.com/cards/50d4b0df-a1d8-494f-a019-70ce34161320/rulings\",\n" +
            "  \"prints_search_uri\": \"https://api.scryfall.com/cards/search?order=released&q=oracleid%3Af227ce07-7e96-4a36-ab7c-9be6e777d649&unique=prints\",\n" +
            "  \"collector_number\": \"211\",\n" +
            "  \"digital\": false,\n" +
            "  \"rarity\": \"mythic\",\n" +
            "  \"artist\": \"Anna Steinbauer\",\n" +
            "  \"artist_ids\": [\n" +
            "    \"3516496c-c279-4b56-8239-720683d03ae0\"\n" +
            "  ],\n" +
            "  \"border_color\": \"black\",\n" +
            "  \"frame\": \"2015\",\n" +
            "  \"frame_effects\": [\n" +
            "    \"sunmoondfc\"\n" +
            "  ],\n" +
            "  \"security_stamp\": \"oval\",\n" +
            "  \"full_art\": false,\n" +
            "  \"textless\": false,\n" +
            "  \"booster\": true,\n" +
            "  \"story_spotlight\": false,\n" +
            "  \"edhrec_rank\": 4744,\n" +
            "  \"preview\": {\n" +
            "    \"source\": \"Wizards of the Coast\",\n" +
            "    \"source_uri\": \"https://twitter.com/wizards_magic/status/1433437059818131456\",\n" +
            "    \"previewed_at\": \"2021-09-02\"\n" +
            "  },\n" +
            "  \"prices\": {\n" +
            "    \"usd\": \"7.65\",\n" +
            "    \"usd_foil\": \"8.90\",\n" +
            "    \"usd_etched\": null,\n" +
            "    \"eur\": \"9.87\",\n" +
            "    \"eur_foil\": \"10.95\",\n" +
            "    \"tix\": \"2.82\"\n" +
            "  },\n" +
            "  \"related_uris\": {\n" +
            "    \"gatherer\": \"https://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=535002\",\n" +
            "    \"tcgplayer_infinite_articles\": \"https://infinite.tcgplayer.com/search?contentMode=article&game=magic&partner=scryfall&q=Arlinn%2C+the+Pack%27s+Hope+%2F%2F+Arlinn%2C+the+Moon%27s+Fury&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"tcgplayer_infinite_decks\": \"https://infinite.tcgplayer.com/search?contentMode=deck&game=magic&partner=scryfall&q=Arlinn%2C+the+Pack%27s+Hope+%2F%2F+Arlinn%2C+the+Moon%27s+Fury&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"edhrec\": \"https://edhrec.com/route/?cc=Arlinn%2C+the+Pack%27s+Hope\",\n" +
            "    \"mtgtop8\": \"https://mtgtop8.com/search?MD_check=1&SB_check=1&cards=Arlinn%2C+the+Pack%27s+Hope\"\n" +
            "  },\n" +
            "  \"purchase_uris\": {\n" +
            "    \"tcgplayer\": \"https://shop.tcgplayer.com/product/productsearch?id=247801&utm_campaign=affiliate&utm_medium=api&utm_source=scryfall\",\n" +
            "    \"cardmarket\": \"https://www.cardmarket.com/en/Magic/Products/Search?referrer=scryfall&searchString=Arlinn%2C+the+Pack%27s+Hope&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall\",\n" +
            "    \"cardhoarder\": \"https://www.cardhoarder.com/cards/93418?affiliate_id=scryfall&ref=card-profile&utm_campaign=affiliate&utm_medium=card&utm_source=scryfall\"\n" +
            "  }\n" +
            "}";
    private JSONObject cardJson = new JSONObject(cardStr);
    private JSONObject cardJson2 = new JSONObject(cardStr2);
    @Test
    public void canParseJson() {
        Card card = Card.fromJson(cardJson);
        // tests
        assertEquals(card.getId(), "f8e702db-8c73-4947-9c13-5dcb50f4efab");

        Card card2 = Card.fromJson(cardJson2);
        // tests
        assertEquals(card2.getCard_faces().size(), 2);
        assertEquals(card2.getAll_parts().size(), 2);
    }


}
