package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Contains streams test  data provider
 */
public class DataProviderFactory {

    /**
     * Stream < Arguments > - запускает в одном тесте.
     * Если указать Stream < String > - каждый раз новый запуск браузера.
     */
    public static Stream<Arguments> middleHeaderButtonsNames() {
        return Stream.of(
                Arguments.of("Войти", "Статус заказа", "Сравнение", "Избранное", "Корзина")
        );
    }

    public static Stream<Arguments> disabledButtons() {
        return Stream.of(
                Arguments.of("Сравнение", "Избранное", "Корзина")
        );
    }
}
