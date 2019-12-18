/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Configurator.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user name
 */
public class posfunc {
    Connector con = new Connector();
    public void getproduct(String id, JTable table){
           try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.getCon());

            String sql = "SELECT * FROM add_products WHERE p_id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1,id);
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            while (rs.next()) {
                int qty = 1;
                float subTotal = qty * rs.getFloat("price");
                model.addRow(new Object[]{rs.getString("id"),  qty, rs.getString("product_name"), rs.getString("price"), subTotal});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(posfunc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(posfunc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
