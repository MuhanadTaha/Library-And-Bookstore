/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class NewUser extends JFrame {
  JButton create,back;
  JPanel newUserPanel;
  public static JTextField txuserer,author_i,genderr;
  JTextField passer;
  JLabel auth,user,pass,gend;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);
    author_i = new JTextField(15);
    genderr = new JTextField(15);
    back = new JButton("Back");
    auth = new JLabel("ID");
    user = new JLabel("User-");
    pass = new JLabel("Pass-");
    gend = new JLabel("Gender");


    setSize(300,600);
    setLocation(500,80);
    newUserPanel.setLayout (null); 


    txuserer.setBounds(70,208,150,20);
    user.setBounds(20,208,150,20);


    
    author_i.setBounds(70,173,150,20);
    auth.setBounds(20,173,150,20);

    genderr.setBounds(70,278,150,20);
    gend.setBounds(20,278,150,20);


    passer.setBounds(70,243,150,20);
    pass.setBounds(20,243,150,20);

    create.setBounds(95,320,100,20);
    back.setBounds(95,435,100,20);

    newUserPanel.add(create);
    newUserPanel.add(back);
    newUserPanel.add(txuserer);
    newUserPanel.add(user);
    newUserPanel.add(author_i);
    newUserPanel.add(auth);
    newUserPanel.add(genderr);
    newUserPanel.add(gend);
    newUserPanel.add(passer);
    newUserPanel.add(pass);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);


    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
             Connection myconn = null;

           try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException ex) {
Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
}


try {
myconn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "Muhannad", "Mt@28628071");
} catch (SQLException ex) {
Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
}

java.sql.Statement myStmt = null;
java.sql.ResultSet myRs = null;

try {
myStmt = myconn.createStatement();


} catch (SQLException ex) {
Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
}

          try {

                      
          String usertxter = " ";
          String passtxter = " ";
          String punamer = txuserer.getText();
          String ppaswder = passer.getText();
          
          myRs = myStmt.executeQuery("select * from app_Users");

         
           
           while (myRs.next()) {
              usertxter = myRs.getString("USER_NAME");
              passtxter = myRs.getString("password");
}
           if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocus(); //باستخدمها عشان يرجعني على اليوزر اكتب فيه من جديد

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        myRs = myStmt.executeQuery("INSERT INTO app_Users(User_ID,User_Name, password, gender)" + "VALUES ('" + author_i.getText() + "','" + punamer + "','" + ppaswder + "','" + genderr.getText() + "')");

        JOptionPane.showMessageDialog(null,"Account has been created.");
        dispose();
        Login log = new Login();


        }

          
          } catch (SQLException ex) {
              Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
          }

      }
    });
  
    
    back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
                Login  buy = new Login();
        dispose();

      }
    });
    
    
    
    
    
  } 

}