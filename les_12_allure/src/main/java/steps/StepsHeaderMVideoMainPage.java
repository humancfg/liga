package steps;

import io.qameta.allure.Step;
import pages.ru.mvideo.mainpage.HeaderMVideoMainPage;

public class StepsHeaderMVideoMainPage {

    @Step("Нажать на кнопку 'Корзина'")
    public void clickOnCartButtonInHeaderMenu() {
        HeaderMVideoMainPage headerMVideoMainPage = new HeaderMVideoMainPage();
        headerMVideoMainPage.clickCartButton();
    }



}
