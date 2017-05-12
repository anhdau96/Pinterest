/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaiBack
 */
public class ConnectDB {

    private Connection connection;

    public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://45.76.101.61:5689/pinterest", "root", "moridaej1koongeeg5xaenuePaeh9wae");
        return connection;
    }

    public void closeConnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
