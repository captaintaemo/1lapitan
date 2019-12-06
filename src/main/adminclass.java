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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author user name
 */
public class adminclass {
    private Connector connections = new Connector();
    public int promote(int promote,int id){
        adminframe af = new adminframe();
        int x = 0;
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(connections.getCon());
        PreparedStatement p = c.prepareStatement("UPDATE`createacc` SET type = ? where id = ?");
        p.setInt(1, promote);
        p.setInt(2, id);
        x = p.executeUpdate();
            af.load();
 }      catch (ClassNotFoundException ex) {
            Logger.getLogger(adminframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
        
    }
}
