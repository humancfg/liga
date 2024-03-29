package lesson_3.homework;

/**
 * Интерфейс – это ссылочный тип данных
 * Классы, которые имплементируют интерфейсы (реализовывают) наследуют все методы интерфейса и должны их реализовать.
 * Интерфейс описывает только поведение объекта, которое должно быть реализовано классом.
 * Интерфейс может иметь любое количество методов.
 * Интерфейс не может иметь экземпляра.
 * Интерфейс не имеет конструктора.
 * Классы именно имплементируют (реализовывают) интерфейсы, а не наследуют.
 * Класс может имплементировать несколько интерфейсов
 */
public interface Element {
    String getType();

    String click();
}
