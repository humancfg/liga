package tests.testFile;

import helpers.CustomFileUtils;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileTxtTest {
    @Test
    public void fileContentsTest() throws IOException {
        File file1 = FileUtils.getFile("src/test/resources/expected.txt");
        File file2 = CustomFileUtils.getActualFileData();
        String expected = FileUtils.readFileToString(file1);
        String actual = FileUtils.readFileToString(file2);
        Assert.assertEquals(actual, expected, "Содержимое файлов не совпадает");
    }
}
