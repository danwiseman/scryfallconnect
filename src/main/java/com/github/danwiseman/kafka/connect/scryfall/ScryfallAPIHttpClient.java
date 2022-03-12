package com.github.danwiseman.kafka.connect.scryfall;

import com.github.danwiseman.kafka.connect.scryfall.utils.DateUtils;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.apache.kafka.connect.errors.ConnectException;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ScryfallAPIHttpClient {

    private static final Logger log = LoggerFactory.getLogger(ScryfallAPIHttpClient.class);

    private Integer XRateLimit = 9999;
    private Integer XRateRemaining = 9999;
    private long XRateReset = Instant.MAX.getEpochSecond();
    private String next_page_from_response = "";

    ScryfallSourceConnectorConfig config;

    public static final String X_RATELIMIT_LIMIT_HEADER="X-Ratelimit-Limit";
    public static final String X_RATELIMIT_REMAINING_HEADER="X-Ratelimit-Remaining";
    public static final String X_RATELIMIT_RESET_HEADER="X-Ratelimit-Reset";


    public ScryfallAPIHttpClient(ScryfallSourceConnectorConfig config) {
        this.config = config;
    }

    protected String getNextPageFromResponse() {
        return this.next_page_from_response;
    }

    protected JSONArray getNextCards(String page, Instant since) throws InterruptedException {
        HttpResponse<JsonNode> jsonResponse;

        try {
            jsonResponse = getNextCardsAPI(page, since);

            Headers headers = jsonResponse.getHeaders();
            // TODO: Scryfall doesn't implement these headers. it's a 429 error instead
            long sleepTime = config.getRateLimit();

            switch (jsonResponse.getStatus()) {
                case 200:
                    this.next_page_from_response = jsonResponse.getBody().getObject().getString("next_page");
                    return jsonResponse.getBody().getObject().getJSONArray("data");
                case 401:
                    throw new ConnectException("Bad credentials.");
                case 429:
                    log.info(String.format("Sleeping for %s seconds", sleepTime ));
                    Thread.sleep(100 * sleepTime);
                    return getNextCards(page, since);
                case 403:
                    Thread.sleep(1000 * sleepTime);
                    return getNextCards(page, since);
                default:
                    log.error(constructUrl(page, since));
                    log.error(String.valueOf(jsonResponse.getStatus()));
                    log.error(jsonResponse.getBody().toString());
                    log.error(jsonResponse.getHeaders().toString());
                    log.error("Unknown error: Sleeping 5 seconds " +
                            "before re-trying");
                    Thread.sleep(5000L);
                    return getNextCards(page, since);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
            Thread.sleep(5000L);
            return new JSONArray();
        }

    }

    protected HttpResponse<JsonNode> getNextCardsAPI(String page, Instant since) throws UnirestException {
        GetRequest unirest = Unirest.get(constructUrl(page, since));
        log.warn(String.format("GET %s", unirest.getUrl()));

        return unirest.asJson();
    }

    protected String constructUrl(String page, Instant since) {
        if (page != null && page != "") {
            return page;
        } else {
            return String.format("https://api.scryfall.com/cards/search?order=released&dir=asc&q=year%%3E%%3D%s",
                    DateUtils.ScryFallDateFromInstant(since));
        }
    }

    protected void sleep() throws InterruptedException {
        long sleepTime = config.getRateLimit();
        log.debug(String.format("Sleeping for %s seconds", sleepTime ));
        Thread.sleep(sleepTime);
    }

    public void sleepIfNeed() throws InterruptedException {
        // Sleep is needed
         sleep();

    }


}
