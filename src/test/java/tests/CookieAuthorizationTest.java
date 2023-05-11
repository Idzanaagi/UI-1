package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.io.IOException;

import pages.SqlExPage;
import utils.Cookies;
import utils.FileUtils;


public class CookieAuthorizationTest extends BaseTest {

    @Test
    public void cookieAuthorization() throws IOException {
        SqlExPage sqlExPage = new SqlExPage(driver);
        String authCookieName = "PHPSESSID";
        String filepath = "cookie.txt";
        sqlExPage.launch();
        if (FileUtils.isFileExist(filepath)) {
            String cookieValue = FileUtils.readLine(filepath);
            Cookie cookie = new Cookie(authCookieName, cookieValue);
            driver.manage().addCookie(cookie);
            driver.navigate().refresh();
        } else {
            sqlExPage.fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            Cookies.writeCookie(authCookieName, filepath, driver);
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", driver.getCurrentUrl(),
                "expected and received url did not match");
        Assertions.assertEquals("test5656", sqlExPage.checkPersonalLink(),
                "no link to the account settings was found");
    }
}
