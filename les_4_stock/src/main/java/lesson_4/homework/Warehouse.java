package lesson_4.homework;

import lesson_4.homework.interfaces.Reader;
import lesson_4.homework.utils.CustomScanner;
import lesson_4.homework.utils.Souts;

import java.util.Arrays;

public class Warehouse extends Operations {
    private Product[] productsArray;
    private int count;
    private Reader reader;

    public Warehouse(int stockSize) {
        this.productsArray = new Product[stockSize];
    }

    public Warehouse(Reader reader) {
        this.productsArray = new Product[1];
        this.reader = reader;
    }

    public void consoleRun() {
        Souts.printYouAreInConsoleMode();
        while (true) {
            if (reader == null) {
                this.reader = new ConsoleReader();
            }
            String input = CustomScanner.readCommand();
            switch (input) {
                case "help":
                    Souts.printAvailableCommands();
                    break;
                case "add":
                    Souts.printEnterProductNameForAdd();
                    String addName = CustomScanner.readCommand();
                    add(new Product(addName));
                    break;
                case "delete":
                    Souts.printEnterProductNameForDelete();
                    String deleteName = CustomScanner.readCommand();
                    delete(deleteName);
                    break;
                case "count":
                    printCount();
                    break;
                case "printall":
                    printAll();
                    break;
                case "exit":
                    System.out.println("Выход...");
                    break;
                default:
                    Souts.printWrongCommand();
                    CustomScanner.close();
                    break;
            }
        }
    }

    public void add(Product product) {
        if (!isFullArray(getProductsArray())) {
            Souts.printCurrentSize(getProductsArray());
            Arrays.fill(getProductsArray(), product);
            count++;
        } else {
            int newSize;
            Product[] newTempArray;
            if (CustomScanner.isIncreaseSizeArray()) {
                newSize = CustomScanner.specifySize();
                newTempArray = newArray(getProductsArray(), getProductsArray().length + newSize);
                setProductsArray(newTempArray);
                Souts.printCurrentSize(getProductsArray());
                fillEmptyCellsIfNull(getProductsArray(), product);
                count++;
            }
        }
    }

    public void delete(String product) {
        for (int i = 0; i < getProductsArray().length; i++) {
            if (getProductsArray()[i].toString().equals(product)) {
                getProductsArray()[i] = null;
                Souts.printDelete(product);
                count--;
            } else {
                Souts.printNotFound(product);
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < getProductsArray().length; i++) {
            if (getProductsArray()[i] != null) {
                Souts.printForEach(getProductsArray()[i].toString());
            } else {
                Souts.printNoProductsInStock();
            }
        }
    }

    public void printCount() {
        Souts.printGetCount(getCount());
    }

    private void fillEmptyCellsIfNull(Product[] array, Product product) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) array[i] = product;
        }
    }

    private Product[] newArray(Product[] originalArray, int newLength) {
        return Arrays.copyOf(originalArray, newLength);
    }

    private boolean isFullArray(Product[] array) {
        boolean result = Arrays.stream(array).anyMatch(x -> x == null);
        Souts.printEmptyCellsOrNot(result);
        if (result) {
            return false;
        }
        return true;
    }

    private Product[] getProductsArray() {
        return productsArray;
    }

    private void setProductsArray(Product[] productsArray) {
        this.productsArray = productsArray;
    }

    private int getCount() {
        return count;
    }
}
