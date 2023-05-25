package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * The type Ie driver factory.
 */
public class IEDriverFactory implements DriverFactory {

    /**
     * Create Internet Explorer Driver.
     * @return InternetExplorerDriver
     */
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.iedriver().arch32().browserVersion("10").setup();
        return new InternetExplorerDriver((InternetExplorerOptions) createCapabilities());
    }

    /**
     * Create Internet Explorer Capabilities.
     * @return internet Explorer Capabilities
     */
    @Override
    public MutableCapabilities createCapabilities() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.withInitialBrowserUrl("www.google.com");
        return internetExplorerOptions;
    }
}
