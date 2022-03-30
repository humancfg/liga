package helpers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;

public class CustomCondition {

    /**
     * Если атрибут class не содержит disabled, значит кнопка кликабельна (активна)
     * @return condition
     */
    public static Condition existsAndEnabled() {
        return and("visible and enabled", exist,
                not(have(attribute("class", "disabled"))));
    }

    /**
     * Если атрибут class содержит disabled, значит кнопка не кликабельна (не активна)
     * @return condition
     */
    public static Condition existsAndDisabled() {
        return and("visible and disabled", visible,
                have(attribute("class", "disabled")));
    }
}
