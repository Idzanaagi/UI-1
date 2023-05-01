package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {

    public static String validUsername;

    public static String validPassword;

    public static String validUsernameDescription;

    public static String loginPageUrl;

    public static String invalidValue;

    public static String invalidLengthValue;

    private static final String filePath = "src/test/java/resources/testData.properties";

    static {
        try (FileInputStream ip = new FileInputStream(filePath))
        {
            Properties props = new Properties();
            props.load(ip);
            validUsername = props.getProperty("validUsername");
            validPassword = props.getProperty("validPassword");
            validUsernameDescription = props.getProperty("validUsernameDescription");
            loginPageUrl = props.getProperty("loginPageUrl");
            invalidValue = props.getProperty("invalidValue");
            invalidLengthValue = props.getProperty("invalidLengthValue");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}