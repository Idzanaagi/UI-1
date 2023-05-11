package utils;

import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverOptions {

    public ChromeOptions userOptions(final boolean userOptions) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (userOptions) {
            options.addArguments("--headless=new");
        }
        return options;
    }
}
