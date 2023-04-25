package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.Login;
import pages.Home;
import utils.WebdriverSetting;


public class LoginTest extends WebdriverSetting {


    private final String loginPageUrl = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    private final String validUsername = "angular";

    private final String validPassword = "password";

    private final String validUsernameDescription = "username";

    private final String invalidValue = "test";

    private final String invalidLengthValue = "te";


    @Test
    public void loginSuccessfully() {

        Login login = new Login(driver);
        Home home = new Home(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(validPassword);
        login.fillFormlyUsername(validUsernameDescription);
        login.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.way2automation.com/angularjs-protractor/registeration/#/"));
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.way2automation.com/angularjs-protractor/registeration/#/");
        Assertions.assertEquals(home.getLogoutLinkText(), "Logout");
    }

    @Test
    public void loginWithInvalidUsername() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidValue);
        login.fillPassword(validPassword);
        login.fillFormlyUsername(validUsernameDescription);
        login.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(loginPageUrl));
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(login.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithInvalidPassword() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(invalidValue);
        login.fillFormlyUsername(validUsernameDescription);
        login.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(loginPageUrl));
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(login.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithInvalidLengthValues() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidLengthValue);
        login.fillPassword(validPassword);
        login.fillFormlyUsername(validUsernameDescription);
        login.removeFocusFromLastField();
        Assertions.assertEquals("true", login.getAttributeBtnLogin());
    }

    @Test
    public void loginWithEmptyFiled() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        Assertions.assertEquals("true", login.getAttributeBtnLogin());
    }

    @Test
    public void loginWithSeveralEmptyFileds() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillFormlyUsername(validUsernameDescription);
        Assertions.assertEquals("true", login.getAttributeBtnLogin());
    }

    @Test
    public void loginWithAllEmptyFileds() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        Assertions.assertEquals("true", login.getAttributeBtnLogin());
    }

    @Test
    public void logoutSuccessfully()  {

        Login login = new Login(driver);
        Home home = new Home(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(validPassword);
        login.fillFormlyUsername(validUsernameDescription);
        login.clickLoginBtn();
        home.clickLogoutBtn();
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
    }

    @Test
    public void usernameErrorMessageWithInvalidLengthValues() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidLengthValue);
        Assertions.assertEquals(login.getUsernameErrorMessage(), "Your username must be between 3 and 50 characters long");
    }

    @Test
    public void passwordErrorMessageWithInvalidLengthValues() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillPassword(invalidLengthValue);
        Assertions.assertEquals(login.getPasswordErrorMessage(), "Your username must be between 3 and 100 characters long");
    }

    @Test
    public void overflowUsernameField() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(login.getUsernameInputValue().length(), 50);
    }

    @Test
    public void overflowPasswordField() {

        Login login = new Login(driver);
        driver.get(loginPageUrl);
        login.fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(login.getPasswordInputValue().length(), 100);
    }

}