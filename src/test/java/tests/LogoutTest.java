package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static utils.ReadProperties.validUsername;
import static utils.ReadProperties.validPassword;
import static utils.ReadProperties.validUsernameDescription;
import static utils.ReadProperties.loginPageUrl;

import pages.HomePage;
import pages.LoginPage;


@Epic("Logout")
public class LogoutTest extends BaseTest {

    @Test
    @Story("User is successfully logged out")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutSuccessfully()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn();
        homePage.clickLogoutBtn();
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl, "expected and received url did not match");
    }
}