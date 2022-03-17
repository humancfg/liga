package lesson_3.homework;

/**
 * Абстрактный класс не может иметь ни одного экземпляра.
 * Если мы наследуем абстрактный класс, то мы должны имплементировать все его абстрактные методы (методы без реализации).
 * Абстрактный класс может содержать обычные и/или абстрактные методы.
 * Если класс содержит хотя бы один абстрактный метод, то он должен быть объявлен, как абстрактный.
 */
public abstract class Category implements Element{
    private String iconDescription;
    private String name;

    public Category(String iconDescription, String name) {
        this.iconDescription = iconDescription;
        this.name = name;
    }

    public String getIconDescription() {
        return iconDescription;
    }

    public String getName() {
        return name;
    }

    public abstract String open();

    public abstract String hover();

}
