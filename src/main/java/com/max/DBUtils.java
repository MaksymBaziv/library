package com.max;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    private static Connection connection = createConnection();

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/max?user=root" +
                    "&password=1111" +
                    "&serverTimezone=UTC");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }
}
