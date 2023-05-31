package utils;

import org.openqa.selenium.WebDriver;


/**
 * The type Tabs utils.
 */
public class TabsUtils {

    /**
     * Switch tab.
     * @param driver the driver
     * @param tabIndex the tab index
     */
    public static void switchTab(final WebDriver driver, final int tabIndex) throws Exception {
        if (driver.getWindowHandles().size() >= tabIndex) {
            driver.switchTo().window(driver.getWindowHandles().toArray()[tabIndex].toString());
        } else {
            throw new Exception("Trying to open a tab that does not exist");
        }
    }

    /**
     * Switch frame.
     * @param driver     the driver
     * @param frameIndex the frame index
     */
    public static void switchFrame(final WebDriver driver, final int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    private TabsUtils() {
        throw new IllegalStateException("Utility class");
    }
}
