package tests;

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


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }


    public static WebDriver driver;

    private final String loginPageUrl = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    private final String validUsername = "angular";

    private final String validPassword = "password";

    private final String validUsernameDescription = "username";

    private final String invalidValue = "test";

    private final String invalidLengthValue = "te";


    @Test
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
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .launch()
                .fillUsername(validUsername)
                .fillPassword(invalidValue)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn()
                .waitLoginPageLoad();
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithEmptyUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword);
        Assertions.assertFalse(loginPage.getBtnLoginStatus());
    }

    @Test
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
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername(invalidLengthValue);
        Assertions.assertEquals(loginPage.getUsernameErrorMessage(), "Your username must be between 3 and 50 characters long");
    }

    @Test
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword(invalidLengthValue);
        Assertions.assertEquals(loginPage.getPasswordErrorMessage(), "Your username must be between 3 and 100 characters long");
    }

    @Test
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsernameDescription(invalidLengthValue)
                .removeFocusFromLastField();
        Assertions.assertEquals(Color.fromString(loginPage.getUsernameDescriptionTitleColor()).asHex(), "#a94442");
    }

    @Test
    public void overflowUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(loginPage.getUsernameInputValue().length(), 50);
    }

    @Test
    public void overflowPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launch()
                .fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(loginPage.getPasswordInputValue().length(), 100);
    }

}