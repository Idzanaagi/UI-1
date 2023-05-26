package factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * The interface Driver factory.
 */
public interface DriverFactory {
    /**
     * Create webdriver webdriver.
     * @return the web driver
     * @throws MalformedURLException the malformed url exception
     */
    WebDriver createWebDriver() throws MalformedURLException;

    /**
     * Create capabilities mutable capabilities.
     * @return the mutable capabilities
     */
    MutableCapabilities createCapabilities();
}
