package lesson_4.homework;

import lesson_4.homework.interfaces.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Не обрабатывает исключение IllegalStateException: Scanner closed
     */
    @Override
    public String readCommand() {
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
