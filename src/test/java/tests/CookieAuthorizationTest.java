package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SqlExPage;
import utils.Cookies;

import java.io.File;
import java.io.IOException;


public class CookieAuthorizationTest extends BaseTest {

    @Test
    public void cookieAuthorization() throws IOException {
        SqlExPage sqlExPage = new SqlExPage(driver);
        Cookies cookieRead = new Cookies();
        String expectedCookie = "PHPSESSID";
        String filePath = "cookie.txt";
        sqlExPage.launch();
        if (new File(filePath).exists()) {
            cookieRead.setCookie(expectedCookie);
        }
        else {
            sqlExPage.fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            cookieRead.getCookie(expectedCookie);
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", driver.getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals("test5656", sqlExPage.checkPersonalLink(), "no link to the account settings was found");
    }
}

/*
    @Test
    public void cookieAuthorization() throws IOException {
        SqlExPage sqlExPage = new SqlExPage(driver);
        Cookies cookieRead = new Cookies();
        String expectedCookie = "PHPSESSID";
        String filePath = "cookie.txt";
        sqlExPage.launch();
        if (cookieRead.isCookieFileExists(filePath)) {
            cookieRead.setCookie(expectedCookie);
        }
        else {
            sqlExPage.fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            cookieRead.getCookie(expectedCookie);
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", driver.getCurrentUrl(), "expected and received url did not match");
        Assertions.assertEquals("test5656", sqlExPage.checkPersonalLink(), "no link to the account settings was found");
    }
 */