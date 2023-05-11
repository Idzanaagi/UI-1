package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SqlExPage {

    private final WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "psw")
    private WebElement passwordField;

    @FindBy(name = "subm1")
    private WebElement btnLogin;

    @FindBy(css = "[href='/personal.php']")
    private WebElement personalLink;

    public SqlExPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("open SqlEx page")
    public void launch() {
        String sqlExUrl = "https://www.sql-ex.ru/index.php";
        driver.get(sqlExUrl);
    }

    @Step("fill the Login field with the value '{value}'")
    public SqlExPage fillLogin(final String value) {
        this.loginField.sendKeys(value);
        return this;
    }

    @Step("fill the Password field with the value '{value}'")
    public SqlExPage fillPassword(final String value) {
        this.passwordField.sendKeys(value);
        return this;
    }

    @Step("click Login button")
    public void clickLoginBtn() {
        btnLogin.click();
    }

    @Step("find link")
    public String checkPersonalLink() {
        return personalLink.getText();
    }
}
