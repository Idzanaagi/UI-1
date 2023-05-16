package factory;

import static factory.props.ConfigurationManager.configuration;

/** The type Driver factory. */
public final class DriverFactoryManager {

    /**
     * Gets webdriver instance.
     * @return the instance
     */
     public static DriverFactory getFactory()  {
        Target target = Target.valueOf(configuration().env().toUpperCase());
        DriverFactory driverFactory = null;

        switch (target) {
            case LOCAL:
                driverFactory = new LocalDriverFactory();
                break;
            case REMOTE:
                driverFactory = new RemoteDriverFactory();
                break;
            default:
                throw new IllegalArgumentException("This ENV is not supported, use local or remote");
        }
        return driverFactory;
    }

    enum Target {
        /** Local target. */
        LOCAL,
        /** Remote target. */
        REMOTE
    }

    private DriverFactoryManager() {
        throw new IllegalStateException("Utility class");
    }
}
