package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/** The type Home page. */
public class HomePage extends BasePage {

    /** Field - link logout. */
    @FindBy(xpath = "//a")
    private WebElement logOut;

    /**
     * Instantiates a new Home page.
     * @param webDriver the driver
     */
    public HomePage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Gets logout link text.
     * @return the logout link text
     */
    public String getLogoutLinkText() {
        return logOut.getText();
    }

    /** Click logout btn. */
    @Step("click Logout button")
    public void clickLogoutBtn() {
        logOut.click();
    }
}
