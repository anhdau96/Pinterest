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
            Connection connect = connectDB.getConnectLink();
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM links WHERE check_pin = 0 LIMIT 200");
            ResultSet rs = pst.executeQuery();
            List<LinkPin> lstLink = new ArrayList<>();
            while(rs.next()){
                String img = null;
                String[] splits = rs.getString(3).split("\"");
                for (String split : splits) {
                    if (split.contains("http")) {
                        img = split;
                        break;
                    }
                }
                lstLink.add(new LinkPin(rs.getInt(1), rs.getString(4), img, rs.getString(5).concat(" "+ rs.getString(6)), rs.getByte(9)));
            }
            connectDB.closeConnectLink();
            return lstLink;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PinLinkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateLinkPin(int idlink){
        ConnectDB connectDB = new ConnectDB();
        try {
            Connection connect = connectDB.getConnectLink();
            PreparedStatement pst = connect.prepareStatement("UPDATE links SET check_pin = 1 WHERE id = ?");
            pst.setInt(1, idlink);
            pst.execute();
            connectDB.closeConnectLink();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
