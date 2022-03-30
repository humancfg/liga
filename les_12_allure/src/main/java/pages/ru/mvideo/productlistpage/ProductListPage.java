package pages.ru.mvideo.productlistpage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage {
    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')]//a[contains(@class, 'product-title__text')]")
    private ElementsCollection productsNames;
    @FindBy(xpath = "//div[@class='skeleton']")
    private SelenideElement skeletonLoader;
    @FindBy(xpath = "//mvid-tabs-control")
    private SelenideElement tabsControl;

    private ProductListPage productListPage;

    public ProductListPage() {
        productListPage = Selenide.page(this);
    }

    public boolean isAllProductNamesContains(String expectedName) {
        return productsNames.stream().allMatch(productName ->
                productName.scrollIntoView("{block: \"center\"}").getText().toLowerCase().contains(expectedName));
    }

    public void tabsControlShouldBeVisible() {
        tabsControl.shouldBe(visible);
    }

    public void skeletonShouldBeDisappear() {
        skeletonLoader.shouldBe(disappear);
    }

    public void scrollAllItems() {
        productsNames.forEach(ele -> ele.scrollIntoView("{block: \"center\"}"));
    }

    public void scrollToPagination() {
        $x("//mvid-pagination-controls").scrollIntoView("{block: \"center\"}");
    }

    public void printProductsNamesSize() {
        System.out.println(productsNames.size());
    }
}
