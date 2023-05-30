package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The type Actions utils.
 */
public class ActionsUtils {

    /**
     * Drag and drop el.
     * @param draggableEl the draggable el
     * @param droppableEl the droppable el
     * @param webdriver   the webdriver
     */
    public void dragAndDropEl(final WebElement draggableEl, final WebElement droppableEl, final WebDriver webdriver) {
      new Actions(webdriver)
              .dragAndDrop(draggableEl, droppableEl)
              .build()
              .perform();
    }
}
