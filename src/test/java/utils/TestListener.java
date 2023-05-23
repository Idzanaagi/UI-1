package utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Optional;


/** The type Test listener. */
public class TestListener implements TestWatcher {

    /** Override testFailed. Attach a screenshot to the report. Writes the names of failed methods to the file*/
    @Override
    public void testFailed(final ExtensionContext context, final Throwable cause) {
        File screenshotAs = null;
        WebDriver driver = getCurrentDriver(context);
        try {
            screenshotAs = getScreenShotFromAShot(driver);
            Allure.addAttachment("Screenshot", Files.newInputStream(screenshotAs.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        try {
            FileUtils.writeLine(context.getDisplayName().substring(0, context.getDisplayName().length() - 2),
                    "failedTests.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Override testDisabled, driver close. */
    @Override
    public void testDisabled(final ExtensionContext context, final Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
        WebDriver driver = getCurrentDriver(context);
        driver.quit();
    }

    /** Override testSuccessful, driver close. */
    @Override
    public void testSuccessful(final ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        WebDriver driver = getCurrentDriver(context);
        driver.quit();
    }

    /** Override testAborted, driver close. */
    @Override
    public void testAborted(final ExtensionContext context, final Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        WebDriver driver = getCurrentDriver(context);
        driver.quit();
    }

    /** Take a screenshot.
     * @param driver driver
     * @return File
     * */
    private File getScreenShotFromAShot(final WebDriver driver) throws IOException {
        File file = new File("screenshot", "tmp.png");
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", file);
        return file;
    }

    /** Get current driver.
     * @param context context
     * @return driver
     * */
    private WebDriver getCurrentDriver(final ExtensionContext context) {
        WebDriver driver;
        Object instance = context.getRequiredTestInstance();
        try {
            Method getDriver = instance.getClass().getSuperclass().getMethod("getDriver");
            getDriver.setAccessible(true);
            driver = (WebDriver) getDriver.invoke(instance);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
