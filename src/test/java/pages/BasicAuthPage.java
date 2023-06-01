package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Basic auth page.
 */
public class BasicAuthPage extends BasePage {

    /** Field - Display Image link. */
    @FindBy(id = "displayImage")
    private WebElement displayImageLink;

    /** Field - image. */
    @FindBy(id = "downloadImg")
    private WebElement img;

    /**
     * Instantiates a new Basic auth page.
     * @param webDriver the web driver
     */
    public BasicAuthPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Display Image link.
     */
    @Step("click Display Image link")
    public void clickDisplayImageLink() {
        displayImageLink.click();
    }

    /**
     * Has src attr string.
     * @return the string
     */
    @Step("check the src attribute")
    public String hasSrcAttr() {
        return img.getAttribute("src");
    }
}
