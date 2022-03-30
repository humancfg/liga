package helpers;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.openqa.selenium.By;

@With
@AllArgsConstructor
@NoArgsConstructor
public class FindElement {
    private SelenideElement rootSelenideElement;
    private By ancestorXpath;
    private By innerXpath;
    private String abstractStringInnerXpath;
    private String argumentForAbstractString;

    public SelenideElement getElementWithInnerStringXpath() {
        return rootSelenideElement
                .find(CustomStringFormat.formatStringToXpath(abstractStringInnerXpath, argumentForAbstractString));
    }

    public SelenideElement getElementWithInnerStringAndAncestorXpath() {
        return rootSelenideElement
                .find(CustomStringFormat.formatStringToXpath(abstractStringInnerXpath, argumentForAbstractString))
                .find(ancestorXpath);
    }

    public SelenideElement getElementWithInnerXpath() {
        return rootSelenideElement
                .find(innerXpath);
    }
}
