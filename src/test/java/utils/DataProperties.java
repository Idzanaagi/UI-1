package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class DataProperties {

    final private static Properties PROPERTIES = new Properties();

    final private static String FILE_PATH = "src/test/java/resources/testData.properties";

        static {
            try (FileInputStream ip = new FileInputStream(FILE_PATH)) {
                PROPERTIES.load(ip);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    static public String readProperty(final String value) {
        return PROPERTIES.getProperty(value);
    }
}
