package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.LoginPage;


public class JSExecutorTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    public void removeFocus() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername("value")
                .removeFocusFromUsernameFieldWithJS();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void isScrollPage() {
        final String pageWithoutScroll = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";
        final String pageWithScroll = "https://javascript.info/size-and-scroll-window";
        LoginPage loginPage = new LoginPage(driver);
        driver.get(pageWithScroll);
        Long innerSizeWidth = loginPage.getInnerSizeWithJS("Width");
        Long clientSizeWidth = loginPage.getClientSizeWithJS("Width");
        Long innerSizeHeight = loginPage.getInnerSizeWithJS("Height");
        Long clientSizeHeight = loginPage.getClientSizeWithJS("Height");
        Assertions.assertEquals(innerSizeWidth, clientSizeWidth,
                "there is a vertical scroll");
        Assertions.assertEquals(innerSizeHeight, clientSizeHeight,
                "there is a horizontal scroll");
    }
}
