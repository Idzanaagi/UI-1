package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Tabs page.
 */
public class TabsPage extends BasePage {

    /** Field - New Browser Tab link. */
    @FindBy(linkText = "New Browser Tab")
    private WebElement newBrowserTabLink;

    /**
     * Instantiates a new Tabs page.
     * @param webDriver the webdriver
     */
    public TabsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click new browser tab link.
     */
    @Step("click New Browser Tab link")
    public void clickNewTabLink() {
        newBrowserTabLink.click();
    }
}
