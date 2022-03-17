package tests.fourth;

import helpers.CustomFileUtils;
import org.testng.annotations.Test;

public class FourthTest extends BaseTest4 {
    @Test
    public void test_1() {
        System.out.println("Test");
        CustomFileUtils.writeToTxt("Test\n");
    }
}
