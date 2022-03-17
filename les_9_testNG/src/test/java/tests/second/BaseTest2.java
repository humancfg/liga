package tests.second;

import helpers.CustomFileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

public class BaseTest2 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
        CustomFileUtils.writeToTxt("BeforeClass\n");
    }

    @AfterMethod
    public void afterMethod(Method method) {
        if (method.getName().equals("test_2")) {
            System.out.println("AfterMethod");
            CustomFileUtils.writeToTxt("AfterMethod\n");
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
        CustomFileUtils.writeToTxt("AfterClass\n");
    }
}
