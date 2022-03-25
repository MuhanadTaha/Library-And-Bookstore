package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
  JButton blogin,back,ad;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUSer;
  JLabel username;
  JLabel password;
  ImageIcon image;
  JLabel label1;
  JFrame f;

  

  public Login(){
    super("Login Autentification");

    blogin = new JButton("Login");
    
    

  
    
    ad = new JButton("Admin");
    
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    newUSer = new JButton("New User?");
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");
   
    image = new ImageIcon(getClass().getResource("Bookshelves.jpg"));
     label1 = new JLabel(image);

    setSize(300,600);
    setLocation(500,80);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,208,150,20);
    pass.setBounds(70,243,150,20);
    blogin.setBounds(95,300,100,20);
    newUSer.setBounds(95,335,100,20);
    
  
    
    ad.setBounds(95,370,100,20);

     
    username.setBounds(20,208,80,20);
    password.setBounds(20,243,80,20);
    
    

    loginpanel.add(label1);
    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(newUSer);

    
    loginpanel.add(ad);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  


    blogin.addActionListener(new ActionListener() {
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
          myRs = myStmt.executeQuery("select * from app_Users");
                      
          String usertxt = " ";
          String passtxt = " ";
          String puname = txuser.getText();
          String ppaswd = pass.getText();
          
         
           
           while (myRs.next()) {
              usertxt = myRs.getString("USER_NAME");
              passtxt = myRs.getString("password");
}
           if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
            MainMenu menu =new MainMenu();
            dispose(); // لما بتنتقل على صفحة المنيو بسكر الصفحة اللي بعدها
          } 
          else if(puname.equals("") && ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            txuser.setText("");
            pass.setText("");
            txuser.requestFocus();
          }

              
       
          
          } catch (SQLException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }




      }
    });

    newUSer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        NewUser user = new NewUser();
        dispose();

      }
    });
    
   
    
   
    
    ad.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        Admin ad = new Admin();
        dispose();

      }
    });
    
  } 

  

    public static void main(String[] args) {
        new login.Login();
        
    }
    
}
