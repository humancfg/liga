package lesson_4.homework.utils;

import java.util.Scanner;

public class CustomScanner {
    private static Scanner sc = new Scanner(System.in);

    public static boolean isIncreaseSizeArray() {
        Souts.printExtendSize();
        String userAnswer = sc.nextLine();
        switch (userAnswer) {
            case "yes":
                return true;
            case "no":
                Souts.printCancel();
                return false;
            default:
                Souts.printWrong();
                return false;
        }
    }

    public static int specifySize() {
        Souts.printSpecifySize();
        return sc.nextInt();
    }

    public static String readCommand() {
        return sc.nextLine();
    }

    /**
     * Для отладки. Есть ряд непонятных эксепшенов
     */
    public static void close() {
        sc.close();
    }
}
