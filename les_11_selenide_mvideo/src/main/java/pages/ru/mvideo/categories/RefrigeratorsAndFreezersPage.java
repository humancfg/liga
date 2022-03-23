package pages.ru.mvideo.categories;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RefrigeratorsAndFreezersPage {

    private ElementsCollection productCardList = $$x("//div[contains(@class, 'product-cards-layout__item')]");
    private SelenideElement productCardsLoader = $x("//div[@class='skeleton']");
    private SelenideElement viewSwitcherGrid = $x("//div[contains(@class, 'listing-view-switcher__pointer--grid')]");
    private SelenideElement asideFiltersMenu = $x("//div[contains(@class, 'modal-filters')]");
    private ElementsCollection paginationLinks = $$x("//li[contains(@class, 'page-item')]");
    private String innerXpathTitle = ".//a[@class='product-title__text']";

    /**
     * Кликает на название чекбокса, с помощью внутренних локаторов.
     * Ожидает исчезновения лоадера, который появляется перед обновлением списка продуктовых карточек
     *
     * @see #clickDropDownList(SelenideElement)
     * @see #clickOnShowAll(SelenideElement)
     */
    public void setUpFilter(String filterName, String checkboxName) {
        By innerXpathFilter = By.xpath(".//*[normalize-space(text())='" + filterName + "']");
        By innerXpathCheckbox = By.xpath("./../..//*[normalize-space(text())='" + checkboxName + "']");
        clickDropDownList(asideFiltersMenu.find(innerXpathFilter));
        clickOnShowAll(asideFiltersMenu.find(innerXpathFilter));
        asideFiltersMenu.find(innerXpathFilter).find(innerXpathCheckbox).scrollIntoView("{block: \"center\"}").shouldBe(visible).click();
        productCardsLoader.shouldBe(disappear);
    }

    /**
     * Кликает на фильтр со слайдером.
     * Ожидает исчезновения лоадера, который появляется перед обновлением списка продуктовых карточек
     */
    public void setUpFilter(String sliderName) {
        By innerXpathSlider = By.xpath(".//a[normalize-space(text())='" + sliderName + "']");
        SelenideElement sliderElement = asideFiltersMenu.find(innerXpathSlider);
        sliderElement.shouldBe(visible).scrollIntoView("{block: \"center\"}").click();
        productCardsLoader.shouldBe(disappear);
    }

    /**
     * Кликает на имя чекбокса, с использованием поля ввода.
     * Ожидает исчезновения лоадера, который появляется перед обновлением списка продуктовых карточек
     */
    public void setUpFilter(String filterName, String checkboxName, String inputText) {
        By innerXpathInputField = By.xpath("./../..//input[contains(@class, 'input__field')]");
        By innerXpathFilter = By.xpath(".//*[normalize-space(text())='" + filterName + "']");
        By innerXpathCheckbox = By.xpath("./../..//*[normalize-space(text())='" + checkboxName + "']");
        clickDropDownList(asideFiltersMenu.find(innerXpathFilter));
        SelenideElement inputField = asideFiltersMenu.find(innerXpathFilter).find(innerXpathInputField);
        inputField.shouldBe(visible).sendKeys(inputText);
        asideFiltersMenu.find(innerXpathFilter).find(innerXpathCheckbox).shouldBe(visible).scrollIntoView("{block: \"center\"}").click();
        productCardsLoader.shouldBe(disappear);
    }

    /**
     * Раскрывает блок фильтра, если он не раскрыт.
     *
     * @param elementFilterName элемент с названием блока фильтра, который необходимо раскрыть
     */
    private void clickDropDownList(SelenideElement elementFilterName) {
        By innerXpathDropDown = By.xpath("./../..//form[contains(@class, 'filter-checkbox-list')]");
        SelenideElement dropDown = elementFilterName.find(innerXpathDropDown);
        elementFilterName.scrollIntoView("{block: \"center\"}");
        if (!dropDown.exists()) elementFilterName.shouldBe(visible).scrollIntoView("{block: \"center\"}").click();
    }

    /**
     * Нажимает на кнопку "Показать всё", если кнопка существует в блоке фильтра
     *
     * @param filterName элемент с названием блока фильтра, в котором необходимо нажать "Показать всё"
     */
    private void clickOnShowAll(SelenideElement filterName) {
        By innerXpathShowAll = By.xpath("./../..//p[normalize-space(text())='Показать ещё']");
        SelenideElement showAllButton = filterName.find(innerXpathShowAll);
        if (showAllButton.exists()) showAllButton.scrollIntoView("{block: \"center\"}").shouldBe(visible).click();
    }

    /**
     * Переходит на следующую страницу результатов, пока имя продукта не будет найдено.
     * Ожидает исчезновения лоадера, перекрывающего список продуктовых карточек.
     *
     * @param productName название продукта, которое необходимо найти
     * @see #isTitleExistsInProductList(String)
     */
    public void findProduct(String productName) {
        while (!isTitleExistsInProductList(productName) && paginationLinks.last().exists()) {
            clickPagination();
            productCardsLoader.shouldBe(disappear);
        }
        focusOnFoundProduct(productName);
    }

    /**
     * Формирует список продуктов, пробует найти имя продукта в списке
     */
    private boolean isTitleExistsInProductList(String productName) {
        return collectProducts().stream()
                .anyMatch(x -> x.get("PRODUCT").getText()
                        .equals(productName));
    }

    /**
     * Формирует список продуктовых карточек и скролит страницу на середину, к тому продукту, который найден
     */
    private void focusOnFoundProduct(String name) {
        collectProducts().stream()
                .filter(x -> x.get("PRODUCT").getText().equals(name))
                .findFirst()
                .get()
                .get("ELEMENT")
                .scrollIntoView("{block: \"center\"}");
    }

    /**
     * Кликает на правый уголок в пагинации (внизу страницы), если элемент пагинации присутствует в DOM.
     */
    private void clickPagination() {
        if (paginationLinks.last().exists()) {
            paginationLinks.last().scrollIntoView("{block: \"center\"}").shouldBe(visible).click();
            productCardsLoader.shouldBe(disappear);
        }
    }

    /**
     * Пробегает по списку карточек и формирует список с мапой.
     * Вместо списка с мапой, можно использовать просто лист веб-элементов.
     * Этот один из способов. Используется для того, чтобы закрепить или понять как можно работать
     * со структурами данных.
     *
     * @return список с мапой
     */
    private List<Map<String, SelenideElement>> collectProducts() {
        List<Map<String, SelenideElement>> productList = new ArrayList<>();
        productCardList.forEach(productRow -> productRow.shouldBe(visible));
        for (SelenideElement ele : productCardList) {
//            ele.scrollIntoView("{block: \"center\"}");
            if (ele.find(By.xpath(innerXpathTitle)).exists()) {
                productList.add(Map.of(
                        "ELEMENT", ele,
                        "PRODUCT", ele.find(By.xpath(innerXpathTitle))
                ));
            }
        }
        return productList;
    }

    /**
     * Ожидает исчезновения лоадера, перекрывающего список продуктовых карточек.
     * Кликает на кнопку отображения результатов в виде списка, если список отображается сеткой
     */
    public void changeViewSwitcherToList() {
        productCardsLoader.shouldBe(disappear);
        By innerXpathButtonList = By.xpath("./../..//mvid-button[contains(@class, 'button--list')]/button");
        if (viewSwitcherGrid.exists()) viewSwitcherGrid.find(innerXpathButtonList).shouldBe(visible).click();
    }

}
