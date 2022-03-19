package ru.digitalleague.storage_example;

import com.github.javafaker.Faker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.*;

/**
 * Паттерн "Arrange, Act, Assert" (AAA)
 */
public class TestExample {
    Faker faker = new Faker();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Проверка на успешное добавление продукта
     */
    @Test
    public void addProductTest() {
        String fruit = faker.food().fruit();

        Storage.addObject(fruit, 2);

        assertTrue("Продукт отсутствует на складе", Storage.isInStock(fruit));
    }

    /**
     * Проверка получения соответствующего количества продуктов после добавления
     */
    @Test
    public void getAmountProductTest() {
        String ingredient = faker.food().ingredient();
        int amount = 2;

        Storage.addObject(ingredient, amount);

        assertEquals("Количество продуктов на складе несоответствует количеству добавленного продукта",
                amount, Storage.getProductAmount(ingredient));
    }

    /**
     * Проверка на успешное изменение размера склада после добавления продукта
     */
    @Test
    public void freeSpaceAfterAddProductTest() {
        String dish = faker.food().dish();

        Storage.addObject(dish, 2);

        assertEquals("Размер склада не изменился", 2, Storage.getFreePlaces());
    }

    /**
     * Проверка на успешное удаление существующего продукта
     */
    @Test
    public void removeExistProductTest() {
        String fruit = faker.food().fruit();

        Storage.addObject(fruit, 3);
        Storage.removeObject(fruit);

        assertFalse("Продукт не был удален со склада", Storage.isInStock(fruit));
    }

    /**
     * Проверка на неуспешное удаление не добавленного продукта
     */
    @Test
    public void removeNonExistProductTest() {
        String nonExistFruit = faker.pokemon().name();

        Storage.removeObject(nonExistFruit);

        assertFalse("Не добавленный продукт найден складе", Storage.isInStock(nonExistFruit));
    }

    /**
     * Проверка на неуспешное удаление с отрицательным значением количества продукта
     */
    @Test
    public void removeWithNegativeAmountTest() {
        String nonExistFruit = faker.pokemon().name();

        Storage.removeObject(nonExistFruit);

        assertFalse("Не добавленный продукт найден складе", Storage.isInStock(nonExistFruit));
    }

    /**
     * Проверка на успешное добавление продукта с другим названием при заполненной полке
     */
    @Test
    public void addProductWhenAnotherShelfFullFilled() {
        String fruit_1 = faker.food().fruit();
        String fruit_2 = faker.food().fruit();

        Storage.addObject(fruit_1, 10);
        Storage.addObject(fruit_2, 3);

        assertTrue("Продукт не был добавлен на склад", Storage.isInStock(fruit_2));
    }

    /**
     * Проверка на успешное частичное добавление количества продукта с тем же названием при не до конца заполненной полке
     */
    @Test
    public void addSameProductWhenShelfNotFullFilled() {
        String sushi = faker.food().sushi();
        int expectedAmount = 10;

        Storage.addObject(sushi, 9);
        Storage.addObject(sushi, 3);

        assertEquals("Количество продуктов на складе не изменилось",
                expectedAmount, Storage.getProductAmount(sushi));
    }

    /**
     *  Проверка на неуспешное добавление количества товара, превышающего максимальный размер полки
     */
    @Test
    public void addProductOverMaximumShelfSize() {
        String fruit_1 = faker.food().fruit();

        Storage.addObject(fruit_1, 11);

        assertFalse("Продукт был добавлен на склад с превышением размера полки", Storage.isInStock(fruit_1));
    }

    /**
     *  Проверка на неуспешное добавление продукта при заполненном складе
     */
    @Test
    public void addProductWhenStorageFullFiled() {
        String fruit = faker.food().fruit();
        String dish = faker.food().dish();
        String ingredient = faker.food().ingredient();
        String pokemon = faker.pokemon().name();

        Storage.addObject(fruit, 10);
        Storage.addObject(dish, 10);
        Storage.addObject(ingredient, 10);
        Storage.addObject(pokemon, 10);

        assertFalse("Продукт был добавлен при заполненном складе", Storage.isInStock(pokemon));
    }


    /**
     * Проверка на успешный проброс исключения при добавлении продукта с отрицательным значением количества
     */
    @Test
    public void addProductWithNegativeAmountTest() {
        String fruit = faker.food().fruit();

        Storage.addObject(fruit, -10);

        exception.expect(IllegalArgumentException.class);
    }
}