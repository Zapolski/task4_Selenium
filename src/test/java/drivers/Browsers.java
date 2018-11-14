package drivers;

public enum Browsers {
    FIREFOX("firefox"),
    IEXPLORE("iexplore"),
    CHROME("chrome");

    private String value;
    Browsers(final String values) {
        value = values;
    }
    public String toString() {
        return value;
    }
}
