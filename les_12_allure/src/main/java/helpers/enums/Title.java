package helpers.enums;

public enum Title {
    MY_CART("Моя корзина");
    private String name;

    Title(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
