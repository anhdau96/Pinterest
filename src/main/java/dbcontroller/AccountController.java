/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;

import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaiBack
 */
public class AccountController {
    public void create (Account account){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnect();
            PreparedStatement pst = connect.prepareStatement("INSERT INTO users(userName, pass, token, lastpin, nexttime) VALUES (?,?,?,?,?)");
            pst.setString(1, account.getUser());
            pst.setString(2, account.getPass());
            pst.setString(3, account.getToken());
            pst.setString(4, account.getLastPin());
            pst.setString(5, account.getNextTime());
            pst.execute();
            connectDB.closeConnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Account> getAllAccount(){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnect();
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM users");
            ResultSet rs = pst.executeQuery();
            List<Account> lstAcc = new ArrayList<>();
            while(rs.next()){
                lstAcc.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            connectDB.closeConnect();
            return lstAcc;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateNextPin(int idAcc, String lastPin, String nextPin){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnect();
            PreparedStatement pst = connect.prepareStatement("UPDATE users SET lastpin = ?, nexttime = ? WHERE id = ?");
            pst.setString(1, lastPin);
            pst.setString(2, nextPin);
            pst.setInt(3, idAcc);
            pst.execute();
            connectDB.closeConnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
