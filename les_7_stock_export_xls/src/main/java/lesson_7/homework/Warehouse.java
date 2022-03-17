package lesson_7.homework;

import lesson_7.homework.utils.CustomScanner;
import lesson_7.homework.utils.Souts;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Warehouse extends Operations {
    private Product[] productsArray;
    private int count;

    public Warehouse() {
        this.productsArray = new Product[10];
    }

    public void consoleRun() {
        boolean status = true;
        Souts.printYouAreInConsoleMode();
        while (status) {
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
                case "export":
                    createXlsFile();
                    System.out.println("Файл xls создан");
                    System.out.println("Выход...");
                    status = false;
                    break;
                case "exit":
                    System.out.println("Выход...");
                    status = false;
                    break;
            }
        }
    }

    private void createXlsFile() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");
        sheet.setColumnWidth(0, 3000);
        CellStyle headerStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        Row header = sheet.createRow(0);
        Cell headerName = header.createCell(0);
        headerName.setCellStyle(headerStyle);
        headerName.setCellValue("Products");
        for (int i = 0; i < getProductsArray().length; i++) {
            // add check isNull
            sheet.createRow(i + 1)
                    .createCell(0)
                    .setCellValue(getProductsArray()[i].toString());
        }
        try {
            workbook.write(new FileOutputStream("les_7_stock_export_xls/Products.xls"));
        } catch (IOException e) {
            e.printStackTrace();
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
        boolean result = Arrays.stream(array).anyMatch(Objects::isNull);
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
