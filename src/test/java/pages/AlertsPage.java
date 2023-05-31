package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Alerts page.
 */
public class AlertsPage extends BasePage {

    /** Field - input alert button. */
    @FindBy(linkText = "INPUT ALERT")
    private WebElement inputAlertBtn;

    /** Field - show input box button. */
    @FindBy(tagName = "button")
    private WebElement showInputBoxBtn;

    /** Field - demo text. */
    @FindBy(id = "demo")
    private WebElement demoText;

    /**
     * Instantiates a new Alerts page.
     * @param webDriver the web driver
     */
    public AlertsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Input Alert button.
     */
    @Step("click Input Alert button")
    public void clickInputAlertBtn() {
       inputAlertBtn.click();
   }

    /**
     * Click show input box button.
     */
    @Step("Click show input box button")
    public void clickShowInputBoxBtn() {
        showInputBoxBtn.click();
    }

    /**
     * Gets demo text.
     * @return the demo text
     */
    public String getDemoText() {
        return demoText.getText();
    }
}
