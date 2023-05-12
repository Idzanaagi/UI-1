package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Objects;

import utils.ChromeDriverOptions;
import utils.TestListener;

/** The type Base test. Creates driver, adds driver options, sets implicitlyWait. */
@ExtendWith(TestListener.class)
public class BaseTest {

    /** The Driver. */
    private WebDriver driver;

    /** Sets up. Create Driver, adds driver options, sets implicitlyWait */
    @BeforeEach
    public void setUp() {
        final int durationSeconds = 10;
        ChromeDriverOptions options = new ChromeDriverOptions();
        driver = new ChromeDriver(options.userOptions(false));
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass()
                .getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
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
