package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ReadProperties;


@Epic("Logout")
public class LogoutTest extends BaseTest {

    @Test
    @Story("User is successfully logged out")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutSuccessfully()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.launch()
                .fillUsername(ReadProperties.readProperty("validUsername"))
                .fillPassword(ReadProperties.readProperty("validPassword"))
                .fillUsernameDescription(ReadProperties.readProperty("validUsernameDescription"))
                .clickLoginBtn();
        homePage.clickLogoutBtn();
        Assertions.assertEquals(driver.getCurrentUrl(), ReadProperties.readProperty("loginPageUrl"), "expected and received url did not match");
    }
}
