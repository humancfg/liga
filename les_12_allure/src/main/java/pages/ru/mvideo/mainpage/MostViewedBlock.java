package pages.ru.mvideo.mainpage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class MostViewedBlock {
    @FindBy(xpath = "//h2[text()='Самые просматриваемые']/ancestor::mvid-simple-product-collection")
    private SelenideElement mostViewed;
    @FindBy(xpath = "//mvid-simple-product-collection")
    private ElementsCollection blocksCollection;

    private MostViewedBlock mostViewedBlock;

    public MostViewedBlock() {
        mostViewedBlock = Selenide.page(this);
    }

    public void clickAddToCartOnFirstActiveButton() {
        getAddToCartButtonsCollection().get(0).click();
    }

    /**
     * Проверяет виден ли блок "Самые просматриваемые"
     *
     * @return boolean
     */
    public boolean isMostViewedBlockVisible() {
        scrollEachBlock();
        mostViewed.shouldBe(visible).scrollIntoView("{block: \"center\"}");
        return mostViewed.is(visible);
    }

    /**
     * Скролит к каждому блоку в коллекции, чтобы подгрузился блок "Самые просматриваемые"
     */
    private void scrollEachBlock() {
        blocksCollection.forEach(block -> block.scrollIntoView("{block: \"center\"}"));
    }

    private ElementsCollection getAddToCartButtonsCollection() {
        By innerXpathAddToCartButtons = By.xpath(".//button[@title='Добавить в корзину']");
        return mostViewed.findAll(innerXpathAddToCartButtons);
    }
}
