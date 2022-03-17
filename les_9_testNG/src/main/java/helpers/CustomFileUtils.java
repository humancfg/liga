package helpers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomFileUtils {
    private static File actualFileData = new File("src/test/resources/actual.txt");

    public static void writeToTxt(String text) {
        try {
            FileUtils.writeStringToFile(actualFileData, text, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanTxtFile() {
        try {
            FileUtils.writeStringToFile(actualFileData, "", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getActualFileData() {
        return actualFileData;
    }
}
