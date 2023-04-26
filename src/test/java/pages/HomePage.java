package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage {

    public static WebDriver driver;

    @FindBy(xpath = "//a")
    private WebElement logOut;

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLogoutLinkText() {
        return logOut.getText();
    }

    public void clickLogoutBtn() {
        logOut.click();
    }

    public void waitHomePageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.way2automation.com/angularjs-protractor/registeration/#/"));
    }
}