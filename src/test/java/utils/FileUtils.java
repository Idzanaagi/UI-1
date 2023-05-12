package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/** The type File utils. */
public final class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads and returns the value of a cookie from a file.
     * @param filepath the path to the file with cookie
     * @return the string with cookie value
     * @throws IOException the io exception
     */
    public static String readLine(final String filepath) throws IOException {
        String value = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            value = reader.readLine();
        }
        return value;
    }

    /**
     * Check for the existence of a file.
     * @param filepath the path to the file the existence of which need to check
     * @return the boolean (file exists or no)
     */
    public static boolean isFileExist(final String filepath) {
        return new File(filepath).exists();
    }
}
