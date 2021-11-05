package com.mckinney.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private Connection connection;

    public ConnectionService() {
        super();

        try {
            Class.forName("org.postgresql.Driver");

            String url = System.getenv("TravelDB_URL");
            String username = System.getenv("TravelDB_Username");
            String password = System.getenv("TravelDB_Password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
