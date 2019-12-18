/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.*;
import Configurator.Connector;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user name
 */
public class notificon {
    private Connector conn = new Connector();
   public void checkquant(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(conn.getCon());
           String sql = "Select * from add_product";
           String sql2 = "Update add_product set `type` = ? where p_id = ?";
           PreparedStatement pstmt = con.prepareStatement(sql);
           PreparedStatement pstmts = con.prepareStatement(sql2);
           ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                int qty = rs.getInt("quantity");
                int status = rs.getInt("status");
                String product = rs.getString("product_name");
                String id = rs.getString("id");
                
                if(qty < 5 && status != 1){
                    pstmts.setInt(1, 0);
                    pstmts.setString(2, id);
                    pstmts.executeUpdate();
                    DisplayNotify(product);
                }else if(qty >= 5 && status == 1){
                    pstmts.setInt(1, 0);
                    pstmts.setString(2, id);
                    pstmts.executeUpdate();
                }
                
                
            }
       } catch (ClassNotFoundException | SQLException | AWTException ex) {
           Logger.getLogger(notificon.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    void DisplayNotify(String product) throws AWTException{
           
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("img/warning.png");
        
        TrayIcon trayIcon = new TrayIcon(image,"");
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);
        trayIcon.displayMessage("LOW QUANTITY", product+" product low on quantity", TrayIcon.MessageType.WARNING);
    
    }
}
