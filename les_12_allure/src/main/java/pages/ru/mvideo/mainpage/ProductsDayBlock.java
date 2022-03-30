package pages.ru.mvideo.mainpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsDayBlock {
    private SelenideElement rootProductsDayBlock = $x("//mvid-day-products-block");
    private SelenideElement mainDayProductBlock = $x("//mvid-day-product[contains(@class,'main')]");
    private By mainCartAddButtonXpath = By.xpath(".//span[normalize-space(text())='В корзину']/ancestor::button");
    private By mainCartTitleXpath = By.xpath(".//div[contains(@class, 'title')]");
    private By mainCartPriceXpath = By.xpath(".//span[contains(@class, 'price__main-value')]");


    public Map<String, String> mainProductMap = new HashMap<>();

    /**
     * Проверяет отображение блока "Товары дня"
     *
     * @return boolean
     * @see SelenideElement#is(Condition visible)
     */
    public boolean isProductsDayBlockVisible() {
        return rootProductsDayBlock.shouldBe(visible).is(visible);
    }

    public void clickAddToCartButton() {
        saveValuesFromMainProductBlock();
        mainDayProductBlock.find(mainCartAddButtonXpath).click();
    }

    public void saveValuesFromMainProductBlock() {
        mainProductMap.put("name", mainDayProductBlock.find(mainCartTitleXpath).getText());
        mainProductMap.put("price", mainDayProductBlock.find(mainCartPriceXpath).getText());
    }

    public Map<String, String> getMainProductMap() {
        return mainProductMap;
    }
}
