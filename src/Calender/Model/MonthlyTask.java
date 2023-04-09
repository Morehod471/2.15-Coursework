package Calender.Model;

import Calender.Exceptions.IncorrectArgumentException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck) {
        return (dateCheck.isAfter(getDateTime().toLocalDate())  || dateCheck.isEqual(getDateTime().toLocalDate()) &&
                dateCheck.getDayOfMonth() == getDateTime().getDayOfMonth());
    }

    @Override
    public String toString() {
        return "MonthlyTask" + super.toString();
    }
}
