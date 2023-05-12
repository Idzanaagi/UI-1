package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** The type Sql ex page. */
public class SqlExPage extends BasePage {

    /** Field - login. */
    @FindBy(name = "login")
    private WebElement loginField;

    /** Field - password. */
    @FindBy(name = "psw")
    private WebElement passwordField;

    /** Field - button login. */
    @FindBy(name = "subm1")
    private WebElement btnLogin;

    /** Field - personal link. */
    @FindBy(css = "[href='/personal.php']")
    private WebElement personalLink;

    /**
     * Instantiates a new Sql ex page.
     * @param webDriver the driver
     */
    public SqlExPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Fill login sql-ex page.
     * @param value the login value
     * @return the sql-ex page
     */
    @Step("fill the Login field with the value '{value}'")
    public SqlExPage fillLogin(final String value) {
        this.loginField.sendKeys(value);
        return this;
    }

    /**
     * Fill password sql-ex page.
     * @param value the password value
     * @return the sql-ex page
     */
    @Step("fill the Password field with the value '{value}'")
    public SqlExPage fillPassword(final String value) {
        this.passwordField.sendKeys(value);
        return this;
    }

    /** Click login btn. */
    @Step("click Login button")
    public void clickLoginBtn() {
        btnLogin.click();
    }

    /**
     * Check personal link string.
     * @return the string
     */
    @Step("find link")
    public String checkPersonalLink() {
        return personalLink.getText();
    }
}
