package com.github.danwiseman.kafka.connect.scryfall;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;
import java.util.Map;

import com.github.danwiseman.kafka.connect.scryfall.Validators.RateLimitValidator;



public class ScryfallSourceConnectorConfig extends AbstractConfig {

  public static final String TOPIC_CONFIG = "topic";
  private static final String TOPIC_DOC = "This is the topic to connect to";

  public static final String RATE_LIMIT_CONFIG = "rate.limit";
  private static final String RATE_LIMIT_DOC = "The rate limit in ms for the connection. Defaults at 100, must be larger than 75";

  public ScryfallSourceConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
    super(config, parsedConfig);
  }

  public ScryfallSourceConnectorConfig(Map<String, String> parsedConfig) {
      this(conf(), parsedConfig);
  }

  public static ConfigDef conf() {
      return new ConfigDef()
              .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, TOPIC_DOC)
              .define(RATE_LIMIT_CONFIG, Type.INT, 100, new RateLimitValidator(), Importance.LOW, RATE_LIMIT_DOC);
  }

  public String getTopic() {
    return this.getString(TOPIC_CONFIG);
  }

  public Integer getRateLimit() {
    return this.getInt(RATE_LIMIT_CONFIG);
  }

}
