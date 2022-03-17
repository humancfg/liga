package tests.first;

import helpers.CustomFileUtils;
import org.testng.annotations.*;

public class BaseTest1 {
    @BeforeSuite
    public void beforeSuite() {
        CustomFileUtils.cleanTxtFile();
        System.out.println("BeforeSuite");
        CustomFileUtils.writeToTxt("BeforeSuite\n");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
        CustomFileUtils.writeToTxt("BeforeClass\n");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        CustomFileUtils.writeToTxt("AfterMethod\n");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
        CustomFileUtils.writeToTxt("AfterSuite");
    }
}
