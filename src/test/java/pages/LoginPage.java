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


    public void fillUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void fillUsernameDescription(String value) {
        usernameDescriptionField.sendKeys(value);
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    public String getBtnLoginStatus() {
        return btnLogin.getAttribute("disabled");
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

    public static void waitLoginPageLoad(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

}