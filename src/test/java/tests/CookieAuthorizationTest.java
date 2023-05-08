package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.io.IOException;

import pages.SqlExPage;
import utils.Cookies;


public class CookieAuthorizationTest extends BaseTest {

    @Test
    public void cookieAuthorization() throws IOException {
        SqlExPage sqlExPage = new SqlExPage(driver);
        Cookies cookie = new Cookies();
        String expectedCookie = "PHPSESSID";
        String filepath = "cookie.txt";
        sqlExPage.launch();
        if (cookie.isFileExist(filepath)) {
            String cookieValue = cookie.readCookie(filepath);
            Cookie setCookie = new Cookie(expectedCookie, cookieValue);
            driver.manage().addCookie(setCookie);
            driver.navigate().refresh();
        }
        else {
            sqlExPage.fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            cookie.writeCookie(expectedCookie, filepath, driver);
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", driver.getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals("test5656", sqlExPage.checkPersonalLink(), "no link to the account settings was found");
    }
}