package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileUtils {

    public static String readLine(String filepath) throws IOException {
        String value = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            value = reader.readLine();
        }
        return value;
    }

    public static boolean isFileExist(String filepath) {
        return new File(filepath).exists();
    }
}
