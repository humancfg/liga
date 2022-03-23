package steps;

import com.codeborne.selenide.Selenide;
import pages.ru.mvideo.categories.RefrigeratorsAndFreezersPage;


public class Steps {

    private RefrigeratorsAndFreezersPage refrigeratorsAndFreezersPage;

    public Steps() {
        this.refrigeratorsAndFreezersPage = new RefrigeratorsAndFreezersPage();
    }

    public void openUrl(String url) {
        Selenide.open(url);
    }

    public void selectFilter(String filterName, String checkboxName) {
        refrigeratorsAndFreezersPage.setUpFilter(filterName, checkboxName);
    }

    public void selectFilter(String filterName, String checkboxName, String inputText) {
        refrigeratorsAndFreezersPage.setUpFilter(filterName, checkboxName, inputText);
    }

    public void selectFilterSlider(String sliderName) {
        refrigeratorsAndFreezersPage.setUpFilter(sliderName);
    }

    public void changeViewSwitcherToList() {
        refrigeratorsAndFreezersPage.changeViewSwitcherToList();
    }

    public void findProduct(String productName) {
        refrigeratorsAndFreezersPage.findProduct(productName);
    }
}
