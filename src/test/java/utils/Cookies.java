package utils;

import java.io.*;

import static base.BaseTest.driver;

public class Cookies {

    final private String filepath = "cookie.txt";

    File file = new File(filepath);

    public String getCookie() {

        final String cookies = driver.manage().getCookieNamed("PHPSESSID").getValue();

        String cookieValue = null;

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                cookieValue = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try (FileWriter fileWriter = new FileWriter(filepath, false)) {
                fileWriter.append(cookies);
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return cookieValue;
    }
}