package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class Login {


    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement formlyUsernameField;

    @FindBy(className = "btn")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"username\"]/following::div[1]/div")
    private WebElement usernameErrorMessage;

    @FindBy(xpath = "//*[@id=\"password\"]/following::div[1]/div")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]")
    private WebElement failedLoginErrorMessage;


    public void fillUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void fillFormlyUsername(String value) {
        formlyUsernameField.sendKeys(value);
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public String getFailedLoginMessage() {
        return failedLoginErrorMessage.getText();
    }

    public String getAttributeBtnLogin() {
        return btnLogin.getAttribute("disabled");
    }

    public void removeFocusFromLastField() {
        formlyUsernameField.sendKeys(Keys.TAB);
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

}
