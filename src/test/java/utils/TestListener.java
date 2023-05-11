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
import java.nio.file.Files;
import java.util.Optional;


public class TestListener implements TestWatcher {

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
        driver.close();
    }

    @Override
    public void testDisabled(final ExtensionContext context, final Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
        WebDriver driver = getCurrentDriver(context);
        driver.close();
    }

    @Override
    public void testSuccessful(final ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        WebDriver driver = getCurrentDriver(context);
        driver.close();
    }

    @Override
    public void testAborted(final ExtensionContext context, final Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        WebDriver driver = getCurrentDriver(context);
        driver.close();
    }

    private File getScreenShotFromAShot(final WebDriver driver) throws IOException {
        File file = new File("screenshot", "tmp.png");
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", file);
        return file;
    }

    private WebDriver getCurrentDriver(final ExtensionContext context) {
        WebDriver driver;
        Object instance = context.getRequiredTestInstance();
        try {
            driver = (WebDriver) instance.getClass().getField("driver").get(instance);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
