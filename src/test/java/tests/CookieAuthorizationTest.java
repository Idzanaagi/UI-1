package tests;

import base.BasePage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.io.IOException;

import pages.SqlExPage;
import utils.Cookies;
import utils.FileUtils;


/** The type Cookie authorization test. */
public class CookieAuthorizationTest extends BaseTest {

    /**
     * Cookie authorization. At the 1st start it is authorized with login and password. On the second, inserts a cookie.
     * @throws IOException the io exception
     */
    @Test
    public void cookieAuthorization() throws IOException {
        SqlExPage sqlExPage = new SqlExPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        String authCookieName = "PHPSESSID";
        String filepath = "cookie.txt";
        basePage.launch("https://www.sql-ex.ru/index.php");
        if (FileUtils.isFileExist(filepath)) {
            String cookieValue = FileUtils.readLine(filepath);
            Cookie cookie = new Cookie(authCookieName, cookieValue);
            getDriver().manage().addCookie(cookie);
            getDriver().navigate().refresh();
        } else {
            sqlExPage.fillLogin("co-test")
                    .fillPassword("test56")
                    .clickLoginBtn();
            Cookies.writeCookie(authCookieName, filepath, getDriver());
        }
        Assertions.assertEquals("https://www.sql-ex.ru/index.php", getDriver().getCurrentUrl(),
                "expected and received url did not match");
        Assertions.assertEquals("test5656", sqlExPage.checkPersonalLink(),
                "no link to the account settings was found");
    }
}
