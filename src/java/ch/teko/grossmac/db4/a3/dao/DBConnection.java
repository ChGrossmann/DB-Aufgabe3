package ch.teko.grossmac.db4.a3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connect() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/artikelliste", "postgres", "");
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("PG Driver not found.");
            e.getMessage();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output of console.");
            e.getMessage();
        }

        if (connection != null) {
            System.out.println("Connection made to DB.");
        }

        return connection;
    }

}
