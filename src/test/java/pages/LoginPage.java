package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    private final WebDriver driver;

    private final JavascriptExecutor js;

    private final String loginPageUrl = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement usernameDescriptionField;

    @FindBy(className = "btn")
    private WebElement btnLogin;

    @FindBy(css = "[ng-messages='form.username.$error']")
    private WebElement usernameFieldMessage;

    @FindBy(css = "[ng-messages='form.password.$error']")
    private WebElement passwordFieldMessage;

    @FindBy(className = "alert-danger")
    private WebElement failedLoginErrorMessage;

    @FindBy(id = "formly_1_input_username_0_description")
    private WebElement usernameDescriptionFieldMessage;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @Step("open Login page")
    public LoginPage launch() {
        driver.get(loginPageUrl);
        return this;
    }

    @Step("fill the Username field with the value '{value}'")
    public LoginPage fillUsername(final String value) {
        this.usernameField.sendKeys(value);
        return this;
    }

    @Step("fill the Password field with the value '{value}'")
    public LoginPage fillPassword(final String value) {
        passwordField.sendKeys(value);
        return this;
    }

    @Step("fill the Username Description field with the value '{value}'")
    public LoginPage fillUsernameDescription(final String value) {
        usernameDescriptionField.sendKeys(value);
        return this;
    }

    @Step("click Login button")
    public LoginPage clickLoginBtn() {
        this.btnLogin.click();
        return this;
    }

    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    public boolean isBtnLoginEnabled() {
        return btnLogin.isEnabled();
    }

    @Step("remove focus from the last form field")
    public void removeFocusFromLastField() {
        usernameDescriptionField.sendKeys(Keys.TAB);
    }

    public String getUsernameFieldMessage() {
        return usernameFieldMessage.getText();
    }

    public String getPasswordFieldMessage() {
        return passwordFieldMessage.getText();
    }

    public String getUsernameDescriptionFieldMessage() {
        return usernameDescriptionFieldMessage.getText();
    }

    public String getUsernameInputValue() {
        return usernameField.getAttribute("value");
    }

    public String getPasswordInputValue() {
        return passwordField.getAttribute("value");
    }

    public String getUsernameDescriptionTitleColor() {
        return usernameDescriptionFieldMessage.getCssValue("color");
    }

    @Step("wait for Login page loading")
    public void waitLoginPageLoad() {
        final int durationSeconds = 10;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.urlToBe(loginPageUrl));
    }

    @Step("remove the focus from the Username field with JS")
    public void removeFocusFromUsernameFieldWithJS() {
        this.js.executeScript("arguments[0].blur();", usernameField);
    }

    @Step()
    public Long getClientSizeWithJS(final String value) {
        String script = "return document.documentElement.client" + value + ";";
        return (Long) js.executeScript(script);
    }

    @Step()
    public Long getInnerSizeWithJS(final String value) {
        String script = "return window.inner" + value + ";";
        return (Long) js.executeScript(script);
    }
}
