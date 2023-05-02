package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {

   private static final String filePath = "src/test/java/resources/testData.properties";

   public static String getProperty(String propertyValue) {
        String expectedProperty;
        try (FileInputStream ip = new FileInputStream(filePath))
        {
            Properties props = new Properties();
            props.load(ip);
            expectedProperty = props.getProperty(propertyValue);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expectedProperty;
    }
}