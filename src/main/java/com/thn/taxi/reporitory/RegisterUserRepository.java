package com.thn.taxi.reporitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/taxi";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String REG_USER = "insert into users (login, password, name) values (?,?,?)";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection error");
        }
    }

    public static boolean registerUser(String login, String password, String name) {
        boolean result = false;
        try {
            PreparedStatement ps = connection.prepareStatement(REG_USER);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, name);

            result = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception");
        }
        return result;
    }
}
