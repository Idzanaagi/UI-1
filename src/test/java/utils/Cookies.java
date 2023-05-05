package utils;

import org.openqa.selenium.Cookie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

import static base.BaseTest.driver;

public class Cookies {

    final private String filepath = "cookie.txt";

    File file = new File(filepath);

    public String getCookie(String value) throws IOException {

        final String cookies = driver.manage().getCookieNamed(value).getValue();

        String cookieValue = null;

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                cookieValue = reader.readLine();
            }
        }
        else {
            try (FileWriter fileWriter = new FileWriter(filepath, false)) {
                fileWriter.append(cookies);
                fileWriter.flush();
            }
        }
        return cookieValue;
    }

    public void setCookie(String expectedCookie) throws IOException {
        Cookie setCookie = new Cookie(expectedCookie, getCookie(expectedCookie));
        driver.manage().addCookie(setCookie);
        driver.navigate().refresh();
    }
}