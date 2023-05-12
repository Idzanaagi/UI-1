package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.HomePage;
import pages.LoginPage;

import static utils.DataProperties.readProperty;


@Epic("Logout")
public class LogoutTest extends BaseTest {


    /** Logout successfully. */
    @Test
    @Story("User is successfully logged out")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutSuccessfully()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch(readProperty("loginPageUrl"));
        loginPage.fillUsername(readProperty("validUsername"))
                .fillPassword(readProperty("validPassword"))
                .fillUsernameDescription(readProperty("validUsernameDescription"))
                .clickLoginBtn();
        homePage.clickLogoutBtn();
        Assertions.assertEquals(getDriver().getCurrentUrl(), readProperty("loginPageUrl"),
                "expected and received url did not match");
    }
}
