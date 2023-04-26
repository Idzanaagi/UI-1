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


    public static WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }


    private final String loginPageUrl = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    private final String validUsername = "angular";

    private final String validPassword = "password";

    private final String validUsernameDescription = "username";

    private final String invalidValue = "test";

    private final String invalidLengthValue = "te";


    @Test
    public void loginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(validPassword);
        login.fillUsernameDescription(validUsernameDescription);
        login.clickLoginBtn();
        HomePage.waitHomePageLoad("https://www.way2automation.com/angularjs-protractor/registeration/#/");
        Assertions.assertEquals(home.getLogoutLinkText(), "Logout");
    }

    @Test
    public void loginWithInvalidUsername() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidValue);
        login.fillPassword(validPassword);
        login.fillUsernameDescription(validUsernameDescription);
        login.clickLoginBtn();
        LoginPage.waitLoginPageLoad(loginPageUrl);
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(login.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(invalidValue);
        login.fillUsernameDescription(validUsernameDescription);
        login.clickLoginBtn();
        LoginPage.waitLoginPageLoad(loginPageUrl);
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(login.getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithInvalidLengthValues() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidLengthValue);
        login.fillPassword(validPassword);
        login.fillUsernameDescription(validUsernameDescription);
        login.removeFocusFromLastField();
        Assertions.assertEquals("true", login.getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyUsernameField() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillPassword(validPassword);
        login.fillUsernameDescription(validUsernameDescription);
        Assertions.assertEquals("true", login.getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyPasswordField() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillUsernameDescription(validUsernameDescription);
        Assertions.assertEquals("true", login.getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(validPassword);
        Assertions.assertEquals("true", login.getBtnLoginStatus());
    }

    @Test
    public void logoutSuccessfully()  {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(validUsername);
        login.fillPassword(validPassword);
        login.fillUsernameDescription(validUsernameDescription);
        login.clickLoginBtn();
        home.clickLogoutBtn();
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
    }

    @Test
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername(invalidLengthValue);
        Assertions.assertEquals(login.getUsernameErrorMessage(), "Your username must be between 3 and 50 characters long");
    }

    @Test
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillPassword(invalidLengthValue);
        Assertions.assertEquals(login.getPasswordErrorMessage(), "Your username must be between 3 and 100 characters long");
    }

    @Test
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(loginPageUrl);
        loginPage.fillUsernameDescription("as");
        loginPage.removeFocusFromLastField();
        Assertions.assertEquals(Color.fromString(loginPage.getUsernameDescriptionTitleColor()).asHex(), "#a94442");
    }

    @Test
    public void overflowUsernameField() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(login.getUsernameInputValue().length(), 50);
    }

    @Test
    public void overflowPasswordField() {
        LoginPage login = new LoginPage(driver);
        driver.get(loginPageUrl);
        login.fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(login.getPasswordInputValue().length(), 100);
    }

}