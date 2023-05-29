package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ActionsUtils;

/**
 * The type Dragn drop page.
 */
public class DragnDropPage extends BasePage {

    /** Field - webdriver. */
    private final WebDriver webdriver;

    /** Field - draggable element. */
    @FindBy(id = "draggable")
    private WebElement draggableEl;

    /** Field - droppable element. */
    @FindBy(id = "droppable")
    private WebElement droppableEl;

    /**
     * Instantiates a new DragnDrop page.
     * @param webDriver the web driver
     */
    public DragnDropPage(final WebDriver webDriver) {
        super(webDriver);
        this.webdriver = webDriver;
    }

    /**
     * Drag and drop draggableEl into droppableEl.
     */
    @Step("move draggableEl to droppableEl")
    public void dragAndDrop() {
        new ActionsUtils().dragAndDropEl(draggableEl, droppableEl, webdriver);
    }

    /**
     * Gets droppable el text.
     * @return the droppable el text
     */
    public String getDroppableElText() {
        return droppableEl.getText();
    }
}
