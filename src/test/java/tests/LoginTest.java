package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import java.time.Duration;
import java.util.Objects;

import pages.LoginPage;
import pages.HomePage;


public class LoginTest {

    public static WebDriver driver;

    private final String loginPageUrl = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    private final String validUsername = "angular";

    private final String validPassword = "password";

    private final String validUsernameDescription = "username";

    private final String invalidValue = "test";

    private final String invalidLengthValue = "te";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    @Test
    @Epic("Login")
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
        Assertions.assertEquals(homePage.getLogoutLinkText(), "Logout");
    }

    @Test
    @Epic("Login")
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
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    @Epic("Login")
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
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    @Epic("Login")
    @Feature("Login button status")
    @Story("User doesn't fill the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
    @Epic("Login")
    @Feature("Login button status")
    @Story("User doesn't fill the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
    @Epic("Login")
    @Feature("Login button status")
    @Story("User doesn't fill the Username Description field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
    @Epic("Logout")
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
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
    }

    @Test
    @Epic("Login")
    @Feature("Error message")
    @Story("User filled the Username field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(invalidLengthValue);
        Assertions.assertEquals(loginPage.getUsernameErrorMessage(), "Your username must be between 3 and 50 characters long");
    }

    @Test
    @Epic("Login")
    @Feature("Error message")
    @Story("User filled the Password field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(invalidLengthValue);
        Assertions.assertEquals(loginPage.getPasswordErrorMessage(), "Your username must be between 3 and 100 characters long");
    }

    @Test
    @Epic("Login")
    @Feature("Error message")
    @Story("User filled the Username Description field with too short a value")
    @Severity(SeverityLevel.MINOR)
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsernameDescription(invalidLengthValue)
                .removeFocusFromLastField();
        Assertions.assertEquals(Color.fromString(loginPage.getUsernameDescriptionTitleColor()).asHex(), "#a94442");
    }

    @Test
    @Epic("Login")
    @Feature("Overflow field")
    @Story("User overflows the Username field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(loginPage.getUsernameInputValue().length(), 50);
    }

    @Test
    @Epic("Login")
    @Feature("Overflow field")
    @Story("User overflows the Password field")
    @Severity(SeverityLevel.NORMAL)
    public void overflowPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(loginPage.getPasswordInputValue().length(), 100);
    }
}