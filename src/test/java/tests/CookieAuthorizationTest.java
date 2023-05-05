package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.SqlExPage;
import utils.Cookies;

import java.io.File;


public class CookieAuthorizationTest extends BaseTest {

    @Test
    public void cookieAuthorization() {
        SqlExPage sqlExPage = new SqlExPage(driver);
        Cookies cookieRead = new Cookies();
        if (new File("cookie.txt").exists()) {
            sqlExPage.launch();
            Cookie setCookie = new Cookie("PHPSESSID", cookieRead.getCookie());
            driver.manage().addCookie(setCookie);
            driver.navigate().refresh();
        }
        else {
            sqlExPage.launch()
                    .fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            cookieRead.getCookie();
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", driver.getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals("https://www.sql-ex.ru/personal.php", sqlExPage.checkPersonalLink(), "no link to the account settings was found");
    }
}