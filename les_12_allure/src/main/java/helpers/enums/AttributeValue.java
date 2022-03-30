package helpers.enums;

public enum AttributeValue {
    DISABLED("disabled"),
    MAIN("mainpage");

    private String value;

    AttributeValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
