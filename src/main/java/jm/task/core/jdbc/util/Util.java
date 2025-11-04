package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // Настройки подключения к базе данных
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() {
        try {
            // Регистрируем драйвер
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(true); // Включаем авто-коммит

            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }
}
