package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;

import utils.TestListener;
import factory.DriverManager;

import static factory.props.ConfigurationManager.configuration;

/** The type Base test. Creates driver, adds driver options, sets implicitlyWait. */
@ExtendWith(TestListener.class)
public class BaseTest {

    /** The Driver. */
    private WebDriver driver;

    /**
     * Sets driver.
     * @throws MalformedURLException the malformed url exception
     */
    @BeforeEach
    public void setup() throws MalformedURLException {
        final int durationSeconds = 10;
        driver = DriverManager.createDriver(configuration().remote(), configuration().browser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationSeconds));
    }

    /**
     * Gets driver.
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
