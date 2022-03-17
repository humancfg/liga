package lesson_7.homework;

public class Main {
    public static void main(String[] args) {
        runWithConsole();
    }

    /**
     * Для проверки записи в файл достаточно ввести команду add, название и вызвать export
     * В excel будет название, продублированное 10 раз
     */
    public static void runWithConsole() {
        new Warehouse().consoleRun();
    }
}
