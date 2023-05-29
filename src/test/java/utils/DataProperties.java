package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/** The type Data properties. */
public final class DataProperties {

    /** Constant PROPERTIES, value - new Properties(). */
    private static final Properties PROPERTIES = new Properties();

    /** Constant FILE_PATH, value - path to property file with test data. */
    private static final String FILE_PATH = "src/test/resources/testData.properties";

        static {
            try (FileInputStream ip = new FileInputStream(FILE_PATH)) {
                PROPERTIES.load(ip);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    private DataProperties() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns the value of property.
     * @param key property key
     * @return the string with value property
     */
    public static String readProperty(final String key) {
        return PROPERTIES.getProperty(key);
    }
}
