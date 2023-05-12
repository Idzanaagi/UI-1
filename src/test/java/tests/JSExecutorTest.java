package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.LoginPage;
import utils.JavaScriptExecutor;


/** The type Js executor test. */
public class JSExecutorTest extends BaseTest {

    /** Remove focus. */
    @Test
    @Severity(SeverityLevel.MINOR)
    public void removeFocus() {
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
        loginPage.fillUsername("value")
                .removeFocusFromUsernameField();
        Assertions.assertTrue(loginPage.isNoFocus());
    }

    /** Is scroll page check. */
    @Test
    @Severity(SeverityLevel.MINOR)
    public void isScrollPage() {
        final String pageWithoutScroll = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";
        final String pageWithScroll = "https://javascript.info/size-and-scroll-window";
        JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor(getDriver());
        getDriver().get(pageWithoutScroll);
        Long innerSizeWidth = javaScriptExecutor.getInnerSize("Width");
        Long clientSizeWidth = javaScriptExecutor.getClientSize("Width");
        Long innerSizeHeight = javaScriptExecutor.getInnerSize("Height");
        Long clientSizeHeight = javaScriptExecutor.getClientSize("Height");
        Assertions.assertEquals(innerSizeWidth, clientSizeWidth,
                "there is a vertical scroll");
        Assertions.assertEquals(innerSizeHeight, clientSizeHeight,
                "there is a horizontal scroll");
    }
}
