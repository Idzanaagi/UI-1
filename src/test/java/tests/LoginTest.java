package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.Color;

import pages.LoginPage;
import pages.HomePage;

import static utils.DataProperties.readProperty;

/** The type Login test. */
@Epic("Login")
public class LoginTest extends BaseTest {

    /** Open page. */
    @BeforeEach
    public void openPage() {
        BasePage basePage = new BasePage(getDriver());
        basePage.launch(readProperty("loginPageUrl"));
    }

    /** Login successfully. */
    @Test
    @Story("User is successfully logged in")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfully() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.fillUsername(readProperty("validUsername"))
                .fillPassword(readProperty("validPassword"))
                .fillUsernameDescription(readProperty("validUsernameDescription"))
                .clickLoginBtn()
                .waitPageLoad("https://www.way2automation.com/angularjs-protractor/registeration/#/");
        Assertions.assertEquals("Logout", homePage.getLogoutLinkText(),
                "Logout link doesn't contain the text 'Logout'");
    }

    /** Login with invalid username. */
    @Test
    @Feature("Error message")
    @Story("User enters the wrong Username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername(readProperty("invalidValue"))
                .fillPassword(readProperty("validPassword"))
                .fillUsernameDescription(readProperty("validUsernameDescription"))
                .clickLoginBtn()
                .waitPageLoad(readProperty("loginPageUrl"));
        Assertions.assertEquals(readProperty("loginPageUrl"), getDriver().getCurrentUrl(),
                "expected and received url did not match");
        Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect",
                "error message doesn't contain the expected text");
    }

    /** Login with invalid password. */
    @Test
    @Feature("Error message")
    @Story("User enters the wrong Password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername(readProperty("validUsername"))
                .fillPassword(readProperty("invalidValue"))
                .fillUsernameDescription(readProperty("validUsernameDescription"))
                .clickLoginBtn()
                .waitPageLoad(readProperty("loginPageUrl"));
        Assertions.assertEquals(readProperty("loginPageUrl"), getDriver().getCurrentUrl(),
                "expected and received url did not match");
        Assertions.assertEquals("Username or password is incorrect", loginPage.getFailedLoginMessage(),
                "error message doesn't contain the expected text");
    }

    /** Login with empty username field. */
    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillPassword(readProperty("validPassword"))
                .fillUsernameDescription(readProperty("validUsernameDescription"));
        Assertions.assertFalse(loginPage.isBtnLoginEnabled(), "Login button status is not 'Disabled'");
    }

    /** Login with empty password field. */
    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername(readProperty("validUsername"))
                .fillUsernameDescription(readProperty("validUsernameDescription"));
        Assertions.assertFalse(loginPage.isBtnLoginEnabled(), "Login button status is not 'Disabled'");
    }

    /** Login with empty username description field. */
    @Test
    @Feature("Login button status")
    @Story("User doesn't fill the Username Description field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername(readProperty("validUsername"))
                .fillPassword(readProperty("validPassword"));
        Assertions.assertFalse(loginPage.isBtnLoginEnabled(), "Login button status is not 'Disabled'");
    }

    /** Username error message with invalid length values. */
    @Test
    @Feature("Error message")
    @Story("User filled the Username field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername(readProperty("invalidLengthValue"));
        Assertions.assertEquals("Your username must be between 3 and 50 characters long", loginPage.getUsernameFieldMessage(),
                "error message doesn't match the expected one");
    }

    /** Password error message with invalid length values. */
    @Test
    @Feature("Error message")
    @Story("User filled the Password field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillPassword(readProperty("invalidLengthValue"));
        Assertions.assertEquals("Your password must be between 3 and 100 characters long", loginPage.getPasswordFieldMessage(),
                "error message doesn't contain the expected text");
    }

    /** Username description error color with invalid length values. */
    @Test
    @Feature("Error message")
    @Story("User filled the Username Description field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsernameDescription(readProperty("invalidLengthValue"))
                .removeFocusFromLastField();
        Assertions.assertEquals("#a94442", Color.fromString(loginPage.getUsernameDescriptionTitleColor()).asHex(),
                "error message doesn't contain the expected text");
    }

    /** Overflow username field. */
    @Test
    @Feature("Overflow field")
    @Story("User overflows the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowUsernameField() {
        LoginPage loginPage = new LoginPage(getDriver());
        final int maxLength = 50;
        loginPage.fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(maxLength, loginPage.getUsernameInputValue().length(),
                "resulting value length is not equal to 50");
    }

    /** Overflow password field. */
    @Test
    @Feature("Overflow field")
    @Story("User overflows the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowPasswordField() {
        LoginPage loginPage = new LoginPage(getDriver());
        final int maxLength = 100;
        loginPage.fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(maxLength, loginPage.getPasswordInputValue().length(),
                "the resulting value length is not equal to 50");
    }

    /** Hint to empty username field. */
    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the Username field")
    @Severity(SeverityLevel.MINOR)
    public void hintToEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assertions.assertEquals("You did not enter a username", loginPage.getUsernameFieldMessage(),
                "the hint text doesn't match");
    }

    /** Hint to empty password field. */
    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the Password field")
    @Severity(SeverityLevel.MINOR)
    public void hintToEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assertions.assertEquals("You did not enter a password", loginPage.getPasswordFieldMessage(),
                "the hint text doesn't match");
    }

    /** Hint to empty username description field. */
    @Test
    @Feature("Field tip")
    @Story("User hasn't yet entered a value in the User Description field")
    @Severity(SeverityLevel.NORMAL)
    public void hintToEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assertions.assertEquals("username description", loginPage.getUsernameDescriptionFieldMessage(),
                "the hint text doesn't match");
    }
}
