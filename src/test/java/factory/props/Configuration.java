package factory.props;

import org.aeonbits.owner.Config;

/** The interface Configuration. */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:grid.properties",
        "classpath:general.properties",
        "classpath:driversPath.properties"
})
public interface Configuration extends Config {
    /**
     * Target string.
     * @return the string
     */
    @Key("env")
    String env();

    /**
     * Operating System string.
     * @return the string
     */
    @Key("operatingSystem")
    String operatingSystem();

    /**
     * Linux chrome driver path string.
     * @return the string
     */
    @Key("linuxChromeDriverPath")
    String linuxChromeDriverPath();

    /**
     * Windows chrome driver path string.
     * @return the string
     */
    @Key("windowsChromeDriverPath")
    String windowsChromeDriverPath();

    /**
     * Grid url string.
     * @return the string
     */
    @Key("gridUrl")
    String gridUrl();

    /**
     * Grid port string.
     * @return the string
     */
    @Key("gridPort")
    String gridPort();
}
