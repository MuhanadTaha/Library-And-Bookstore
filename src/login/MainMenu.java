/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
        
public class MainMenu extends JFrame {
    

    public JFrame frame;
    public JButton button1,button2,button3;
    public JPanel panel;
    public JTextField tf,td;
    public JLabel label,label1;
    public ImageIcon image,image1,image2,image3;


    public Font f,f1;
    
    
    public MainMenu(){
        setLayout(new FlowLayout());
        frame = new JFrame();   
        tf = new JTextField();
        td = new JTextField(); 
        button1 = new JButton("  Buy Books           ");
        button2 = new JButton("  Page look            ");
        button3 = new JButton("Publishing a novales");

        panel = new JPanel();
        label = new JLabel("WELCOME");
        
        image = new ImageIcon(getClass().getResource("Bookshelves.jpg"));
        image1 = new ImageIcon(getClass().getResource("buy.png"));
        image2 = new ImageIcon(getClass().getResource("des.jpg"));
        image3 = new ImageIcon(getClass().getResource("pub.png"));
        
        button1.setIcon(image1);
        button2.setIcon(image2);
        button3.setIcon(image3);
        

        f = new Font("Lucida Calligraphy",Font.BOLD,100);
        f1 = new Font("Times New Roman",Font.BOLD,15);
        
        label1 = new JLabel(image); //main
        
        
        label.setFont(f);
        label.setForeground(Color.orange);
        label.setBackground(Color.yellow);
        
        button1.setFont(f1);
        button2.setFont(f1);
        button3.setFont(f1);

        
        button1.setBounds(580, 410, 220, 50);
        button2.setBounds(580, 480, 220, 50);
        button3.setBounds(580, 340, 220, 50);
       

        tf.setBounds(10, 10, 100, 40);
        label.setBounds(350, 20, 1100, 180);
        
       
        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(label1);
        frame.setVisible(true);
        frame.setSize(1400,1000);
        frame.setLocation(-10, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
      
      button1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        BuyBook Buy = new BuyBook();
        frame.setVisible(false);
      }
    });  
      
      
      button3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        Publish pub = new Publish();
        frame.setVisible(false);
      }
    });
      
      
      button2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        Choose ch = new Choose();
        frame.setVisible(false);
      }
    });
      
        
    }  
    
}