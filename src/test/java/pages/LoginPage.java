package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {


    public static WebDriver driver;


    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement usernameDescriptionField;

    @FindBy(className = "btn")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[contains(text(),'3 and 50')]")
    private WebElement usernameErrorMessage;

    @FindBy(xpath = "//*[contains(text(),'3 and 100')]")
    private WebElement passwordErrorMessage;

    @FindBy(className = "alert-danger")
    private WebElement failedLoginErrorMessage;

    @FindBy(id = "formly_1_input_username_0_description")
    private WebElement usernameDescriptionTitle;


    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage launch() {
        driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
        return this;
    }

    public LoginPage fillUsername(String value) {
        this.usernameField.sendKeys(value);
        return this;
    }

    public LoginPage fillPassword(String value) {
        passwordField.sendKeys(value);
        return this;
    }

    public LoginPage fillUsernameDescription(String value) {
        usernameDescriptionField.sendKeys(value);
        return this;
    }

    public LoginPage clickLoginBtn() {
        this.btnLogin.click();
        return this;
    }

    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    public boolean getBtnLoginStatus() {
        return btnLogin.isEnabled();
    }

    public void removeFocusFromLastField() {
        usernameDescriptionField.sendKeys(Keys.TAB);
    }

    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getUsernameInputValue() {
        return usernameField.getAttribute("value");
    }

    public String getPasswordInputValue() {
        return passwordField.getAttribute("value");
    }

    public String getUsernameDescriptionTitleColor() {
        return usernameDescriptionTitle.getCssValue("color");
    }

    public void waitLoginPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.way2automation.com/angularjs-protractor/registeration/#/login"));
    }

}