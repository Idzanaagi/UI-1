package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DragnDropPage;

/**
 * The type Drag drop test.
 */
@Epic("DragDrop")
public class DragDropTest extends BaseTest {

    /** drag and drop element. */
    @Test
    @Story("User drags and drops the item in the block")
    @Severity(SeverityLevel.CRITICAL)
    public void dragnDrop()  {
        DragnDropPage dragDropPage = new DragnDropPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch("http://way2automation.com/way2auto_jquery/droppable.php");
        getDriver().switchTo().frame(0);
        dragDropPage.dragAndDrop();
        Assertions.assertEquals("Dropped!", dragDropPage.getDroppableElText(),
                "expected and received text did not match");
    }
}
