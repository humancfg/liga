package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class DriverManger {

    public static String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public static void openUrl(String url) {
        Selenide.open(url);
    }

    public static void configBrowser() {
        Configuration.pageLoadTimeout = 20000;
//        Configuration.pageLoadStrategy = "eager";
    }
}
