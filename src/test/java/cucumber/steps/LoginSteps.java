package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

/**
 * The type Login steps.
 */
public class LoginSteps {

    /**
     * Field - webdriver.
     */
    private final WebDriver driver = Hooks.getDriver();

    /**
     * LoginPage - LoginPage.
     */
    private final LoginPage loginPage = new LoginPage(driver);

    /**
     * HomePage - webdriver.
     */
    private final HomePage homePage = new HomePage(driver);

    /**
     * Open page.
     * @param url the url
     */
    @When("user opens page {string}")
    public void openPage(final String url) {
        driver.get(url);
    }

    /**
     * User enters username and password and description.
     * @param username the username
     * @param password the password
     * @param descr    the descr
     */
    @When("^user enters (.*) and (.*) and (.*)$")
    public void userEntersUsernameAndPasswordAndDescription(final String username, final String password, final String descr) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.fillUsernameDescription(descr);
    }

    /**
     * Click login btn.
     */
    @And("clicks login btn")
    public void clickLoginBtn() {
        loginPage.clickLoginBtn();
    }

    /**
     * Wait page load.
     * @param url the url
     */
    @And("waits page load {string}")
    public void waitPageLoad(final String url) {
        loginPage.waitPageLoad(url);
    }

    /**
     * Click logout btn.
     */
    @Then("clicks logout btn")
        public void clickLogoutBtn() {
            homePage.clickLogoutBtn();
        }

    /**
     * Compare url.
     * @param url the url
     */
    @Then("user is redirected to the page {string}")
    public void compareUrl(final String url) {
        Assertions.assertEquals(driver.getCurrentUrl(), url, "expected and received url did not match");
    }

    /**
     * Check successfully login.
     */
    @Then("check successfully login")
    public void checkSuccessfullyLogin() {
        String url = "https://www.way2automation.com/angularjs-protractor/registeration/#/";
        waitPageLoad(url);
        Assertions.assertEquals("https://www.way2automation.com/angularjs-protractor/registeration/#/",
                driver.getCurrentUrl(), "expected and received url did not match");
    }

    /**
     * Check login with incorrect username or password.
     * @param username the username
     * @param password the password
     */
    @Then("^check failed login for (.*) or (.*) of incorrect values$")
    public void checkLoginWithIncorrectUsernameOrPassword(final String username, final String password) {
        if (username.contentEquals("test") || password.contentEquals("test")) {
            Assertions.assertEquals("Username or password is incorrect", loginPage.getFailedLoginMessage(),
                    "error message doesn't contain the expected text");
        }
    }

    /**
     * Check login with invalid length values.
     * @param username the username
     * @param password the password
     * @param descr    the descr
     */
    @Then("^check failed login for (.*) or (.*) or (.*) of invalid value length$")
    public void checkLoginWithInvalidLengthValues(final String username, final String password, final String descr) {
        int minLength = 3;
        if (username.length() <= minLength || password.length() <= minLength || descr.length() <= minLength) {
            Assertions.assertFalse(loginPage.isBtnLoginEnabled(), "Login button status is not 'Disabled");
        }
    }
}
