package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();


        userService.createUsersTable();

        String name1 = "Фёдор";
        userService.saveUser(name1, "Иванов", (byte) 25);
        System.out.println("User с именем — " + name1 + " добавлен в базу данных");

        String name2 = "Мария";
        userService.saveUser(name2, "Петрова", (byte) 30);
        System.out.println("User с именем — " + name2 + " добавлен в базу данных");

        String name3 = "Алексей";
        userService.saveUser(name3, "Сидоров", (byte) 22);
        System.out.println("User с именем — " + name3 + " добавлен в базу данных");

        String name4 = "Елена";
        userService.saveUser(name4, "Сыкухина", (byte) 28);
        System.out.println("User с именем — " + name4 + " добавлен в базу данных");


        List<User> users = userService.getAllUsers();
        System.out.println("\n=== Все пользователи в базе данных ===");
        for (User user : users) {
            System.out.println(user); // Будет автоматически вызываться toString()
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

        userService.close();
    }
}