package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * The type Hooks.
 */
public class Hooks {

    /**
     * Field - webdriver.
     * */
    private static WebDriver driver;

    /**
     * Sets .
     */
    @Before
    @Step("create webdriver")
    public void setup() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Quit.
     */
    @After
    @Step("close webdriver")
    public void quit() {
        driver.quit();
    }

    /**
     * Gets driver.
     * @return the driver
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
