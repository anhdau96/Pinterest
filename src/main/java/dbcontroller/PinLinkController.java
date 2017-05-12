/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;

import model.LinkPin;
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
public class PinLinkController {
    public List<LinkPin> getLinkPin(){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnect();
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM pin_link WHERE check_pin = 0 LIMIT 100");
            ResultSet rs = pst.executeQuery();
            List<LinkPin> lstLink = new ArrayList<>();
            while(rs.next()){
                lstLink.add(new LinkPin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getByte(5), rs.getInt(6)));
            }
            connectDB.closeConnect();
            return lstLink;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PinLinkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateLinkPin(int idlink, int idAcc){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnect();
            PreparedStatement pst = connect.prepareStatement("UPDATE pin_link SET check_pin = 1, users_id = ? WHERE id = ?");
            pst.setInt(1, idAcc);
            pst.setInt(2, idlink);
            pst.execute();
            connectDB.closeConnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
