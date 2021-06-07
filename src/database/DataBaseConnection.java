package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: AttendanceManagementSystem
 * Date: 07-06-2021
 */

public final class DataBaseConnection {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_management";
    private static Connection connection;

    private DataBaseConnection(){
    }

    public static void connectToDataBase(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected");
        } catch (SQLException throwables) {
            System.out.println("DataBase connection error");
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
