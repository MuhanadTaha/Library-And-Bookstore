
package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Admin {
    JFrame fr = new JFrame("Admin");
    JPasswordField tx = new JPasswordField();
    JLabel lb = new JLabel("Enter password please");
    JButton ad = new JButton("Enter");
    JButton bk = new JButton("Back");
    
    
    public Admin(){
        
        fr.setLayout (null); 
        
        lb.setBounds(60,50,300,30);
        tx.setBounds(60,80,300,30);
        ad.setBounds(210,120,80,30);
        bk.setBounds(120,120,80,30);
        
        fr.add(lb);
        fr.add(tx);
        fr.add(ad);
        fr.add(bk);
        fr.setVisible(true);      
        fr.setSize(430,240);
        fr.setLocation(450, 250);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ad.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
               
              Connection myconn = null;

          try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}


try {
myconn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "Muhannad", "Mt@28628071");
} catch (SQLException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}
          
          java.sql.Statement myStmt = null;
java.sql.ResultSet myRs = null;

try {
myStmt = myconn.createStatement();


} catch (SQLException ex) {
Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
}

          try {
          myRs = myStmt.executeQuery("select * from adminpass");
                      
          String usertxt = " ";
          String puname = tx.getText();
          
         
           
           while (myRs.next()) {
              usertxt = myRs.getString("pass");
}
           if(puname.equals(usertxt)) {
            AddBookstore add =new AddBookstore();
          } 
          else if(puname.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            
          }

              
       
          
          } catch (SQLException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }


          
          }
    });
        
      bk.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
                Login  buy = new Login();
                fr.setVisible(false);

      }
    });
        
        
        
        
    }
}

