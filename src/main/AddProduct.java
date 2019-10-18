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


/**
 *
 * @author user name
 */
public class AddProduct {
main_frame mf = new main_frame();
private Connector connection = new Connector();
    public int ap(String pn,int pq, double pr){
        
        int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connection.getCon());
            String query = "insert into add_product(`p_name`,`p_quantity`,`p_price`) values"
                    + "(?,?,?) ";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, pn);
            p.setInt(2, pq);
            p.setDouble(3, pr);
           x= p.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

   public void dproduct(String id){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection c = DriverManager.getConnection(connection.getCon());
           String q ="Delete from add_product where p_id = ?";
           PreparedStatement p = c.prepareStatement(q);
           p.setString(1, id);
           p.executeUpdate();
           JOptionPane.showMessageDialog(mf, "Successfully Deleted","Successfull",JOptionPane.INFORMATION_MESSAGE);
       } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
    public void upproduct(String id ,String name,int quantity, double price){
        
    }
public int UpdateProduct(String id, String name,int quantity, double price){
    int u =0;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(connection.getCon());
        PreparedStatement p = c.prepareStatement("UPDATE`add_product` SET `p_name`=?, "
                + "`p_quantity`=?, `p_price`=? WHERE  `p_id`=?; ");
       p.setString(1,name);
       p.setInt(2, quantity);
       p.setDouble(3, price);
       p.setString(4,id);
       u = p.executeUpdate();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
    return u;
}

}
        


