package lesson_3.homework.utils;

public class Souts {
    public static String open(String name) {
        return "Opens " + "'" + name + "'";
    }
    public static String click(String name) {
        return "Clicks on " + "'" + name + "'";
    }
    public static String getType(String name) {
        return "Type: " + name;
    }
    public static String hover(String name) {
        return "Hovers on " + name + " and opens dropdown menu";
    }
    public static void wrong() {
        System.out.println("Something went wrong. Exit...");
    }
}
