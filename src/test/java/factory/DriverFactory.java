package factory;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    /**
     * Create instance web driver.
     * @param operatingSystem the browser
     * @return the web driver
     */
    WebDriver createDriverInstance(String operatingSystem);
}
