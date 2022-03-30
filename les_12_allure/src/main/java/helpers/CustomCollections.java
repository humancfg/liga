package helpers;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@With
@AllArgsConstructor
@NoArgsConstructor
public class CustomCollections {
    private SelenideElement rootSelenideElement;
    private String abstractString;
    private String [] buttonsNames;
    private By innerXpath;
    private By ancestorXpath;

    public List<SelenideElement> getSelenideElementListWithInnerXpath() {
        List<SelenideElement> selenideElements = new ArrayList<>();

        for (String buttonName : buttonsNames) {
            SelenideElement element = new FindElement()
                    .withRootSelenideElement(rootSelenideElement)
                    .withAbstractStringInnerXpath(abstractString)
                    .withArgumentForAbstractString(buttonName)
                    .getElementWithInnerStringXpath();

            selenideElements.add(element);
        }
        return selenideElements;
    }

    public List<SelenideElement> getSelenideElementListWithInnerAndAncestorXpath() {
        List<SelenideElement> selenideElements = new ArrayList<>();

        for (String buttonName : buttonsNames) {
            SelenideElement element = new FindElement()
                    .withRootSelenideElement(rootSelenideElement)
                    .withAbstractStringInnerXpath(abstractString)
                    .withArgumentForAbstractString(buttonName)
                    .withAncestorXpath(ancestorXpath)
                    .getElementWithInnerStringAndAncestorXpath();

            selenideElements.add(element);
        }
        return selenideElements;
    }


}
