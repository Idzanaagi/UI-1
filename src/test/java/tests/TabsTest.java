package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.DefaultHtmlPage;
import pages.TabsPage;

import static utils.TabsUtils.switchTab;
import static utils.TabsUtils.switchFrame;


/**
 * The type Tabs test.
 */
@Epic("Tabs")
public class TabsTest extends BaseTest {

    /**
     * Tabs.
     */
    @Story("User opens tabs in new windows")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void tabs() throws Exception {
        TabsPage tabsPage = new TabsPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        DefaultHtmlPage defaultHtmlPage = new DefaultHtmlPage(getDriver());
        basePage.launch("http://way2automation.com/way2auto_jquery/frames-and-windows.php");
        switchFrame(getDriver(), 0);
        tabsPage.clickNewTabLink();
        switchTab(getDriver(), 1);
        defaultHtmlPage.clickNewTabLink();
        switchTab(getDriver(), 2);
        Assertions.assertEquals("https://way2automation.com/way2auto_jquery/frames-windows/defult1.html#",
                getDriver().getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals(3, getDriver().getWindowHandles().size(),
                "expected and received number of opened tabs will not match");
    }
}
