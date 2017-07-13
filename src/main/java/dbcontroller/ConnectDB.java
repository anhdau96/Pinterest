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

    private Connection connectionLink;
    private Connection connectionAcc;

    public Connection getConnectLink() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connectionLink = DriverManager.getConnection("jdbc:mysql://45.32.16.93:3306/autopro", "root", "abc123");
        return connectionLink;
    }

    public void closeConnectLink() throws SQLException {
        if (connectionLink != null) {
            connectionLink.close();
        }
    }
    
    public Connection getConnectAcc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connectionAcc = DriverManager.getConnection("jdbc:mysql://45.76.101.61:5689/pinterest", "root", "moridaej1koongeeg5xaenuePaeh9wae");
        return connectionAcc;
    }

    public void closeConnectAcc() throws SQLException {
        if (connectionAcc != null) {
            connectionAcc.close();
        }
    }
//
//    public static void main(String[] args) {
//        try {
//            ConnectDB connectDB = new ConnectDB();
//            Connection connect = connectDB.getConnect();
//            if (connect != null) {
//                System.out.println("Success");
//            } else {
//                System.out.println("Fail");
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
