package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Default html page.
 */
public class DefaultHtmlPage extends BasePage {

    /** Field - New Browser Tab link. */
    @FindBy(linkText = "New Browser Tab")
    private WebElement newBrowserTabLink;

    /**
     * Instantiates a new Default html page.
     * @param webDriver the web driver
     */
    public DefaultHtmlPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click new browser tab link.
     */
    public void clickNewTabLink() {
        newBrowserTabLink.click();
    }
}
