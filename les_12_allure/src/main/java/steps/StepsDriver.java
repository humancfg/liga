package steps;

import driver.DriverManger;
import io.qameta.allure.Step;

public class StepsDriver {

    @Step("Открыть сайт {url}")
    public void openUrl(String url) {
        DriverManger.openUrl(url);
    }

}
