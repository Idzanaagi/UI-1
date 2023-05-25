package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.JavaScriptExecutor;


/** The type Login page. */
public class LoginPage extends BasePage {

    /** The Driver. */
    private final WebDriver driver;

    /** Field - username. */
    @FindBy(id = "username")
    private WebElement usernameField;

    /** Field - password. */
    @FindBy(id = "password")
    private WebElement passwordField;

    /** Field - username description. */
    @FindBy(id = "formly_1_input_username_0")
    private WebElement usernameDescriptionField;

    /** Field - button login. */
    @FindBy(className = "btn")
    private WebElement btnLogin;

    /** Field - username message. */
    @FindBy(css = "[ng-messages='form.username.$error']")
    private WebElement usernameFieldMessage;

    /** Field - password message. */
    @FindBy(css = "[ng-messages='form.password.$error']")
    private WebElement passwordFieldMessage;

    /** Field - message about failed login. */
    @FindBy(className = "alert-danger")
    private WebElement failedLoginErrorMessage;

    /** Field - username description message. */
    @FindBy(id = "formly_1_input_username_0_description")
    private WebElement usernameDescriptionFieldMessage;

    /**
     * Instantiates a new Login page.
     * @param webDriver the driver
     */
    public LoginPage(final WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    }

    /**
     * Fill username login page.
     * @param value the username value
     * @return the login page
     */
    @Step("fill the Username field with the value '{value}'")
    public LoginPage fillUsername(final String value) {
        this.usernameField.sendKeys(value);
        return this;
    }

    /**
     * Fill password login page.
     * @param value the password value
     * @return the login page
     */
    @Step("fill the Password field with the value '{value}'")
    public LoginPage fillPassword(final String value) {
        passwordField.sendKeys(value);
        return this;
    }

    /**
     * Fill username description login page.
     * @param value the username description value
     * @return the login page
     */
    @Step("fill the Username Description field with the value '{value}'")
    public LoginPage fillUsernameDescription(final String value) {
        usernameDescriptionField.sendKeys(value);
        return this;
    }

    /**
     * Click login btn login page.
     * @return the login page
     */
    @Step("click Login button")
    public LoginPage clickLoginBtn() {
        this.btnLogin.click();
        return this;
    }

    /**
     * Gets failed login message.
     * @return the failed login message
     */
    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    /**
     * Is btn login enabled boolean.
     * @return the boolean
     */
    public boolean isBtnLoginEnabled() {
        return btnLogin.isEnabled();
    }

    /** Remove focus from last field. */
    @Step("remove focus from the last form field")
    public void removeFocusFromLastField() {
        usernameDescriptionField.sendKeys(Keys.TAB);
    }

    /**
     * Gets username field message.
     * @return the username field message
     */
    public String getUsernameFieldMessage() {
        return usernameFieldMessage.getText();
    }

    /**
     * Gets password field message.
     * @return the password field message
     */
    public String getPasswordFieldMessage() {
        return passwordFieldMessage.getText();
    }

    /**
     * Gets username description field message.
     * @return the username description field message
     */
    public String getUsernameDescriptionFieldMessage() {
        return usernameDescriptionFieldMessage.getText();
    }

    /**
     * Gets username input value.
     * @return the username input value
     */
    public String getUsernameInputValue() {
        return usernameField.getAttribute("value");
    }

    /**
     * Gets password input value.
     * @return the password input value
     */
    public String getPasswordInputValue() {
        return passwordField.getAttribute("value");
    }

    /**
     * Gets username description title color.
     * @return the username description title color
     */
    public String getUsernameDescriptionTitleColor() {
        return usernameDescriptionFieldMessage.getCssValue("color");
    }

    /** Remove focus from username field with js. */
    @Step("remove the focus from the Username field with JS")
    public void removeFocusFromUsernameField() {
        JavaScriptExecutor js = new JavaScriptExecutor(driver);
        js.blurElement(usernameField);
    }

    /**
     * Is no focus boolean.
     * @return the boolean (true - no focus, false - have a focus)
     */
    public boolean isFocusUsernameField() {
        return usernameField.equals(driver.switchTo().activeElement());
    }
}
