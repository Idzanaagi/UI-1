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
        WIDTH("Width"),
        /** Height params. */
        HEIGHT("Height");

        /** The ValidParams. */
        private final String valueParams;

        /** The Value Params.
         * @param value the value
         * */
        Params(final String value) {
            this.valueParams = value;
        }
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
     * @param value the value (correct - WIDTH or HEIGHT)
     * @return the client size
     */
    public Long getClientSize(final String value) {
        String jsGetClientSizeScript = "return document.documentElement.client";
        String script = jsGetClientSizeScript + Params.valueOf(value).valueParams + ";";
        return (Long) js.executeScript(script);
    }

    /**
     * Gets inner size.
     * @param value the value (correct - WIDTH or HEIGHT)
     * @return the inner size
     */
    public Long getInnerSize(final String value) {
        String jsGetInnerSizeScript = "return window.inner";
        String script = jsGetInnerSizeScript + Params.valueOf(value).valueParams + ";";
        return (Long) js.executeScript(script);
    }
}
