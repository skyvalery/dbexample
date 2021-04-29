package com.jm.database;

import java.sql.*;
import java.util.Arrays;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootjm";
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO users (name, age, email) values ('Exam', 38, 'exam@email.com');");
//            int res = statement.executeUpdate("UPDATE users SET name = 'NewExam', age = 45 WHERE id=8;");
//            ResultSet res = statement.executeQuery("SELECT * FROM users;");
//            System.out.println(res);
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('user1', 10, 'user1@mail.com');");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('user2', 12, 'user12@mail.com');");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('user3', 37, 'user14@mail.com');");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
