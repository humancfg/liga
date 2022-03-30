package helpers.enums;

public enum Button {
    CART("Корзина");

    private String name;

    Button(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
