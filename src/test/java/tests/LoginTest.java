package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.Color;

import static utils.ReadProperties.validUsername;
import static utils.ReadProperties.validPassword;
import static utils.ReadProperties.validUsernameDescription;
import static utils.ReadProperties.loginPageUrl;
import static utils.ReadProperties.invalidValue;
import static utils.ReadProperties.invalidLengthValue;

import pages.LoginPage;
import pages.HomePage;


@Epic("Login")
public class LoginTest extends BaseTest {

    @Test
    @Story("User is successfully logged in")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn();
        homePage.waitHomePageLoad();
        Assertions.assertEquals("Logout", homePage.getLogoutLinkText(), "Logout link doesn't contain the text 'Logout'");
    }

    @Test
    @Feature("Error message")
    @Story("User enters the wrong Username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(invalidValue)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn()
                .waitLoginPageLoad();
        Assertions.assertEquals(loginPageUrl, driver.getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect",
                "error message doesn't contain the expected text");
    }

    @Test
    @Feature("Error message")
    @Story("User enters the wrong Password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(invalidValue)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn()
                .waitLoginPageLoad();
        Assertions.assertEquals(loginPageUrl, driver.getCurrentUrl(),"expected and received url did not match");
        Assertions.assertEquals("Username or password is incorrect", loginPage.getFailedLoginMessage(),
                "error message doesn't contain the expected text");
    }

    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus(), "Login button status is not 'Disabled'");
    }

    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus(), "Login button status is not 'Disabled'");
    }

    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Username Description field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword);
        Assertions.assertFalse(loginPage.getBtnLoginStatus(), "Login button status is not 'Disabled'");
    }

    @Test
    @Feature("Error message")
    @Story("User filled the Username field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(invalidLengthValue);
        Assertions.assertEquals( "Your username must be between 3 and 50 characters long", loginPage.getUsernameFieldMessage(),
                "error message doesn't match the expected one");
    }

    @Test
    @Feature("Error message")
    @Story("User filled the Password field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(invalidLengthValue);
        Assertions.assertEquals( "Your password must be between 3 and 100 characters long", loginPage.getPasswordFieldMessage(),
                "error message doesn't contain the expected text");
    }

    @Test
    @Feature("Error message")
    @Story("User filled the Username Description field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsernameDescription(invalidLengthValue)
                .removeFocusFromLastField();
        Assertions.assertEquals("#a94442", Color.fromString(loginPage.getUsernameDescriptionTitleColor()).asHex(),
                "error message doesn't contain the expected text");
    }

    @Test
    @Feature("Overflow field")
    @Story("User overflows the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals( 50, loginPage.getUsernameInputValue().length(),
                "resulting value length is not equal to 50");
    }

    @Test
    @Feature("Overflow field")
    @Story("User overflows the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(100, loginPage.getPasswordInputValue().length(), "the resulting value length is not equal to 50");
    }

    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the Username field")
    @Severity(SeverityLevel.MINOR)
    public void hintToEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        Assertions.assertEquals("You did not enter a username", loginPage.getUsernameFieldMessage(),"the hint text doesn't match");
    }

    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the Password field")
    @Severity(SeverityLevel.MINOR)
    public void hintToEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        Assertions.assertEquals("You did not enter a password", loginPage.getPasswordFieldMessage(),"the hint text doesn't match");
    }

    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the User Description field")
    @Severity(SeverityLevel.NORMAL)
    public void hintToEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch();
        Assertions.assertEquals("username description", loginPage.getUsernameDescriptionFieldMessage(),  "the hint text doesn't match");
    }
}