package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SqlExPage extends BaseTest {

    private static final String sqlExUrl = "https://www.sql-ex.ru/index.php";

    @FindBy(css = "input[name='login']")
    private WebElement loginField;

    @FindBy(css = "input[name='psw']")
    private WebElement passwordField;

    @FindBy(css = "input[name='subm1']")
    private WebElement btnLogin;

    @FindBy(linkText = "test5656")
    private WebElement personalLink;

    public SqlExPage(WebDriver driver) {
        SqlExPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("open SqlEx page")
    public SqlExPage launch() {
        driver.get(sqlExUrl);
        return this;
    }

    @Step("fill the Login field with the value '{value}'")
    public SqlExPage fillLogin(String value) {
        this.loginField.sendKeys(value);
        return this;
    }

    @Step("fill the Password field with the value '{value}'")
    public SqlExPage fillPassword(String value) {
        this.passwordField.sendKeys(value);
        return this;
    }

    @Step("click Login button")
    public void clickLoginBtn() {
        btnLogin.click();
    }

    @Step("find link")
    public String checkPersonalLink() {
        return personalLink.getAttribute("href");
    }
}