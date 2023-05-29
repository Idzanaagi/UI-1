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
    @Key("remote")
    Boolean remote();

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

    /**
     * Browser string.
     * @return the string
     */
    @Key("browser")
    String browser();
}
