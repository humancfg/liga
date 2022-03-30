package pages.ru.mvideo.mainpage;

import com.codeborne.selenide.SelenideElement;
import helpers.CustomCondition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.CustomCondition.existsAndDisabled;
import static helpers.CustomCondition.existsAndEnabled;

public class HeaderMVideoMainPage {
    private SelenideElement middleHeader = $x("//div[contains(@class,'app-header-middle')]");
    private SelenideElement cartButton = $x("//p[text()='Корзина']/ancestor::a[@class='link']");
    private SelenideElement inputSearchField = $x("//input[@class='input__field']");
    private SelenideElement searchButton = $x("//form//mvid-icon[@type='search']") ;


    public void querySearch(String query) {
        inputSearchField.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.shouldBe(visible).click();
    }

    public boolean isInputSearchVisible() {
        inputSearchField.shouldBe(visible);
        return inputSearchField.isDisplayed();
    }

    public String getCounterValueFromButton(String buttonName) {
        return getButtonCounterElement(buttonName).shouldBe(visible)
                .getText();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    /**
     * Обращается к счетчику у кнопки "Корзина" и ждет появления в нем ожидаемого значения
     *
     * @param expectedNumber число, которое ожидаем достать у счетчика
     * @see #getButtonCounterElement(String buttonName)
     */
    public void cartButtonShouldHavCount(String expectedNumber) {
        getButtonCounterElement("Корзина").shouldBe(visible).shouldHave(text(expectedNumber), Duration.ofSeconds(5));
    }

    /**
     * @param buttonName имя кнопки, которую необходимо проверить на отображение
     * @return boolean
     * @see #getButtonElement(String buttonName)
     */
    public boolean isButtonVisible(String buttonName) {
        return getButtonElement(buttonName).shouldBe(visible).is(visible);
    }

    /**
     * @param buttonName имя кнопки, которую необходимо проверить на не активность
     * @return boolean
     * @see #getAncestorBlockOfButtonElement(String buttonName)
     * @see CustomCondition#existsAndDisabled()
     */
    public boolean isButtonDisabled(String buttonName) {
        getAncestorBlockOfButtonElement(buttonName).shouldBe(existsAndDisabled());
        return getAncestorBlockOfButtonElement(buttonName).is(existsAndDisabled());
    }

    /**
     * @param buttonName имя кнопки, которую надо проверить на активность
     * @return boolean
     * @see #getAncestorBlockOfButtonElement(String buttonName)
     * @see CustomCondition#existsAndEnabled()
     */
    public boolean isButtonEnabled(String buttonName) {
        getAncestorBlockOfButtonElement(buttonName).shouldBe(existsAndEnabled());
        return getAncestorBlockOfButtonElement(buttonName).is(existsAndEnabled());
    }

    public void buttonCartShouldBeEnabled() {
        getAncestorBlockOfButtonElement("Корзина").shouldBe(existsAndEnabled(), Duration.ofSeconds(5));
    }

    /**
     * Находит у кнопки веб-элемент счетчик
     *
     * @param buttonName имя кнопки, у которой надо найти счетчик
     * @return веб-элемент счетчик
     */
    private SelenideElement getButtonCounterElement(String buttonName) {
        By ancestorXpathButtonCounter = By.xpath(".//ancestor::mvid-bubble[contains(@class, 'bubble')]");
        return getButtonElement(buttonName)
                .find(ancestorXpathButtonCounter);
    }

    /**
     * Находит (ancestor) блок предка кнопки.
     * У предка в атрибутах содержится информация об активности (кликабельности) кнопки.
     *
     * @param buttonName имя кнопки, у которой надо найти предка
     * @return ancestor блок
     * @see #getButtonElement(String buttonName)
     */
    public SelenideElement getAncestorBlockOfButtonElement(String buttonName) {
        By ancestorStatusHeaderButtonXpath = By.xpath("./ancestor::mvid-header-icon");
        return getButtonElement(buttonName)
                .find(ancestorStatusHeaderButtonXpath);
    }

    /**
     * Находит веб-элемент кнопки, соответствующий заданному выражению Xpath
     *
     * @param buttonName имя кнопки, которую необходимо
     * @return веб-элемент кнопки
     */
    public SelenideElement getButtonElement(String buttonName) {
        String abstractButtonXpathString = "//p[text()='%s']/ancestor::a[@class='link']";
        String buttonNameXpath = String.format(abstractButtonXpathString, buttonName);
        return $x(buttonNameXpath);
    }
}
