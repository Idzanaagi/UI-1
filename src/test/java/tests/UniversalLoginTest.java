package tests;

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


@Epic("parametrized-login")
public class UniversalLoginTest extends BaseTest {

    private static final String validUsername = readProperty("validUsername");

    private static final String validPassword = readProperty("validPassword");

    private static final String validUsernameDescription = readProperty("validUsernameDescription");

    private static final String invalidValue = readProperty("invalidValue");

    private static final String invalidLengthValue = readProperty("invalidLengthValue");

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(validUsername, validPassword, validUsernameDescription),
                Arguments.of(invalidValue, validPassword, validUsernameDescription),
                Arguments.of(validUsername, invalidValue, validUsernameDescription),
                Arguments.of(invalidLengthValue, validPassword, validUsernameDescription),
                Arguments.of(validUsername, invalidLengthValue, validUsernameDescription),
                Arguments.of(validUsername, validPassword, invalidLengthValue),
                Arguments.of("", validPassword, validUsernameDescription),
                Arguments.of(validUsername, "", validUsernameDescription),
                Arguments.of(validUsername, validPassword, "")
        );
    }

    @ParameterizedTest
    @Story("User logs in with valid and invalid data")
    @MethodSource("dataProvider")
    void universalLogin(String name, String password, String description)  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.launch()
                .fillUsername(name)
                .fillPassword(password)
                .fillUsernameDescription(description)
                .clickLoginBtn();
        homePage.waitHomePageLoad();
        Assertions.assertEquals("Logout", homePage.getLogoutLinkText(), "Logout link doesn't contain the text 'Logout'");
    }
}
