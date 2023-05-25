package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import static factory.props.ConfigurationManager.configuration;

/**
 * The type Driver manager.
 */
public final class DriverManager {
    /**
     * Create driver web driver.
     * @param isRemote the is remote
     * @param browser  the browser
     * @return the web driver
     * @throws MalformedURLException the malformed url exception
     */
    public static WebDriver createDriver(final Boolean isRemote, final String browser) throws MalformedURLException {
        Browser browserToCreate = Browser.valueOf(browser.toUpperCase());
        DriverFactory factory;

        switch (browserToCreate) {
            case CHROME:
                factory = new ChromeDriverFactory();
                break;
            case FIREFOX:
                factory = new FirefoxDriverFactory();
                break;
            case EDGE:
                factory = new EdgeDriverFactory();
                break;
            case IE:
                factory = new IEDriverFactory();
                break;
            case OPERA:
                factory = new OperaDriverFactory();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        if (isRemote) {
            String gridURL = String.format("http://%s:%s", configuration().gridUrl(), configuration().gridPort());
            return new RemoteWebDriver(new URL(gridURL), factory.createCapabilities());
        } else {
            return factory.createWebDriver();
        }
    }

    private DriverManager() {
        throw new IllegalStateException("Utility class");
    }
}
