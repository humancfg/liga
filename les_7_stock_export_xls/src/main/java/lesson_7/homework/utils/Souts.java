package lesson_7.homework.utils;

import lesson_7.homework.Product;

public class Souts {

    public static void printCurrentSize(Product[] array) {
        System.out.println("Текущий размер массива - " + array.length);
    }

    public static void printEmptyCellsOrNot(boolean flag) {
        if (flag) {
            System.out.println("Есть пустые ячейки. Добавляю товар");
        } else {
            System.out.println("Нет пустых ячеек!");
        }
    }

    public static void printExtendSize() {
        System.out.println("Размер превышен. Хотите увеличить размер? ('yes', 'no')");
    }

    public static void printCancel() {
        System.out.println("Отмена операции. Выход...");
    }

    public static void printWrong() {
        System.out.println("Что-то пошло не так. Выход...");
    }

    public static void printSpecifySize() {
        System.out.println("Укажите насколько увеличить размер, чтобы добавить товар");
    }

    public static void printNotFound(String product) {
        System.out.println("Товар '" + product + "' не найден на складе");
    }
    public static void printDelete(String product) {
        System.out.println("Товар '" + product + "' удален");
    }

    public static void printForEach(String product) {
        System.out.println("Наименование: " + product);
    }

    public static void printNoProductsInStock() {
        System.out.println("На складе нет товаров");
    }

    public static void printGetCount(Integer count) {
        System.out.println("Количество товаров на складе: " + count);
    }

    public static void printEnterProductNameForDelete() {
        System.out.println("Введите имя существующего товара для удаления");
    }

    public static void printEnterProductNameForAdd() {
        System.out.println("Введите имя товара для добавления");
    }

    public static void printYouAreInConsoleMode() {
        System.out.println("Введите 'help' для показа доступных команд");
    }

    public static void printAvailableCommands() {
        System.out.println("add, delete, count, printall, export, exit");
    }

    public static void printWrongCommand() {
        System.out.println("Команда не найдена");
    }
}
