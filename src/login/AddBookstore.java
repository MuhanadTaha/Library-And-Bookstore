
package login;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class AddBookstore extends JFrame {
    

    public JFrame frame;
    public JButton button1,button2,button3;
    public JPanel panel;
    public JTextField t1,t2,t3,t4,t5;
    public JLabel label,label1,label2,label3,label4,label5,label11,label12,label13,label14,label15;
    public ImageIcon image;
    public Font f,f1;
    
    
    public AddBookstore(){
        setLayout(new FlowLayout());
        frame = new JFrame();   
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        
        button1 = new JButton("Send");
        button2 = new JButton("Exit");
        button3 = new JButton("Requests");
        
        image = new ImageIcon(getClass().getResource("hd2.jpg"));
        label = new JLabel(image);
        label1 = new JLabel("ID for Bookstore");
        label2 = new JLabel("Name of Bookstore");
        label3 = new JLabel("Name of city");
        label4 = new JLabel("Put the address");
        label5 = new JLabel("Types and number of required novels");
        
        label11 = new JLabel("ID for Bookstore");
        label12 = new JLabel("Name of Bookstore");
        label13 = new JLabel("Name of city");
        label14 = new JLabel("Put the address");
        label15 = new JLabel("Types and number of required novels");
        
        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,20);
        
        
        t1.setBounds(780, 240, 220, 50);
        t2.setBounds(780, 310, 220, 50);
        t3.setBounds(780, 380, 220, 50); 
        t4.setBounds(780, 450, 220, 50);
        t5.setBounds(780, 520, 220, 50);
        
        label1.setBounds(320, 240, 420, 50);
        label2.setBounds(320, 310, 420, 50);
        label3.setBounds(320, 380, 420, 50); 
        label4.setBounds(320, 450, 420, 50);
        label5.setBounds(320, 520, 420, 50);
        
        label11.setBounds(318, 238, 420, 50);
        label12.setBounds(318, 308, 420, 50);
        label13.setBounds(318, 378, 420, 50); 
        label14.setBounds(318, 448, 420, 50);
        label15.setBounds(318, 518, 420, 50);
        
        label1.setFont(f);
        label2.setFont(f);
        label3.setFont(f); 
        label4.setFont(f);
        label5.setFont(f);
        
        label11.setFont(f1);
        label12.setFont(f1);
        label13.setFont(f1); 
        label14.setFont(f1);
        label15.setFont(f1);
        
        label1.setForeground(Color.white);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        label5.setForeground(Color.WHITE);
        
        label11.setForeground(Color.red);
        label12.setForeground(Color.red);
        label13.setForeground(Color.red);
        label14.setForeground(Color.red);
        label15.setForeground(Color.red);
        
        button1.setBounds(380, 600, 120, 50);
        button2.setBounds(580, 600, 120, 50);
        button3.setBounds(780, 600, 120, 50);
        
        frame.add(button1);frame.add(button2);frame.add(button3);
        
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        
        
        
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        
        frame.add(label11);
        frame.add(label12);
        frame.add(label13);
        frame.add(label14);
        frame.add(label15);
        
        
        
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(1400,1000);
        frame.setLocation(-10, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
   
        
      button1.addActionListener(new ActionListener(){
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
try {
myStmt = myconn.createStatement();
} catch (SQLException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}

ResultSet myRs = null;

try {
myStmt = myconn.createStatement();
myStmt.executeUpdate("INSERT INTO bookstore (ID, NameOfBookstore, NameOfCity, Address, Requests)" + "VALUES('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "')");
} catch (SQLException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}


try {
myStmt.close();
} catch (SQLException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}

try {
myconn.close();
} catch (SQLException ex) {
Logger.getLogger(AddBookstore.class.getName()).log(Level.SEVERE, null, ex);
}

    }});  
      
      button2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
        frame.setVisible(false);
      }
    });  
      button3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        WatchaRequest wa = new WatchaRequest();
        frame.setVisible(false);
      }
    }); 
     
      
      
    }
    

    
}
