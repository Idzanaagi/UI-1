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

    WebDriver driver;

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        File screenshotAs = null;
        getCurrentDriver(context);
        try {
            screenshotAs = getScreenShotFromAShot();
            Allure.addAttachment("Screenshot", Files.newInputStream(screenshotAs.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
        getCurrentDriver(context);
        driver.close();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        getCurrentDriver(context);
        driver.close();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
        getCurrentDriver(context);
        driver.close();
    }

    private File getScreenShotFromAShot() throws IOException {
        File file = new File("screenshot", "tmp.png");
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", file);
        return file;
    }

    private void getCurrentDriver(ExtensionContext context) {
        Object instance = context.getRequiredTestInstance();
        try {
            driver = (WebDriver) instance.getClass().getField("driver").get(instance);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}