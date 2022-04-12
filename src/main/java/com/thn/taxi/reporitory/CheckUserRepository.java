package com.thn.taxi.reporitory;

import java.sql.*;

public class CheckUserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/taxi";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String CHECK_USER = "select * from users where login=? and password=?";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection error");
        }
    }

    public static boolean checkUser(String login, String password) {
        boolean result = false;
        try {
            PreparedStatement ps = connection.prepareStatement(CHECK_USER);
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) result = true;

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }
        return result;
    }
}
