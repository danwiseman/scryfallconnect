package com.github.danwiseman.kafka.connect.scryfall;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigValue;
import org.junit.Before;
import org.junit.Test;

import static com.github.danwiseman.kafka.connect.scryfall.ScryfallSourceConnectorConfig.*;
import static org.junit.Assert.*;

public class ScryfallSourceConnectorConfigTest {
    private ConfigDef configDef = ScryfallSourceConnectorConfig.conf();
    private Map<String, String> config;

    @Before
    public void setUpInitialConfig() {
        config = new HashMap<>();
        config.put(RATE_LIMIT_CONFIG, "100");
        config.put(TOPIC_CONFIG, "scryfall_cards");
    }

    @Test
    public void doc() {
        System.out.println(ScryfallSourceConnectorConfig.conf().toRst());
    }

    @Test
    public void initialConfigIsValid() {
        assertTrue(configDef.validate(config)
                .stream()
                .allMatch(configValue -> configValue.errorMessages().size() == 0));
    }

    @Test
    public void canReadConfigCorrectly() {
        ScryfallSourceConnectorConfig config = new ScryfallSourceConnectorConfig(this.config);
        config.getTopic();

    }

    @Test
    public void validateRateLimit() {
        config.put(RATE_LIMIT_CONFIG, "50");
        ConfigValue configValue = configDef.validateAll(config).get(RATE_LIMIT_CONFIG);
        assertTrue(configValue.errorMessages().size() > 0);
    }
}
