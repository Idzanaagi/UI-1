package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import pages.AlertsPage;

import static utils.TabsUtils.switchFrame;

/**
 * The type Alerts test.
 */
public class AlertsTest extends BaseTest {

    /**
     * Alert test.
     */
    @Story("User enters his name into alert and receives a text with his name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void alert()  {
        AlertsPage alertsPage = new AlertsPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch("https://way2automation.com/way2auto_jquery/alert.php#load_box");
        alertsPage.clickInputAlertBtn();
        switchFrame(getDriver(), 1);
        alertsPage.clickShowInputBoxBtn();
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys("random");
        alert.accept();
        Assertions.assertEquals("Hello random! How are you today?", alertsPage.getDemoText(),
                "expected and received text did not match after using input alert");
    }
}
