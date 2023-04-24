package pages;

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
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement formlyUsername;

    @FindBy(className = "btn")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"username\"]/following::div[1]/div")
    private WebElement errorUsername;

    @FindBy(xpath = "//*[@id=\"password\"]/following::div[1]/div")
    private WebElement errorPassword;

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void fillFormlyUsername(String value) {
        formlyUsername.sendKeys(value);
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public void open() {
        driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }

}
