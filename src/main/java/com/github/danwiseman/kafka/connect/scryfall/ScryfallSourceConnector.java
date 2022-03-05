package com.github.danwiseman.kafka.connect.scryfall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScryfallSourceConnector extends SourceConnector {

  private static Logger log = LoggerFactory.getLogger(ScryfallSourceConnector.class);
  private ScryfallSourceConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new ScryfallSourceConnectorConfig(map);
  }

  @Override
  public Class<? extends Task> taskClass() {
    //return ScryfallSourceTask.class;
    return null;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int i) {
    // Define the individual task configurations that will be executed.
    ArrayList<Map<String, String>> configs = new ArrayList<>(1);
    configs.add(config.originalsStrings());
    return configs;
  }

  @Override
  public void stop() {
    // nothing.
  }

  @Override
  public ConfigDef config() {
    return ScryfallSourceConnectorConfig.conf();
  }
}
