package model;

public class VarXBM {
    private Boolean bool;
    private final String name;

    public VarXBM(String name, Boolean bool) {
        this.name = name;
        this.bool = bool;
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
