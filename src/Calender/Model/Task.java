package Calender.Model;

import Calender.Exceptions.IncorrectArgumentException;
import Util.Validate;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator = 1;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        this.title = Validate.validTrait(title);
        this.description = Validate.validTrait(description);
        this.type = type;
        this.dateTime = dateTime;
        this.id = idGenerator++;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public static String setTitle(String title) {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId() &&
                Objects.equals(getTitle(), task.getTitle()) &&
                getType() == task.getType() &&
                Objects.equals(getDateTime(), task.getDateTime()) &&
                Objects.equals(getDescription(), task.getDescription());
    }

    public String getTitle() {
        return title;
    }

    public static String setDescription(String description) {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public abstract boolean appearsln(LocalDate dateCheck);

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, description);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return " Задача: " +
                " id = " + id +
                " Заголовок = " + title +
                " Тип = " + type +
                " Время = " + dateTime +
                " Описание = " + description;
    }
}
