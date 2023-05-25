package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * The type Firefox driver factory.
 */
public class FirefoxDriverFactory implements DriverFactory {
    /**
     * Create Firefox Driver.
     * @return FirefoxDriver
     */
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        return new FirefoxDriver((FirefoxOptions) createCapabilities());
    }

    /**
     * Create Firefox Options.
     * @return FirefoxOptions
     */
    @Override
    public MutableCapabilities createCapabilities() {
        return new FirefoxOptions();
    }
}
