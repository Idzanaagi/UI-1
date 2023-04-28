package pages;

import io.qameta.allure.Step;
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

    @FindBy(css = "[ng-messages='form.username.$error']")
    private WebElement usernameErrorMessage;

    @FindBy(css = "[ng-messages='form.password.$error']")
    private WebElement passwordErrorMessage;

    @FindBy(className = "alert-danger")
    private WebElement failedLoginErrorMessage;

    @FindBy(id = "formly_1_input_username_0_description")
    private WebElement usernameDescriptionTitle;

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("open Login page")
    public LoginPage launch() {
        driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
        return this;
    }

    @Step("fill the Username field with the value '{value}'")
    public LoginPage fillUsername(String value) {
        this.usernameField.sendKeys(value);
        return this;
    }

    @Step("fill the Password field with the value '{value}'")
    public LoginPage fillPassword(String value) {
        passwordField.sendKeys(value);
        return this;
    }

    @Step("fill the Username Description field with the value '{value}'")
    public LoginPage fillUsernameDescription(String value) {
        usernameDescriptionField.sendKeys(value);
        return this;
    }

    @Step("click Login button")
    public LoginPage clickLoginBtn() {
        this.btnLogin.click();
        return this;
    }

    @Step("get message of unsuccessful login")
    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    @Step("get the status of the Login button")
    public boolean getBtnLoginStatus() {
        return btnLogin.isEnabled();
    }

    @Step("remove focus from the last form field")
    public void removeFocusFromLastField() {
        usernameDescriptionField.sendKeys(Keys.TAB);
    }

    @Step("get an error message in the Username field")
    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }

    @Step("get an error message in the Password field")
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    @Step("get a value in the Username field")
    public String getUsernameInputValue() {
        return usernameField.getAttribute("value");
    }

    @Step("get a value in the Password field")
    public String getPasswordInputValue() {
        return passwordField.getAttribute("value");
    }

    @Step("get the title color of the Username Description field")
    public String getUsernameDescriptionTitleColor() {
        return usernameDescriptionTitle.getCssValue("color");
    }

    @Step("wait for Login page loading")
    public void waitLoginPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.way2automation.com/angularjs-protractor/registeration/#/login"));
    }
}