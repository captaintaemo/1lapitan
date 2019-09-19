/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Configurator.Connector;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user name
 */
public class AddProduct {
main_frame mf = new main_frame();
private Connector connection = new Connector();
    public void ap(String pn,int pq, double pr){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connection.getCon());
            String query = "insert into add_product(`p_name`,`p_quantity`,`p_price`) values"
                    + "(?,?,?) ";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, pn);
            p.setInt(2, pq);
            p.setDouble(3, pr);
            p.executeUpdate();
            JOptionPane.showMessageDialog(mf, "Saved","Successfull",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
        


