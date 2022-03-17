package lesson_4.homework;

public class Main {
    public static void main(String[] args) {
        runWithConsole();
    }

    public static void simpleRun() {
        Warehouse stock = new Warehouse(1);
        stock.add(new Product("apple"));
        stock.add(new Product("banana"));
        stock.printCount();
        stock.printAll();
        stock.delete("banana");
        stock.printCount();
        stock.printAll();
    }

    public static void runWithConsole() {
        new Warehouse(new ConsoleReader()).consoleRun();
    }
}
