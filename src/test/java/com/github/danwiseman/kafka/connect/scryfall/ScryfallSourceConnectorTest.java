package com.github.danwiseman.kafka.connect.scryfall;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSourceConnectorConfig.*;
import static org.junit.Assert.assertEquals;

public class ScryfallSourceConnectorTest {

  private Map<String, String> initialConfig() {
        Map<String, String> config = new HashMap<>();
        config.put(RATE_LIMIT_CONFIG, "100");
        config.put(TOPIC_CONFIG, "scryfall_cards");

        return (config);
    }

  @Test
  public void taskConfigsShouldReturnOneTaskConfig() {
    ScryfallSourceConnector scryfallSourceConnector = new ScryfallSourceConnector();
    scryfallSourceConnector.start(initialConfig());

    assertEquals(scryfallSourceConnector.taskConfigs(1).size(), 1);
    assertEquals(scryfallSourceConnector.taskConfigs(10).size(), 1);
  }
}
