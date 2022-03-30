package helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class CustomAssertions {
    @Step("Проверка, что {message}")
    public static void assertTrue(boolean condition, String message) {
        Assertions.assertTrue(condition, message);
    }

    @Step("Проверка, что {message}")
    public static void assertFalse(boolean condition, String message) {
        Assertions.assertFalse(condition, message);
    }

    @Step("Проверка, что {message}")
    public static void assertEquals(String expected, String actual, String message) {
        Assertions.assertEquals(expected, actual,  message);
    }
}
