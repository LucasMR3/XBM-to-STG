package model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarXBM varXBM = (VarXBM) o;
        return name.equals(varXBM.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return '{' +
                name + '=' + bool +
                '}';
    }
}
