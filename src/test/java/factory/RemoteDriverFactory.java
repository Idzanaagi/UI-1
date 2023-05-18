package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import utils.ChromeDriverOptions;

import static factory.props.ConfigurationManager.configuration;

/** The type Remote driver factory. */
public class RemoteDriverFactory implements DriverFactory {

    /**
     * Create remote instance webdriver.
     * @return the webdriver
     */
    @Override
    public WebDriver createDriverInstance(final String operatingSystem) {
        URL grid = null;
        try {
            grid = new URL(String.format("http://%s:%s", configuration().gridUrl(), configuration().gridPort()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new RemoteWebDriver(grid, new ChromeDriverOptions().userOptions(true));
    }
}
