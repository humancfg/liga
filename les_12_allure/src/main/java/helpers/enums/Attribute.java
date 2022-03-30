package helpers.enums;

public enum Attribute {
    CLASS("class");

    private String name;

    Attribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
