import Calender.Exceptions.IncorrectArgumentException;
import Calender.Exceptions.TaskNotFoundException;
import Calender.TaskService;

import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static void printSeparator() {
        System.out.println("===========================================================");
    }

    public static void main(String[] args) throws IncorrectArgumentException, TaskNotFoundException {
        printSeparator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню");
        printMenu();
        if (scanner.hasNext()) {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    TaskService.addTask(scanner);
                    break;
                case 2:
                    TaskService.deleteTask(scanner);
                    break;
                case 3:
                    TaskService.getTasksByDay(scanner);
                    break;
                case 0:
                    break;
            }
        } else {
            scanner.hasNext();
            System.out.println("Выберите пункт меню ");

        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу " +
                "\n2. Удалить задачу " +
                "\n3. Задачи на день" +
                "\n0. Выход"
        );
        printSeparator();
    }




}

