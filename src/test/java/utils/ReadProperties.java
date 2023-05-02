package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {

    private static Properties loadProperty() {

        final String filePath = "src/test/java/resources/testData.properties";

        Properties props = new Properties();

        try(FileInputStream ip = new FileInputStream(filePath)) {
            props.load(ip);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public static String readProperty(String expectedProperty) {
        return loadProperty().getProperty(expectedProperty);
    }
}