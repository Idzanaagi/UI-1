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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        LoginPage.using(driver)
                .launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn();
        HomePage.using(driver)
                .waitHomePageLoad("https://www.way2automation.com/angularjs-protractor/registeration/#/");
        Assertions.assertEquals(HomePage.using(driver).getLogoutLinkText(), "Logout");
    }

    @Test
    public void loginWithInvalidUsername() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(invalidValue)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn()
                .waitLoginPageLoad(loginPageUrl);
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(LoginPage.using(driver).getFailedLoginMessage(), "Username or password is incorrect");
    }


    @Test
    public void loginWithInvalidPassword() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(validUsername)
                .fillPassword(invalidValue)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn()
                .waitLoginPageLoad(loginPageUrl);
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Assertions.assertEquals(LoginPage.using(driver).getFailedLoginMessage(), "Username or password is incorrect");
    }

    @Test
    public void loginWithInvalidLengthValues() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(invalidLengthValue)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .removeFocusFromLastField();
        Assertions.assertEquals("true", LoginPage.using(driver).getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyUsernameField() {
        LoginPage.using(driver)
                .launch()
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertEquals("true", LoginPage.using(driver).getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyPasswordField() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(validUsername)
                .fillUsernameDescription(validUsernameDescription);
        Assertions.assertEquals("true", LoginPage.using(driver).getBtnLoginStatus());
    }

    @Test
    public void loginWithEmptyUsernameDescriptionField() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword);
        Assertions.assertEquals("true", LoginPage.using(driver).getBtnLoginStatus());
    }

    @Test
    public void logoutSuccessfully()  {
        LoginPage.using(driver)
                .launch()
                .fillUsername(validUsername)
                .fillPassword(validPassword)
                .fillUsernameDescription(validUsernameDescription)
                .clickLoginBtn();
        HomePage.using(driver)
                .clickLogoutBtn();
        Assertions.assertEquals(driver.getCurrentUrl(), loginPageUrl);
    }

    @Test
    public void usernameErrorMessageWithInvalidLengthValues() {
        LoginPage.using(driver)
                .launch()
                .fillUsername(invalidLengthValue);
        Assertions.assertEquals(LoginPage.using(driver).getUsernameErrorMessage(), "Your username must be between 3 and 50 characters long");
    }

    @Test
    public void passwordErrorMessageWithInvalidLengthValues() {
        LoginPage.using(driver)
                .launch()
                .fillPassword(invalidLengthValue);
        Assertions.assertEquals(LoginPage.using(driver).getPasswordErrorMessage(), "Your username must be between 3 and 100 characters long");
    }

    @Test
    public void usernameDescriptionErrorColorWithInvalidLengthValues() {
        LoginPage.using(driver)
                .launch()
                .fillUsernameDescription(invalidLengthValue)
                .removeFocusFromLastField();
        Assertions.assertEquals(Color.fromString(LoginPage.using(driver).getUsernameDescriptionTitleColor()).asHex(), "#a94442");
    }

    @Test
    public void overflowUsernameField() {
        LoginPage.using(driver)
                .launch()
                .fillUsername("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(LoginPage.using(driver).getUsernameInputValue().length(), 50);
    }

    @Test
    public void overflowPasswordField() {
        LoginPage.using(driver)
                .launch()
                .fillPassword("qlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdjqlicyaykldhnpvdsmpdkblhblixgghmcknfqhodrorcnkuqhsdj");
        Assertions.assertEquals(LoginPage.using(driver).getPasswordInputValue().length(), 100);
    }

}