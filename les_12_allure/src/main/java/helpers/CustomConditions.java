package helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CustomConditions {

    public boolean is(SelenideElement element, Condition condition) {
        return element.is(condition);
    }

}
