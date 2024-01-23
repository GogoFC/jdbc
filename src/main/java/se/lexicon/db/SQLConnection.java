package se.lexicon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String JDBC_USERNAME = "goran";
    private static final String JDBC_PASSWORD = "Blue300@";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
