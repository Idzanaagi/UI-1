package utils;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.FileWriter;


/** The type Cookies. */
public final class Cookies {

    private Cookies() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Writes the value of the cookie to a file.
     * @param key      the cookie key whose value is to be retrieved and written
     * @param filepath the path to the file where to write the value
     * @param driver   the driver
     * @throws IOException the io exception
     */
    public static void writeCookie(final String key, final String filepath, final WebDriver driver) throws IOException {
        final String cookies = driver.manage().getCookieNamed(key).getValue();
        try (FileWriter fileWriter = new FileWriter(filepath, false)) {
            fileWriter.append(cookies);
            fileWriter.flush();
        }
    }
}
