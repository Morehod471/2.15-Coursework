package Calender.Exceptions;

public class IncorrectArgumentException extends Exception {

    private final String option;

    public IncorrectArgumentException(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Параметр " + super.getMessage() + option + " задан некорректно";
    }
}
