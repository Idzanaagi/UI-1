package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
The type Edge driver factory.
 */
public class EdgeDriverFactory implements DriverFactory {
    /**
     * Create Edge Webdriver.
     * @return EdgeDriver
     */
    @Override
    public WebDriver createWebDriver()  {
        WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
        return new EdgeDriver((EdgeOptions) createCapabilities());
    }

    /**
     * Create Edge Options.
     * @return EdgeOptions
     */
    @Override
    public MutableCapabilities createCapabilities() {
        return new EdgeOptions();
    }
}
