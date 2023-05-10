package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Files {

    static public String readFile(String filepath) throws IOException {
        String value = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            value = reader.readLine();
        }
        return value;
    }

    static public boolean isFileExist(String filepath) {
        return new File(filepath).exists();
    }
}
