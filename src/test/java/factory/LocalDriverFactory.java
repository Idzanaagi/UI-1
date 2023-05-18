package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ChromeDriverOptions;
import static utils.FileUtils.getFile;

import static factory.props.ConfigurationManager.configuration;

/** The type Local driver factory. */
public class LocalDriverFactory implements DriverFactory {

    /**
     * Create instance webdriver.
     * @param operationSystem the os (windows or linux, define LocalDriver)
     * @return the webdriver
     */

    public WebDriver createDriverInstance(final String operationSystem) {
        WebDriver driver;
        ChromeDriverOptions options = new ChromeDriverOptions();
        OsList osList = OsList.valueOf(operationSystem.toUpperCase());
        driver = new ChromeDriver(options.userOptions(false));

        switch (osList) {
            case WINDOWS:
                getFile(configuration().windowsChromeDriverPath());
                break;
            case LINUX:
                getFile(configuration().linuxChromeDriverPath());
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + osList);
        }
        return driver;
    }
}
