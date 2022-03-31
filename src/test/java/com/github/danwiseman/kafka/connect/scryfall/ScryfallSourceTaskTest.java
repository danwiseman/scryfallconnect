package com.github.danwiseman.kafka.connect.scryfall;

import com.github.danwiseman.kafka.connect.scryfall.model.Card;
import com.github.danwiseman.kafka.connect.scryfall.utils.DateUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallAPIHttpClient.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSourceConnectorConfig.*;
import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSourceConnectorConfig.PULL_TYPE_CONFIG;

public class ScryfallSourceTaskTest {

  private ScryfallSourceTask scryfallSourceTask = new ScryfallSourceTask();
  private Integer results_size = 175;
  private static final Logger log = LoggerFactory.getLogger(ScryfallAPIHttpClient.class);

  private Map<String, String> initialConfig() {
    Map<String, String> config = new HashMap<>();
    config.put(RATE_LIMIT_CONFIG, "100");
    config.put(TOPIC_CONFIG, "scryfall_cards");
    config.put(SINCE_CONFIG, "1995-10-10");
    config.put(PULL_TYPE_CONFIG, "cards");
    return (config);
  }
  @Test
  public void SourceTask_GrabPageWithSpecificDate_ResultsInSpecificCard() throws UnirestException {
    scryfallSourceTask.config = new ScryfallSourceConnectorConfig(initialConfig());
    scryfallSourceTask.nextPageToVisit = "https://api.scryfall.com/cards/search?q=date%3E%3D1995-10-10";
    scryfallSourceTask.nextQuerySince = DateUtils.InstantFromScryFallDate("1995-10-10");
    scryfallSourceTask.scryfallAPIHttpClient = new ScryfallAPIHttpClient(scryfallSourceTask.config);
    String url = scryfallSourceTask.scryfallAPIHttpClient.constructUrl(scryfallSourceTask.nextPageToVisit, scryfallSourceTask.nextQuerySince);
    System.out.println(url);

    HttpResponse<JsonNode> httpResponse = scryfallSourceTask.scryfallAPIHttpClient.getNextCardsAPI(scryfallSourceTask.nextPageToVisit, scryfallSourceTask.nextQuerySince);
    if (httpResponse.getStatus() != 403) {
      assertEquals(200, httpResponse.getStatus());
      Set<String> headers = httpResponse.getHeaders().keySet();
      //assertTrue(headers.contains(X_RATELIMIT_LIMIT_HEADER));
      //assertTrue(headers.contains(X_RATELIMIT_REMAINING_HEADER));
      //assertTrue(headers.contains(X_RATELIMIT_RESET_HEADER));
      assertEquals(results_size.intValue(), httpResponse.getBody().getObject().getJSONArray("data").length());
      JSONObject jsonObject = (JSONObject) httpResponse.getBody().getObject().getJSONArray("data").get(0);
      Card card = Card.fromJson(jsonObject);
      assertNotNull(card);
      assertNotNull(card.getId());
      assertEquals("5aa90ab6-2686-4462-8725-5d4370c05437", card.getId());


    }
  }

  @Test
  public void SourceTask_GrabPageWithFutureDate_FailsGracefullyAndWaits() throws InterruptedException {
    scryfallSourceTask.config = new ScryfallSourceConnectorConfig(initialConfig());
    scryfallSourceTask.nextPageToVisit = "https://api.scryfall.com/cards/search?q=date%3E%3D2045-10-10";
    scryfallSourceTask.nextQuerySince = DateUtils.InstantFromScryFallDate("2045-10-10");
    scryfallSourceTask.scryfallAPIHttpClient = new ScryfallAPIHttpClient(scryfallSourceTask.config);
    String url = scryfallSourceTask.scryfallAPIHttpClient.constructUrl(scryfallSourceTask.nextPageToVisit, scryfallSourceTask.nextQuerySince);
    System.out.println(url);

    JSONArray response = scryfallSourceTask.scryfallAPIHttpClient.getNextCards(url, scryfallSourceTask.nextQuerySince);
    assertEquals(response.length(), 0);
  }

  //
  @Test
  public void SourceTask_GrabPageWithNoNextPage_FailsGracefullyAndWaits() throws InterruptedException {
    scryfallSourceTask.config = new ScryfallSourceConnectorConfig(initialConfig());
    // set a url without a next page, not a normal formatted url, but works for the test
    scryfallSourceTask.nextPageToVisit = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&order=name&page=4&q=year%3D1996&unique=cards";
    scryfallSourceTask.nextQuerySince = DateUtils.InstantFromScryFallDate("1996-01-01");
    scryfallSourceTask.scryfallAPIHttpClient = new ScryfallAPIHttpClient(scryfallSourceTask.config);
    String url = scryfallSourceTask.scryfallAPIHttpClient.constructUrl(scryfallSourceTask.nextPageToVisit, scryfallSourceTask.nextQuerySince);
    System.out.println(url);

    scryfallSourceTask.scryfallAPIHttpClient.getNextCards(url, scryfallSourceTask.nextQuerySince);
    assertEquals(scryfallSourceTask.scryfallAPIHttpClient.getNextPageFromResponse(), "https://api.scryfall.com/cards/search?order=released&dir=asc&q=year%3E%3D1996-10-09");

  }
}