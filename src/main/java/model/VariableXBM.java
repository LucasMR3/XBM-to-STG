package model;

public class VariableXBM {
    private Boolean bool;
    private final String name;

    public VariableXBM(String name, Boolean bool) {
        this.bool = bool;
        this.name = name;
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
