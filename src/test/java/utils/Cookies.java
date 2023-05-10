package utils;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.FileWriter;


public class Cookies {

    static public void writeCookie(String key, String filepath, WebDriver driver) throws IOException {
        final String cookies = driver.manage().getCookieNamed(key).getValue();
        try (FileWriter fileWriter = new FileWriter(filepath, false)) {
            fileWriter.append(cookies);
            fileWriter.flush();
        }
    }
}