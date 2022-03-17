package lesson_3.homework.utils;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Collections {
    private static final Scanner sc = new Scanner(System.in);

    public static String findIn(Map<String, String> commands) {
        try {
            String userInput = sc.nextLine();
            return commands.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(userInput))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            Souts.wrong();
        }
        return "Command not found!";
    }

}
