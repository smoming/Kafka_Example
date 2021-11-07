package pers.mike.kafka.config;

import lombok.Data;
import org.springframework.stereotype.Component;
import pers.mike.kafka.util.PropertiesUtil;

import java.io.IOException;
import java.util.Properties;

@Data
@Component
public class KafkaConfig {
  private String bootstrapAddress;
  private String topicName;
  private String groupId;

  public static KafkaConfig getConfig() {
    Properties props = getProperties();
    KafkaConfig config = new KafkaConfig();
    config.setBootstrapAddress(PropertiesUtil.getValue(props, "kafka.bootstrapAddress"));
    config.setTopicName(PropertiesUtil.getValue(props, "kafka.topicName"));
    config.setGroupId(PropertiesUtil.getValue(props, "kafka.groupId"));
    return config;
  }

  private static Properties getProperties() {
    PropertiesUtil util = new PropertiesUtil();
    String kafkaConfigFileName = "kafka.properties";
    try {
      return util.getProperties(kafkaConfigFileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
