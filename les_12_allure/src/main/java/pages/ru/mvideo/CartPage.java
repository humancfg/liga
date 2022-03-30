package pages.ru.mvideo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private SelenideElement cartPageTitle =$x("//span[text()='Моя корзина']");
    private ElementsCollection productsCartOrders = $$x("//div[@class='c-cart__order']");
    private SelenideElement goToCheckoutInputButton = $x("//input[@value='Перейти к оформлению']");
    private SelenideElement costLineTitle =
            $x("//div[@class='c-orders-list__content']//span[@class='c-cost-line__title']");
    private SelenideElement costLinePrice =
            $x("//div[@class='c-orders-list__content']//span[@class='c-cost-line__text']");
    private ElementsCollection cartItemsPriceCollection = $$x("//span[@class='c-cart-item__price']");

    /**
     * Достает текст из элемента ("В корзине N товар(ов)")
     *
     * @return actualText
     */
    public String getCostLineTitleText() {
        return costLineTitle.shouldBe(visible).getText();
    }

    /**
     * Достает общую стоимость из правого блока
     *
     * @return actual value
     */
    public String getCostLinePrice() {
        return costLinePrice.getOwnText()
                .replaceAll("[\\u00A0\\s]+", "")
                .replace('¤', ' ')
                .trim();
    }

    /**
     * Достает цену из первой карточки с наименованием товара
     * (Используется, если есть уверенность, что карточка в корзине только одна)
     *
     * @return actual value
     */
    public String getCartOrderPriceText() {
        cartItemsPriceCollection.shouldHave(CollectionCondition.size(1));
        return collectCartOrdersPrices().get(0);
    }

    /**
     * Видна ли кнопка "Перейти к оформлению"
     *
     * @return boolean
     */
    public boolean isGoToCheckoutButtonVisible() {
        return goToCheckoutInputButton.shouldBe(visible).is(visible);
    }

    /**
     * Видна ли карточка с наименованием товара
     *
     * @return boolean
     */
    public boolean isProductCartOrderVisible() {
        return productsCartOrders.stream().allMatch(order -> order.shouldBe(visible).is(visible));
    }

    public boolean isEachOrderVisible() {
        productsCartOrders.forEach(order -> order.shouldBe(visible));
        return productsCartOrders.stream().allMatch(order->order.is(visible));
    }

    public void cartPageTitleShouldBeVisible() {
        cartPageTitle.shouldBe(visible);
    }

    /**
     * @return возвращает заголовок на веб-странице
     */
    public String getCartPageTitleText() {
        return cartPageTitle.getText();
    }

    private List<String> collectCartOrdersPrices() {
        List<String> cartPrices = new ArrayList<>();
        cartItemsPriceCollection.forEach(cart -> cart.shouldBe(visible));
        for (SelenideElement product : cartItemsPriceCollection) {
            String price = product.getOwnText()
                    .replaceAll("[\\u00A0\\s]+", "")
                    .replaceAll("\\s+","")
                    .replace('¤', ' ')
                    .strip();
            cartPrices.add(price);
        }
        return cartPrices;
    }

    public String getSumCartOrdersPrices() {
        return String.valueOf(
                collectCartOrdersPrices()
                        .stream()
                        .mapToInt(Integer::parseInt)
                        .sum()
        );
    }
}
