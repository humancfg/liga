package tests.fourth;

import helpers.CustomFileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest4 {
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
        CustomFileUtils.writeToTxt("BeforeTest\n");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        CustomFileUtils.writeToTxt("AfterMethod\n");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
        CustomFileUtils.writeToTxt("AfterTest\n");
    }
}
