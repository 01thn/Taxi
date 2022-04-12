package com.thn.taxi.reporitory;

import java.sql.*;

public class OrderRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/taxi";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String MAKE_ORDER = "insert into orders (place_from, place_to, is_active, client_id) values (?,?,?,?)";
    private static final String GET_DRIVER = "select * from driver where id = ?";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection error");
        }
    }

    public static boolean makeOrder(String login, String placeFrom, String placeTo) {
        boolean result = false;
        int userId = getUserId(login);
        try {
            PreparedStatement ps = connection.prepareStatement(MAKE_ORDER);
            ps.setString(1, placeFrom);
            ps.setString(2, placeTo);
            ps.setBoolean(3, true);
            ps.setInt(4, userId);

            result = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception");
        }
        return result;
    }

    private static int getUserId(String login) {
        int id = 1;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_DRIVER);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
