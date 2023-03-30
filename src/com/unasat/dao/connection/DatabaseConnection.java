package com.unasat.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Asrock12345";
    private static final String URL = "jdbc:mysql://localhost/kookschool";


    public static Connection connectToDB() throws SQLException {
        Connection connection =  null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connection is Stable and Active");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }/*finally {
            if(connection != null){
                connection.close();
            }
        }*/

        return connection;
    }
}
