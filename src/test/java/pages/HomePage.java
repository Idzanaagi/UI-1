package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a")
    private WebElement logOut;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLogoutLinkText() {
        return logOut.getText();
    }

    @Step("click Logout button")
    public void clickLogoutBtn() {
        logOut.click();
    }

    @Step("wait for Home page loading")
    public void waitHomePageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.way2automation.com/angularjs-protractor/registeration/#/"));
    }
}