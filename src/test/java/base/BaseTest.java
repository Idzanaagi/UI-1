package base;

import factory.DriverFactoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import utils.TestListener;

import static factory.props.ConfigurationManager.configuration;

/** The type Base test. Creates driver, adds driver options, sets implicitlyWait. */
@ExtendWith(TestListener.class)
public class BaseTest {

    /** The Driver. */
    private WebDriver driver;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        final int durationSeconds = 10;
        driver = DriverFactoryManager.getFactory().createDriverInstance(configuration().operatingSystem());
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
