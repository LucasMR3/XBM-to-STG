package model;

public class varXBM {
    private Boolean bool;
    private final String name;

    public varXBM(String name, Boolean bool) {
        this.bool = bool;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBoolean(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return '{' +
                name + '=' + bool +
                '}';
    }
}
