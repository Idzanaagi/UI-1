package tests;

import base.BasePage;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import pages.HomePage;
import pages.LoginPage;

import static utils.DataProperties.readProperty;


/** The type Universal login test. */
@Epic("parametrized-login")
public class UniversalLoginTest extends BaseTest {

    /** Constant VALID_USERNAME. */
    private static final String VALID_USERNAME = readProperty("validUsername");

    /** Constant VALID_PASSWORD. */
    private static final String VALID_PASSWORD = readProperty("validPassword");

    /** Constant VALID_USERNAME_DESCRIPTION. */
    private static final String VALID_USERNAME_DESCRIPTION = readProperty("validUsernameDescription");

    /** Constant INVALID_VALUE. */
    private static final String INVALID_VALUE = readProperty("invalidValue");

    /** Constant INVALID_LENGTH_VALUE. */
    private static final String INVALID_LENGTH_VALUE = readProperty("invalidLengthValue");

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(VALID_USERNAME, VALID_PASSWORD, VALID_USERNAME_DESCRIPTION),
                Arguments.of(INVALID_VALUE, VALID_PASSWORD, VALID_USERNAME_DESCRIPTION),
                Arguments.of(VALID_USERNAME, INVALID_VALUE, VALID_USERNAME_DESCRIPTION),
                Arguments.of(INVALID_LENGTH_VALUE, VALID_PASSWORD, VALID_USERNAME_DESCRIPTION),
                Arguments.of(VALID_USERNAME, INVALID_LENGTH_VALUE, VALID_USERNAME_DESCRIPTION),
                Arguments.of(VALID_USERNAME, VALID_PASSWORD, INVALID_LENGTH_VALUE),
                Arguments.of("", VALID_PASSWORD, VALID_USERNAME_DESCRIPTION),
                Arguments.of(VALID_USERNAME, "", VALID_USERNAME_DESCRIPTION),
                Arguments.of(VALID_USERNAME, VALID_PASSWORD, "")
        );
    }

    /**
     * Universal login.
     * @param name        the username
     * @param password    the password
     * @param description the username description
     */
    @ParameterizedTest
    @Story("User logs in with valid and invalid data")
    @MethodSource("dataProvider")
    void universalLogin(final String name, final String password, final String description) {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch(readProperty("loginPageUrl"));
        loginPage.fillUsername(name)
                .fillPassword(password)
                .fillUsernameDescription(description)
                .clickLoginBtn();
        if (INVALID_VALUE.equals(name) || INVALID_VALUE.equals(password)) {
            Assertions.assertEquals(readProperty("loginPageUrl"), getDriver().getCurrentUrl(),
                    "expected and received url did not match");
            Assertions.assertEquals(loginPage.getFailedLoginMessage(), "Username or password is incorrect",
                    "error message doesn't contain the expected text");
        } else if (INVALID_LENGTH_VALUE.equals(name) || INVALID_LENGTH_VALUE.equals(password) || INVALID_LENGTH_VALUE.equals(description)
        || "".equals(name) || "".equals(password) || "".equals(description)) {
            Assertions.assertFalse(loginPage.isBtnLoginEnabled(),
                    "Login button status is not 'Disabled'");
        } else {
            Assertions.assertEquals("Logout", homePage.getLogoutLinkText(),
                    "Logout link doesn't contain the text 'Logout'");
        }
    }
}
