package Calender;

public enum Type {

    WORK("Рабочая"),
    PERSONAL("Личная");

    public final String type;

    Type(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
