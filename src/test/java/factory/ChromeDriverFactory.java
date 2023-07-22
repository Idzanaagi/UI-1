package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * The type Chrome driver factory.
 */
public class ChromeDriverFactory implements DriverFactory {
    /**
     * Create Chrome Driver.
     * @return ChromeDriver
     */
    @Override
    public WebDriver createWebDriver()  {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        return new ChromeDriver((ChromeOptions) createCapabilities());
    }

    /**
     * Create Chrome Options.
     * @return ChromeOptions
     */
    @Override
    public MutableCapabilities createCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--headless=new");
        return chromeOptions;
    }
}
