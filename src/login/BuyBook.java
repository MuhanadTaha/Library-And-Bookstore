
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

public class BuyBook extends JFrame{
 
 public JPanel panel1;   
 public JFrame f; 
 public ImageIcon image,image2,image3,image4,image5,image6,image7;
 public JLabel lable,lable2,lable3,lable4,lable5,lable6,lable7,lablef1,lablef2,lablef3;
 public JCheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6; 
 public JRadioButton r1,r2,r3;
 public JButton back,calculat,reset,exit,send;
 public JTextField sub,tax,total;
 public Font f1;
 
 int n =1;
 
BuyBook(){   
setLayout(new FlowLayout());
f=new JFrame();
back = new JButton("Back");
calculat = new JButton("Calculate");
reset = new JButton("Reset");
exit = new JButton("Exit");
send = new JButton("Send");

lablef1 = new JLabel("Subtotal");
lablef2 = new JLabel("Tax");
lablef3 = new JLabel("Total");

image = new ImageIcon(getClass().getResource("Black.jpg"));
image2 = new ImageIcon(getClass().getResource("saddle-the-wind.jpg"));
image3 = new ImageIcon(getClass().getResource("my-brilliant-friend.jpg"));
image4 = new ImageIcon(getClass().getResource("salat.jpg"));
image5 = new ImageIcon(getClass().getResource("thorn.jpg"));
image6 = new ImageIcon(getClass().getResource("india.jpg"));
image7 = new ImageIcon(getClass().getResource("islamic.JPG"));


sub = new JTextField();
tax = new JTextField();
total = new JTextField();

f1 = new Font("Lucida Calligraphy",Font.BOLD,20);

lable = new JLabel(image);
lable2 = new JLabel(image2);
lable3 = new JLabel(image3);
lable4 = new JLabel(image4);
lable5 = new JLabel(image5);
lable6 = new JLabel(image6);
lable7 = new JLabel(image7);

lablef1.setFont(f1);
lablef1.setForeground(Color.orange);
lablef1.setBackground(Color.yellow);

lablef2.setFont(f1);
lablef2.setForeground(Color.orange);
lablef2.setBackground(Color.yellow);

lablef3.setFont(f1);
lablef3.setForeground(Color.orange);
lablef3.setBackground(Color.yellow);


lable2.setBounds(350, 150, 200, 300);
lable2.setLocation(340,50);
lable3.setBounds(350, 150, 200, 300);
lable3.setLocation(640,50);
lable4.setBounds(350, 150, 200, 300);
lable4.setLocation(940,50);
lable5.setBounds(350, 150, 200, 300);
lable5.setLocation(340,370);
lable6.setBounds(350, 150, 200, 300);
lable6.setLocation(640,370);
lable7.setBounds(350, 150, 200, 300);
lable7.setLocation(940,370);


checkBox1 = new JCheckBox("Saddle 1$"); 
checkBox2 = new JCheckBox("Brilliant"); 
checkBox3 = new JCheckBox("Salat"); 
checkBox4 = new JCheckBox("Thron");
checkBox5 = new JCheckBox("E. india");
checkBox6 = new JCheckBox("Islamic");

r1=new JRadioButton("romantic (R) ");    
r2=new JRadioButton("Religious (G)"); 
r3=new JRadioButton("Historical (B)");   


r1.setBounds(50,120,100,30);    
r2.setBounds(50,170,100,30); 
r3.setBounds(50,220,100,30);


f.add(r1);f.add(r2); f.add(r3);

back.setBounds(30,40,100,30);
calculat.setBounds(130,450,100,30);
reset.setBounds(130,350,100,30);
exit.setBounds(130,400,100,30);
send.setBounds(1230,400,100,30);

checkBox1.setBounds(400,300, 75,50);          
checkBox2.setBounds(700,300, 75,50); 
checkBox3.setBounds(1000,300, 75,50); 
checkBox4.setBounds(400,600, 75,50); 
checkBox5.setBounds(700,600, 75,50); 
checkBox6.setBounds(1000,600, 75,50); 

sub.setBounds(180,550,100,30);
tax.setBounds(180,600,100,30);
total.setBounds(180,650,100,30);

lablef1.setBounds(50, 470, 1100, 180);
lablef2.setBounds(50, 520, 1100, 180);
lablef3.setBounds(50, 570, 1100, 180);


f.add(lablef1);
f.add(lablef2);
f.add(lablef3);
f.add(checkBox1);  
f.add(checkBox2);
f.add(checkBox3);
f.add(checkBox4);  
f.add(checkBox5);
f.add(checkBox6);

f.add(back);
f.add(calculat);
f.add(reset);
f.add(exit);
f.add(send);

f.add(lable2);
f.add(lable3);
f.add(lable4);
f.add(lable5);
f.add(lable6);
f.add(lable7);
f.add(sub);f.add(tax); f.add(total);

f.add(lable);

f.setSize(1400,1000); 
f.setLocation(-10, 0);
   
f.setVisible(true); 
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        MainMenu main = new MainMenu();
        f.setVisible(false);

      }
    });

exit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        
        System.exit(0);

      }
    });



send.addActionListener(new ActionListener() {
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
int n = 3;
if(checkBox1.isSelected()){
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price)" + "VALUES('" + checkBox3.getText() + "','"+ checkBox1.getText() + "','" + r3.getText()+ "','"+ "man"+ "','" + n + "')");

}
if(checkBox2.isSelected()){
    int m = 5;
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price)" + "VALUES('" + 45345 + "','" + r1.getText()+ "','"+ "man"+ "','" + m + "')");

}
if(checkBox3.isSelected()){
    int o = 4;
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price)" + "VALUES('" + 93830 + "','"+ checkBox3.getText() + "','" + r2.getText()+ "','"+ "man"+"','" + o + "')");

}
if(checkBox4.isSelected()){
    int a = 6;
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price)" + "VALUES('"+ 22222 + "','" + checkBox4.getText() + "','" + r3.getText()+ "','"+ "man"+"','" + a + "')");

}

if(checkBox5.isSelected()){
    int b = 3;
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price)" + "VALUES('" + 23456 + "','"+ checkBox5.getText() + "','" + r3.getText()+ "','"+ "man"+"','" + b + "')");

}

if(checkBox6.isSelected()){
    int d = 5;
myStmt.executeUpdate("INSERT INTO (Book_ISBN, BName ,Category, User_ID , price))" + "VALUES('" + 11211 + "','"+ checkBox6.getText() + "','" + r3.getText()+ "','"+ "man"+"','" + d + "')");

}
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



reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox5.setSelected(false);
        checkBox6.setSelected(false);
        
        checkBox1.setBackground(Color.white); checkBox2.setBackground(Color.white); 
        checkBox3.setBackground(Color.white); checkBox4.setBackground(Color.white); 
        checkBox5.setBackground(Color.white); checkBox6.setBackground(Color.white); 
        
        sub.setText(" ");
        tax.setText(" ");
        total.setText(" ");
      }
    });


r1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        r2.setSelected(false);
        r3.setSelected(false); 
        checkBox2.setBackground(Color.red);
        checkBox2.setOpaque(true);
      }
    });
r2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        r1.setSelected(false);
        r3.setSelected(false);
       checkBox3.setBackground(Color.green);
       checkBox3.setOpaque(true);
       checkBox6.setBackground(Color.green);
       checkBox6.setOpaque(true);
      }
    });
r3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        r2.setSelected(false);
        r1.setSelected(false); 
        checkBox4.setBackground(Color.blue);
        checkBox4.setOpaque(true);
        checkBox5.setBackground(Color.blue);
        checkBox5.setOpaque(true);
        checkBox1.setBackground(Color.blue);
        checkBox1.setOpaque(true);
        
      }
    });

calculat.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        double ttotal=0;
        double taxrate = 0.05;
        double ttax;
        double subtotal;
        if (checkBox1.isSelected()){
            ttotal = ttotal +3;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
            
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText());
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
            
            
        }
        if (checkBox2.isSelected()){
            ttotal = ttotal +5;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
             
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText());  
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
        }
        if (checkBox3.isSelected()){  
            ttotal = ttotal +4;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
            
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText()); 
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
        }
        if (checkBox4.isSelected()){            
            ttotal = ttotal +6;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
            
            
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText());  
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
        } 
        if (checkBox5.isSelected()){ 
            ttotal = ttotal +3;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
            
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText());  
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
        }
        if (checkBox6.isSelected()){   
            ttotal = ttotal +10;
            ttax = taxrate*ttotal;
            subtotal = ttotal - ttax;
            
            total.setText(Double.toString(ttotal));
            ttotal = Double.parseDouble(total.getText()); 
            
            tax.setText(Double.toString(ttax));
            ttax = Double.parseDouble(tax.getText());
            
            sub.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(sub.getText());
        }   
        
      }
    });


  } 
}





