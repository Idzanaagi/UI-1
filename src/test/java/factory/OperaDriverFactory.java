package factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * The type Opera driver factory.
 */
public class OperaDriverFactory implements DriverFactory {
    /**
     * Create Opera Driver.
     * @return OperaDriver (ChromeDriver)
     */
    @Override
    public WebDriver createWebDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src\\main\\resources\\drivers\\operadriver.exe"))
                .build();
        return new ChromeDriver(service, (ChromeOptions) createCapabilities());
    }

    /**
     * Create Opera Options.
     * @return OperaOptions (ChromeOptions)
     */
    @Override
    public MutableCapabilities createCapabilities() {
        return new ChromeOptions();
    }
}
