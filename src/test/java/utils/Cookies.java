package utils;

import org.openqa.selenium.WebDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


public class Cookies {

    public String readCookie(String filepath) throws IOException {
        String cookieValue = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            cookieValue = reader.readLine();
        }
        return cookieValue;
    }

    public void writeCookie(String value, String filepath, WebDriver driver) throws IOException {
        final String cookies = driver.manage().getCookieNamed(value).getValue();
        try (FileWriter fileWriter = new FileWriter(filepath, false)) {
            fileWriter.append(cookies);
            fileWriter.flush();
        }
    }

    public boolean isFileExist(String filepath) {
        return new File(filepath).exists();
    }
}