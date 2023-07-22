package utils;

/**
 * The type String utils.
 */
public final class StringUtils {

    /**
     * Create basic auth url string.
     * @param login    the login
     * @param password the password
     * @param url      the url
     * @return the string
     */
    public static String createBasicAuthUrl(final String login, final String password, final String url) throws Exception {
        if (url.matches("https?://.*")) {
            String[] parseUrl = url.split("//");
            return parseUrl[0] + "//" + login + ":" + password + "@" + parseUrl[1];
        }
        if (url.matches("^www.*")) {
            return "http://" + login + ":" + password + "@" + url;
        } else {
            throw new Exception("invalid url");
        }
    }

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }
}
