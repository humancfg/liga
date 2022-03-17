package tests.third;

import helpers.CustomFileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BaseTest3 {
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
        CustomFileUtils.writeToTxt("AfterClass\n");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
        CustomFileUtils.writeToTxt("AfterTest\n");
    }
}
