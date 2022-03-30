package ru.mvideo;

import driver.DriverManger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ru.mvideo.mainpage.HeaderMVideoMainPage;
import pages.ru.mvideo.productlistpage.ProductListPage;

import static helpers.CustomAssertions.assertEquals;
import static helpers.CustomAssertions.assertTrue;

@DisplayName("Проверки на главной странице mvideo")
class MVideoTest extends BaseTest {

    @DisplayName("Проверка шапки главной страницы mvideo")
    @ParameterizedTest
    @MethodSource("helpers.DataProviderFactory#middleHeaderButtonsNames")
    void headerMVideoMainPageTest(String logInButtonName, String statusOrderButtonName,
                                  String compareButtonName, String favButtonName, String cartButtonName) {
        stepsDriver.openUrl("https://www.mvideo.ru");
        assertTrue(headerMVidMain.isButtonVisible(logInButtonName), "кнопка \"" + logInButtonName + "\" отображается");
        assertTrue(headerMVidMain.isButtonEnabled(logInButtonName), "кнопка \"" + logInButtonName + "\" активна");
        assertTrue(headerMVidMain.isButtonVisible(statusOrderButtonName), "кнопка \"" + statusOrderButtonName + "\" отображается");
        assertTrue(headerMVidMain.isButtonEnabled(statusOrderButtonName), "кнопка \"" + statusOrderButtonName + "\" активна");
        assertTrue(headerMVidMain.isButtonVisible(compareButtonName), "кнопка \"" + compareButtonName + "\" отображается");
        assertTrue(headerMVidMain.isButtonDisabled(compareButtonName), "кнопка \"" + compareButtonName + "\" не активна");
        assertTrue(headerMVidMain.isButtonVisible(favButtonName), "кнопка \"" + favButtonName + "\" отображается");
        assertTrue(headerMVidMain.isButtonDisabled(favButtonName), "кнопка \"" + favButtonName + "\" не активна");
        assertTrue(headerMVidMain.isButtonVisible(cartButtonName), "кнопка \"" + cartButtonName + "\" отображается");
        assertTrue(headerMVidMain.isButtonDisabled(cartButtonName), "кнопка \"" + cartButtonName + "\" не активна");
    }

    @DisplayName("Проверка активации кнопки корзины")
    @ParameterizedTest(name = "Кнопка \"{0}\" в шапке становится активной и на ней отображается \"{1}\"")
    @CsvSource({"Корзина, 1"})
    void cartButtonActivationTest(String cartButtonName, String expectedNumber) {
        stepsDriver.openUrl("https://www.mvideo.ru");
        assertTrue(prodDayBlock.isProductsDayBlockVisible(), "на странице отображается блок \"Товары дня\"");
        stepsProductsDayBlock.clickAddToCartButton();
        assertTrue(headerMVidMain.isButtonEnabled(cartButtonName), "кнопка \"" + cartButtonName + "\" становится активной");
        assertEquals(headerMVidMain.getCounterValueFromButton(cartButtonName), expectedNumber,
                "на кнопке \"" + cartButtonName + "\" отображается число \"" + expectedNumber + "\"");
    }


    @Test
    @DisplayName("Переход в корзину")
    void goToCartPageTest() {
        stepsDriver.openUrl("https://www.mvideo.ru");
        assertTrue(prodDayBlock.isProductsDayBlockVisible(), "на странице отображается блок \"Товары дня\"");
        stepsProductsDayBlock.clickAddToCartButton();
        headerMVidMain.clickCartButton();
        cartPage.cartPageTitleShouldBeVisible();
        assertTrue(DriverManger.getCurrentUrl().endsWith("/cart"), "открывается страница \"/cart\"");
        assertTrue(cartPage.getCartPageTitleText().equals("Моя корзина"),
                "отображается заголовок \"Моя корзина\"");
        assertTrue(cartPage.isProductCartOrderVisible(),
                "отображается карточка с наименованием добавленного товара");
        prodDayBlock.getMainProductMap().get("name");
        assertTrue(cartPage.isGoToCheckoutButtonVisible(), "отображается кнопка \"Перейти к оформлению\"");
        assertTrue(cartPage.getCostLineTitleText().equals("В корзине 1 товар"),
                "отображается текст \"В корзине 1 товар\"");
        assertEquals(cartPage.getCostLinePrice(), cartPage.getCartOrderPriceText(),
                "цена товара из правого блоке соответствует цене товара");
    }

    @Test
    @DisplayName("Добавление в корзину два товара")
    void addToCartTwoProductsTest() {
        stepsDriver.openUrl("https://www.mvideo.ru");
        assertTrue(mostViewedBlock.isMostViewedBlockVisible(), "на странице отображается блок \"Самые просматриваемые\"");
        mostViewedBlock.clickAddToCartOnFirstActiveButton();
        headerMVidMain.buttonCartShouldBeEnabled();
        mostViewedBlock.clickAddToCartOnFirstActiveButton();
        headerMVidMain.cartButtonShouldHavCount("2");
        headerMVidMain.clickCartButton();
        assertTrue(cartPage.isEachOrderVisible(),
                "в корзине отображается карточки с наименованиями добавленных товаров");
        assertEquals(cartPage.getSumCartOrdersPrices(), cartPage.getCostLinePrice(),
                "сумма всей корзины равна сумме цен добавленных товаров");
    }

    @Test
    @DisplayName("Поиск товаров")
    void searchProductsTest() {
        stepsDriver.openUrl("https://www.mvideo.ru");
        HeaderMVideoMainPage headerMVideoMainPage = new HeaderMVideoMainPage();
        assertTrue(headerMVideoMainPage.isInputSearchVisible(),
                "в шапке отображается строка поиска товаров");
        headerMVideoMainPage.querySearch("apple");
        headerMVideoMainPage.clickSearchButton();

        ProductListPage productListPage = new ProductListPage();

        productListPage.tabsControlShouldBeVisible();
        productListPage.skeletonShouldBeDisappear();

        assertTrue(DriverManger.getCurrentUrl().contains("/product-list-page"),
                "открыта страница \"/product-list-page\"");
        assertTrue(DriverManger.getCurrentUrl().contains("/product-list-page"),
                "открыта страница с параметрами запроса \"apple\"");
        productListPage.scrollToPagination();
        productListPage.scrollAllItems();
        assertTrue(productListPage.isAllProductNamesContains("apple"),
                "отображаются только товары содержащие в названии слово \"apple\" в любом регистре");
    }

}