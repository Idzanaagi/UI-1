package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** The type JavaScript executor. */
public class JavaScriptExecutor {

    /** The Js. */
    private final JavascriptExecutor js;

    /** The enum Params. Defines valid input parameters for methods getClientSize, getInnerSize, generateScript. */
    private enum Params {
        /** Width params. */
        Width,
        /** Height params. */
        Height;
    }

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
     * @param value the value (correct - Width or Height)
     * @return the client size
     */
    public Long getClientSize(final String value) {
        String jsGetClientSizeScript = "return document.documentElement.client";
        String script = generateScript(jsGetClientSizeScript, value);
        return (Long) js.executeScript(script);
    }

    /**
     * Gets inner size.
     * @param value the value (correct - Width or Height)
     * @return the inner size
     */
    public Long getInnerSize(final String value) {
        String jsGetInnerSizeScript = "return window.inner";
        String script = generateScript(jsGetInnerSizeScript, value);
        return (Long) js.executeScript(script);
    }

    private String generateScript(final String baseScript, final String value) {
        String script;
        if (Params.Width.toString().equals(value)) {
            script = baseScript + "Width" + ";";
        } else if (Params.Height.toString().equals(value)) {
            script = baseScript + "Height" + ";";
        } else {
            throw new IllegalArgumentException("Illegal Argument: " + value);
        }
        return script;
    }
}
