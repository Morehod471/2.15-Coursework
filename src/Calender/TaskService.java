package Calender;

import Calender.Exceptions.IncorrectArgumentException;
import Calender.Exceptions.TaskNotFoundException;
import Calender.Model.*;
import Util.Validate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {

    private static Map<Integer, Task> taskMap = new HashMap<>();

    public static void addTask(Scanner scanner) throws IncorrectArgumentException {

        scanner.nextLine();
        System.out.println("Введите названия задачи ");
        String title = Validate.validTrait(scanner.nextLine());
        System.out.println("Внесите описание задачи");
        String description = Validate.validTrait(scanner.nextLine());
        System.out.println("Введите тип задачи: Рабочая/Личная");
        Type type = Type.values()[Integer.parseInt(scanner.nextLine())];
        System.out.println("Введите частоту задачи - Однократная/Ежедневная/Еженедельная/Ежемесячная/Ежегодная");
        String occurrence = String.valueOf(scanner.nextInt());
        System.out.println("Введите дату");
        scanner.nextLine();

    }

    public static void createTask(Scanner scanner, String title, String description, java.lang.reflect.Type type, String occurrence) {
        try {
            LocalDateTime taskTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Task task;
            try {
                task = createNewTask(occurrence, title, type, taskTime, description);
                System.out.println("Новая задача " + task);
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            createTask(scanner, title, description, type, occurrence);
        }
    }

    private static Task createNewTask(String occurrence, String title, java.lang.reflect.Type type, LocalDateTime localDateTime,
                                      String description) throws IncorrectArgumentException   {
        return switch (occurrence) {
            case "Однократная" -> {
                OneTimeTask oneTimeTask = new OneTimeTask(title, type, localDateTime, description);
                taskMap.put(oneTimeTask.getId(), oneTimeTask);
                System.out.println("Новая задача " + oneTimeTask);
                yield oneTimeTask;
            }
            case "Ежедневная" -> {
                DailyTask dailyTask = new DailyTask(title, type, localDateTime, description);
                taskMap.put(dailyTask.getId(), dailyTask);
                System.out.println("Новая задача " + dailyTask);
                yield dailyTask;
            }
            case "Еженедельная" -> {
                WeeklyTask weeklyTask = new WeeklyTask(title, type, localDateTime, description);
                taskMap.put(weeklyTask.getId(), weeklyTask);
                System.out.println("Новая задача " + weeklyTask);
                yield weeklyTask;
            }
            case "Ежемесячная" -> {
                MonthlyTask monthlyTask = new MonthlyTask(title, type, localDateTime, description);
                taskMap.put(monthlyTask.getId(), monthlyTask);
                System.out.println("Новая задача " + monthlyTask);
                yield monthlyTask;
            }
            case "Ежегодная" -> {
                YearlyTask yearlyTask = new YearlyTask(title, type, localDateTime, description);
                taskMap.put(yearlyTask.getId(), yearlyTask);
                System.out.println("Новая задача " + yearlyTask);
                yield yearlyTask;
            }
            default -> null;
        };
    }

    public static void getTasksByDay (Scanner scanner) {
        System.out.println("Введите дату");
        try {
            String date = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateFormatter);
            List<Task> foundEvents = findTaskByDate(requestedDate);
            System.out.println("События на " + requestedDate + ":");
            for (Task task : foundEvents) {
                System.out.println(task);
            }
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите Enter\n");
    }

    private static List<Task> findTaskByDate(LocalDate date) {
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.appearsln(LocalDate.from(date.atStartOfDay()))) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public static void deleteTask(Scanner scanner) throws TaskNotFoundException {
        System.out.println("Введите номер задачи для удаления");
        int i = scanner.nextInt();
        if (!taskMap.containsKey(i)) {
            throw new TaskNotFoundException();
        } else {
            taskMap.remove(i);
        }
    }

    public String toString() {
        return "Calender.TaskService " +
                " taskMap " + taskMap;
    }
}
