package pers.mike.kafka.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

  public Properties getProperties(String fileConfig) throws IOException, FileNotFoundException {
    Properties props = new Properties();
    ClassLoader classLoader = getClass().getClassLoader();
    props.load(classLoader.getResourceAsStream(fileConfig));
    return props;
  }

  public static String getValue(Properties props, String key) {
    if (ObjectUtil.isNull(props)) {
      return "";
    }
    return props.getProperty(key);
  }
}
