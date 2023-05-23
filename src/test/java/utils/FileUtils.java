package utils;

import java.io.*;
import java.util.Objects;


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

    /**
     * Gets file.
     * @param pathToFile the path to file
     */
    public static void getFile(final String pathToFile) {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(Objects.requireNonNull(FileUtils.class
                .getClassLoader().getResource(pathToFile)).getFile()));
    }

    /**
     * Write line.
     * @param value the value to be written to the file
     * @param filepath the path to the file where to write the value
     * @throws IOException the io exception
     */
    public static void writeLine(final String value, final String filepath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.append(value);
            fileWriter.append("\n");
            fileWriter.flush();
        }
    }
}
