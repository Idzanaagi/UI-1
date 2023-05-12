package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The type JavaScript executor.
 */
public class JavaScriptExecutor {

    /** The Js. */
    private final JavascriptExecutor js;

    /**
     * Instantiates a new Java script executor.
     * @param driver the driver
     */
    public JavaScriptExecutor(final WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * Blur element.
     * @param element the element to which need to apply the script
     */
    public void blurElement(final WebElement element) {
        String jsBlurScript = "arguments[0].blur();";
        js.executeScript(jsBlurScript, element);
    }

    /**
     * Gets client size.
     * @param value the value (correct value - Width or Height)
     * @return the client size
     */
    public Long getClientSize(final String value) {
        String jsGetClientSizeScript = "return document.documentElement.client";
        String script = jsGetClientSizeScript + value + ";";
        return (Long) js.executeScript(script);
    }

    /**
     * Gets inner size.
     * @param value the value (correct value - Width or Height)
     * @return the inner size
     */
    public Long getInnerSize(final String value) {
        String jsGetInnerSizeScript = "return window.inner";
        String script = jsGetInnerSizeScript + value + ";";
        return (Long) js.executeScript(script);
    }
}
