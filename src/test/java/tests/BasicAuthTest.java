package tests;

import base.BasePage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasicAuthPage;

import static utils.StringUtils.createBasicAuthUrl;

/**
 * The type Basic auth test.
 */
public class BasicAuthTest extends BaseTest {

    /**
     * Basic auth.
     */
    @Test
    public void basicAuth() throws Exception {
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.launch(createBasicAuthUrl( "httpwatch", "httpwatch", "www.httpwatch.com/httpgallery/authentication/"));
        basicAuthPage.clickDisplayImageLink();
        Assertions.assertNotNull(basicAuthPage.hasSrcAttr(), "attribute src not found");
    }
}
