package utils;

import org.openqa.selenium.chrome.ChromeOptions;


/** The type Chrome driver options. */
public class ChromeDriverOptions {

    /**
     * Sets basic or advanced options depending on the passed parameter.
     * @param userOptions (boolean) true - set options including custom options (define "if" statment),
     *                    false - set the standard options
     * @return the chrome options
     */
    public ChromeOptions userOptions(final boolean userOptions) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (userOptions) {
            options.addArguments("--headless=new");
        }
        return options;
    }
}
