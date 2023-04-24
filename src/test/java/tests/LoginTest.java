package tests;

import org.junit.jupiter.api.Test;
import pages.Login;
import utils.WebdriverSetting;

public class LoginTest extends WebdriverSetting {

    @Test
    public void login() {

        Login login = new Login(driver);
        login.open();
    }

}
