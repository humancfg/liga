package steps;

import io.qameta.allure.Step;
import pages.ru.mvideo.mainpage.ProductsDayBlock;

public class StepsProductsDayBlock {

    @Step("Нажать на кнопку \"В корзину\"")
    public void clickAddToCartButton() {
        ProductsDayBlock productsDayBlock = new ProductsDayBlock();
        productsDayBlock.clickAddToCartButton();
    }
}
