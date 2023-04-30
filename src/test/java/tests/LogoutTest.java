package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import pages.HomePage;
import pages.LoginPage;
import utils.ChromeDriverOptions;


@Epic("Logout")
public class LogoutTest {

    public static WebDriver driver;

    private static final String loginPageUrl;

    private static final String validUsername;

    private static final String validPassword;

    private static final String validUsernameDescription;

    static {
        try {
            String filePath = "src/test/java/resources/testData.properties";
            Properties props = new Properties();
            FileInputStream ip = new FileInputStream(filePath);
            props.load(ip);
            validUsername = props.getProperty("validUsername");
            validPassword = props.getProperty("validPassword");
            validUsernameDescription = props.getProperty("validUsernameDescription");
            loginPageUrl = props.getProperty("loginPageUrl");
            ip.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void setUp() {
        ChromeDriverOptions options = new ChromeDriverOptions();
        driver = new ChromeDriver(options.userOptions(true));
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

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
