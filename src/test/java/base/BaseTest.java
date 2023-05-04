package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Objects;

import utils.ChromeDriverOptions;
import utils.TestListener;

@ExtendWith(TestListener.class)
public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeDriverOptions options = new ChromeDriverOptions();
        driver = new ChromeDriver(options.userOptions(false));
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
