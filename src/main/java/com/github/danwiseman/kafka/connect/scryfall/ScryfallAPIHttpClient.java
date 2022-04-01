package com.github.danwiseman.kafka.connect.scryfall;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSchemas.CARD_RELEASED_AT;
import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSchemas.NEXT_PAGE_FIELD;

import com.github.danwiseman.kafka.connect.scryfall.utils.DateUtils;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.connect.errors.ConnectException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScryfallAPIHttpClient {

  private static final Logger log = LoggerFactory.getLogger(
    ScryfallAPIHttpClient.class
  );

  private Integer XRateLimit = 9999;
  private Integer XRateRemaining = 9999;
  private long XRateReset = Instant.MAX.getEpochSecond();
  private String next_page_from_response = "";
  private Integer daysToWait = 2;

  ScryfallSourceConnectorConfig config;

  public static final String X_RATELIMIT_LIMIT_HEADER = "X-Ratelimit-Limit";
  public static final String X_RATELIMIT_REMAINING_HEADER =
    "X-Ratelimit-Remaining";
  public static final String X_RATELIMIT_RESET_HEADER = "X-Ratelimit-Reset";

  public ScryfallAPIHttpClient(ScryfallSourceConnectorConfig config) {
    this.config = config;
  }

  protected String getNextPageFromResponse() {
    return this.next_page_from_response;
  }

  protected JSONArray getNextCards(String page, Instant since)
    throws InterruptedException {
    HttpResponse<JsonNode> jsonResponse;

    try {
      jsonResponse = getNextCardsAPI(page, since);

      Headers headers = jsonResponse.getHeaders();
      // TODO: Scryfall doesn't implement these headers. it's a 429 error instead
      long sleepTime = config.getRateLimit();

      switch (jsonResponse.getStatus()) {
        case 200:
          return this.processPage(jsonResponse.getBody().getObject());
        case 401:
          throw new ConnectException("Bad credentials.");
        case 404:
          log.error(
            String.format(
              "No cards found at this url, assuming cards all grabbed, waiting %s minutes",
              5l
            )
          );
          this.longSleep();
          return new JSONArray();
        case 429:
          log.info(
            String.format("Hit Rate Limit. Sleeping for %s seconds", sleepTime)
          );
          this.sleep();
          this.sleep();
          return getNextCards(page, since);
        case 403:
          Thread.sleep(1000 * sleepTime);
          return getNextCards(page, since);
        default:
          log.error(constructUrl(page, since));
          log.error(String.valueOf(jsonResponse.getStatus()));
          log.error(jsonResponse.getBody().toString());
          log.error(jsonResponse.getHeaders().toString());
          log.error("Unknown error: Sleeping 5 seconds " + "before re-trying");
          Thread.sleep(5000L);
          return getNextCards(page, since);
      }
    } catch (UnirestException e) {
      e.printStackTrace();
      Thread.sleep(5000L);
      return new JSONArray();
    }
  }

  protected JSONArray processPage(JSONObject bodyObject) {
    JSONArray cardArray = bodyObject.getJSONArray("data");
    // If there is a next page, set it as the next page
    // Otherwise, get the last release date and add a day
    if (bodyObject.has(NEXT_PAGE_FIELD)) {
      this.next_page_from_response = bodyObject.getString(NEXT_PAGE_FIELD);
    } else {
      int cards_returned = cardArray.length();
      String last_card_date = cardArray
        .getJSONObject(cards_returned - 1)
        .getString(CARD_RELEASED_AT);
      this.next_page_from_response =
        this.constructUrl(
            null,
            DateUtils
              .InstantFromScryFallDate(last_card_date)
              .plus(1, ChronoUnit.DAYS)
          );
    }
    return cardArray;
  }

  protected HttpResponse<JsonNode> getNextCardsAPI(String page, Instant since)
    throws UnirestException {
    GetRequest unirest = Unirest.get(constructUrl(page, since));
    log.warn(String.format("GET %s", unirest.getUrl()));

    return unirest.asJson();
  }

  protected String constructUrl(String page, Instant since) {
    if (page != null && page != "") {
      return page;
    } else {
      return String.format(
        "https://api.scryfall.com/cards/search?order=released&dir=asc&q=year%%3E%%3D%s",
        DateUtils.ScryFallDateFromInstant(since)
      );
    }
  }

  protected void sleep() throws InterruptedException {
    long sleepTime = config.getRateLimit();
    log.debug(String.format("Sleeping for %s seconds", sleepTime));
    Thread.sleep(sleepTime);
  }

  protected void longSleep() throws InterruptedException {
    long longSleep = 5l;
    log.debug(String.format("Sleeping for %s minutes", longSleep));
    TimeUnit.MINUTES.sleep(longSleep);
  }

  public void sleepIfNeed() throws InterruptedException {
    // Sleep is needed
    sleep();
  }
}
