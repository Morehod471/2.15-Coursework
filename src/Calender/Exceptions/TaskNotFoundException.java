package Calender.Exceptions;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException () {
    }

    public TaskNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
