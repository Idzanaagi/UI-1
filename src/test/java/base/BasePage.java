package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** The type Base page. */
public class BasePage {

    /** The Driver. */
    private final WebDriver driver;

    /**
     * Instantiates a new Base page.
     * @param webDriver the driver
     */
    public BasePage(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Wait page load.
     * @param url the url
     */
    @Step("wait for page loading")
    public void waitPageLoad(final String url) {
        final int durationSeconds = 10;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * Launch.
     * @param url the url
     */
    @Step("open page")
    public void launch(final String url) {
        driver.get(url);
    }
}
