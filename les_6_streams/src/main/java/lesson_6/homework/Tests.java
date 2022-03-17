package lesson_6.homework;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Tests {
    public static void main(String[] args) {
        test_2();
    }

    /**
     * Получить List чисел в виде текстовых элементов
     */
    public static void test_1() {
        List<Integer> integerList = getIntList();
        integerList.stream()
                .map(String::valueOf)
                .forEach(i -> System.out.println(i.getClass()));
    }

    /**
     * Отсортировать список по убыванию
     */
    public static void test_2() {
        List<Integer> integerList = getIntList();
        integerList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * Получить одну строку текста. Каждый элемент должен начинаться с текста "Number - ".
     * Элементы должны разделяться запятой и пробелом.
     * В начале итоговой строки должен быть текст "Number list: "
     * В конце итоговой строки должен быть текст "end of list.".
     */
    public static void test_3() {
        List<String> stringList = getStringList();
        System.out.println(
                stringList.stream()
                        .map(x -> "Number - " + x)
                        .collect(joining(", \n", "Number list: \n", "\nEnd of list.")));
    }

    /**
     * Получить мапу со значениями, ключи которых больше трех и меньше девяти
     */
    public static void test_4() {
        Map<Integer, String> map = getMap();
        System.out.println("Original: ");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("Transform: ");
        map.entrySet().stream()
                .filter(k -> k.getKey() > 3 && k.getKey() < 9)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * Перемешать все элементы в мапе.
     * Пример результата:
     * Элемент 1: ключ - 5, значение "five"
     * Элемент 2: ключ - 7, значение "seven"
     * Элемент 3: ключ - 2, значение "two"
     * и так далее.
     */
    public static void test_5() {
        Map<Integer, String> map = getMap();
        System.out.println("===== Original: ");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        Map<Integer, String> newMap = map.entrySet().stream().collect(toMap(
                Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, IdentityHashMap::new
        ));
        System.out.println("===== Transform: ");
        newMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * Установить во всех элементах isDisplayed = true, и оставить в списке только элементы с value NULL.
     */
    public static void test_6() {
        List<WebElement> elements = getElements();
        elements.stream()
                .peek(ele -> ele.setDisplayed(true))
                .filter(ele -> ele.getValue() == null)
                .forEach(ele -> System.out.println(ele.getValue()));
    }

    /**
     * Инвертировать isDisplayed параметр каждого элемента и отсортировать список по типу элемента
     * со следующим приоритетом:
     * 1. TEXT
     * 2. INPUT_FIELD
     * 3. CHECKBOX
     * 4. BUTTON
     * 5. RADIO_BUTTON
     * 6. IMAGE
     */
    public static void test_7() {
        List<WebElement> elements = getElements().stream()
                .peek(x -> x.setDisplayed(!x.isDisplayed()))
                .sorted((Comparator.comparing(WebElement::getType))).collect(toList());
        elements.forEach(x -> System.out.println(x.isDisplayed() + "-" + x.getType()));
    }

    /**
     * Создать мапу:
     * ключ - текст
     * значение - тип элемента
     */
    public static void test_8() {
        List<WebElement> elements = getElements();
        Map<String, Type> newMap = elements.stream()
                .collect(toMap(WebElement::getText, WebElement::getType, (o1, o2) -> o1, HashMap::new));
        newMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * Получить список элементов, у которых текст или значение оканчивается на число от 500 и более.
     * И отсортировать по увеличению сначала элементы с текстом, а затем по убыванию элементы со значением.
     */
    public static void test_9() {
        List<WebElement> elements = getElements();
        List<Integer> num = elements.stream()
                .filter(x -> x.getText() != null)
                .map(x -> x.getText().replace("Text of element ", ""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .filter(x -> x >= 500)
                .sorted()
                .peek(x -> System.out.println(x))
                .collect(toList());
//        textNum.forEach(System.out::println);
        System.out.println("=================");
        List<Integer> valueNum = elements.stream()
                .filter(x -> x.getValue() != null)
                .map(x -> x.getValue().replace("Value of element ", ""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .filter(x -> x >= 500)
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        valueNum.forEach(System.out::println);

    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        return map;
    }

    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("one");
        list.add("nine");
        list.add("ten");
        return list;
    }

    public static List<Integer> getIntList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;
    }

    public static List<WebElement> getElements() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            result.add(new WebElement());
        }
        return result;
    }
}
