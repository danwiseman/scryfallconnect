package com.github.danwiseman.kafka.connect.scryfall;

import com.github.danwiseman.kafka.connect.scryfall.Validators.TimestampValidator;
import com.github.danwiseman.kafka.connect.scryfall.utils.DateUtils;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;

import java.time.Instant;
import java.util.Map;

import com.github.danwiseman.kafka.connect.scryfall.Validators.RateLimitValidator;



public class ScryfallSourceConnectorConfig extends AbstractConfig {

  public static final String TOPIC_CONFIG = "topic";
  private static final String TOPIC_DOC = "This is the topic to connect to";

  public static final String RATE_LIMIT_CONFIG = "rate.limit";
  private static final String RATE_LIMIT_DOC = "The rate limit in ms for the connection. Defaults at 100, must be larger than 75";

  public static final String PULL_TYPE_CONFIG = "pull.type"; // will add sets in the future
  private static final String PULL_TYPE_DOC = "What to pull, cards or sets (not implemented yet)";

  public static final String SINCE_CONFIG = "since.timestamp";
  private static final String SINCE_DOC = "Grab cards/sets published since\n"
          + "This is a timestamp in format: YYYY-MM-DD.\n"
          + "Defaults to 1990-01-01";

  public ScryfallSourceConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
    super(config, parsedConfig);
  }

  public ScryfallSourceConnectorConfig(Map<String, String> parsedConfig) {
      this(conf(), parsedConfig);
  }

  public static ConfigDef conf() {
      return new ConfigDef()
              .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, TOPIC_DOC)
              .define(PULL_TYPE_CONFIG, Type.STRING, "cards", Importance.HIGH, PULL_TYPE_DOC)
              .define(SINCE_CONFIG, Type.STRING, "1990-01-01",
                      new TimestampValidator(), Importance.HIGH, SINCE_DOC)
              .define(RATE_LIMIT_CONFIG, Type.INT, 100, new RateLimitValidator(), Importance.LOW, RATE_LIMIT_DOC);
  }

  public String getTopic() {
    return this.getString(TOPIC_CONFIG);
  }

  public Integer getRateLimit() {
    return this.getInt(RATE_LIMIT_CONFIG);
  }

  public String getPullType () { return this.getString(PULL_TYPE_CONFIG); }

  public Instant getSince() { return DateUtils.InstantFromScryFallDate(this.getString(SINCE_CONFIG)); }

}
