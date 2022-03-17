package tests.second;

import helpers.CustomFileUtils;
import org.testng.annotations.*;

public class SecondTest extends BaseTest2 {
    @Test(enabled = false)
    public void test_1() {
        System.out.println("Test");
        CustomFileUtils.writeToTxt("Test\n");
    }

    @Parameters({"data_1", "data_2"})
    @Test
    public void test_2(String testData_1, String testData_2) {
        test_1();
        test_1();
        test_1();
        System.out.println("Test data: " + testData_1 + " " + testData_2);
        CustomFileUtils.writeToTxt("Test data: " + testData_1 + " " + testData_2 + "\n");
    }

    @Test
    public void test_3() {
        test_1();
    }

    @Parameters({"data_three", "data_four"})
    @Test
    public void test_4(String testData_1, String testData_2) {
        System.out.println("Test data: " + testData_1 + " " + testData_2);
        CustomFileUtils.writeToTxt("Test data: " + testData_1 + " " + testData_2 + "\n");
    }

    @Test
    public void test_5() {
        test_1();
    }

    @Parameters({"data_true", "data_false"})
    @Test
    public void test_6(String testData_1, String testData_2) {
        System.out.println("Test data: " + testData_1 + " " + testData_2);
        CustomFileUtils.writeToTxt("Test data: " + testData_1 + " " + testData_2 + "\n");
    }
}
