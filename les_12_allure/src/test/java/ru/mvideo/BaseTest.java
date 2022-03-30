package ru.mvideo;

import com.codeborne.selenide.Selenide;
import driver.DriverManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.ru.mvideo.CartPage;
import pages.ru.mvideo.mainpage.HeaderMVideoMainPage;
import pages.ru.mvideo.mainpage.MostViewedBlock;
import pages.ru.mvideo.mainpage.ProductsDayBlock;
import steps.StepsCartPage;
import steps.StepsDriver;
import steps.StepsHeaderMVideoMainPage;
import steps.StepsProductsDayBlock;

public class BaseTest {
    StepsDriver stepsDriver;
    StepsHeaderMVideoMainPage stepsHeaderMVideoMainPage;
    StepsProductsDayBlock stepsProductsDayBlock;
    StepsCartPage stepsCartPage;

    HeaderMVideoMainPage headerMVidMain;
    ProductsDayBlock prodDayBlock;
    CartPage cartPage;
    MostViewedBlock mostViewedBlock;

    @BeforeAll
    public static void setUp() {
        DriverManger.configBrowser();
    }

    @BeforeEach
    void beforeEach() {
        stepsDriver = new StepsDriver();
        stepsHeaderMVideoMainPage = new StepsHeaderMVideoMainPage();
        stepsProductsDayBlock = new StepsProductsDayBlock();
        stepsCartPage = new StepsCartPage();

        headerMVidMain = new HeaderMVideoMainPage();
        prodDayBlock = new ProductsDayBlock();
        cartPage = new CartPage();
        mostViewedBlock = new MostViewedBlock();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
