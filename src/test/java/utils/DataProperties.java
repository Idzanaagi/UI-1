package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class DataProperties {

    final private static Properties properties = new Properties();

    final private static String filePath = "src/test/java/resources/testData.properties";

        static {
            try(FileInputStream ip = new FileInputStream(filePath)) {
                Properties props = new Properties();
                props.load(ip);
                props.forEach((key1, value) -> {
                    final String key = key1.toString();
                    final String val = value.toString();
                    properties.put(key, val);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    static public String readProperty(String value) {
        return properties.getProperty(value);
    }
}