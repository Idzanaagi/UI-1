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


    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement usernameDescriptionField;

    @FindBy(className = "btn")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"username\"]/following::div[1]/div")
    private WebElement usernameErrorMessage;

    @FindBy(xpath = "//*[@id=\"password\"]/following::div[1]/div")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]")
    private WebElement failedLoginErrorMessage;

    @FindBy(id = "formly_1_input_username_0_description")
    private WebElement usernameDescriptionTitle;


    public static LoginPage using(WebDriver driver) {
        return new LoginPage(driver);
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
        this.passwordField.sendKeys(value);
        return this;
    }

    public LoginPage fillUsernameDescription(String value) {
        this.usernameDescriptionField.sendKeys(value);
        return this;
    }

    public LoginPage clickLoginBtn() {
        this.btnLogin.click();
        return this;
    }

    public String getFailedLoginMessage() {
        return this.failedLoginErrorMessage.getText();
    }

    public String getBtnLoginStatus() {
        return this.btnLogin.getAttribute("disabled");
    }

    public void removeFocusFromLastField() {
        this.usernameDescriptionField.sendKeys(Keys.TAB);
    }

    public String getUsernameErrorMessage() {
        return this.usernameErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return this.passwordErrorMessage.getText();
    }

    public String getUsernameInputValue() {
        return this.usernameField.getAttribute("value");
    }

    public String getPasswordInputValue() {
        return this.passwordField.getAttribute("value");
    }

    public String getUsernameDescriptionTitleColor() {
        return this.usernameDescriptionTitle.getCssValue("color");
    }

    public void waitLoginPageLoad(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

}