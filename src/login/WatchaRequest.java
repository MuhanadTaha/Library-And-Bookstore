
package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

        
public class WatchaRequest extends JFrame {
    


    public JButton button,bk;
    public JTextField epass;
    public JLabel label;
    public ImageIcon image;
    public Font f;
    
    
    public WatchaRequest(){
        JFrame frame = new JFrame("TextArea Load");
        final JTextArea edit = new JTextArea();
        final JTextArea edit1 = new JTextArea();
        final JTextArea edit2 = new JTextArea();
        final JTextArea edit3 = new JTextArea();

        JButton read = new JButton("Users");
        JButton write = new JButton("User modification");
        JButton write1 = new JButton("Buy modification");
        JButton write2 = new JButton("Design modification");
        JButton write3 = new JButton("Bookstore modification");
        
        JButton read1 = new JButton("Buy Book");
        JButton read2 = new JButton("Bookstore");
        JButton read3 = new JButton("Design");
        
        JLabel la = new JLabel("Edit Pass");
        
         f = new Font("Lucida Calligraphy",Font.BOLD,20);
         la.setFont(f);
         la.setForeground(Color.white);
         image = new ImageIcon(getClass().getResource("hd.jpg"));
         label = new JLabel(image);
         epass = new JTextField();
         button = new JButton("Save");
         bk = new JButton("Back");

        
        
        edit.setBounds(100,140,240,240);
        edit1.setBounds(410,140,240,240);
        edit2.setBounds(720,140,240,240);
        edit3.setBounds(1030,140,240,240);
        
        read.setBounds(110, 410, 220, 50);
        read1.setBounds(420, 410, 220, 50);
        read2.setBounds(730, 410, 220, 50);
        read3.setBounds(1040, 410, 220, 50);
        
        write.setBounds(110, 510, 220, 50);
        write1.setBounds(420, 510, 220, 50);
        write2.setBounds(730, 510, 220, 50);
        write3.setBounds(1040, 510, 220, 50);
        
        epass.setBounds(65,640,180,35);
        la.setBounds(85,600,180,35);
        
        button.setBounds(280,640,100,35);
        bk.setBounds(45,60,100,35);
        
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "userPass.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        
        read1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "Buy.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit1.read( br, null );
                    br.close();
                    edit1.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        
        read2.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "Bookstore.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit2.read( br, null );
                    br.close();
                    edit2.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        
        read3.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "design.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit3.read( br, null );
                    br.close();
                    edit3.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });

        
        
        
        write.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "userPass.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit.write( bw );
                    bw.close();
                    edit.setText("");
                    edit.requestFocus();
                }
                catch(Exception e2) {}
            }
        });
        
        
        write1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "Buy.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit1.write( bw );
                    bw.close();
                    edit1.setText("");
                    edit1.requestFocus();
                }
                catch(Exception e2) {}
            }
        });
        
        write2.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "Bookstore.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit2.write( bw );
                    bw.close();
                    edit2.setText("");
                    edit2.requestFocus();
                }
                catch(Exception e2) {}
            }
        });
        
        write3.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "design.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit3.write( bw );
                    bw.close();
                    edit3.setText("");
                    edit3.requestFocus();
                }
                catch(Exception e2) {}
            }
        });
        
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "adminPass.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    epass.write( bw );
                    bw.close();
                    epass.setText("");
                    epass.requestFocus();
                }
                catch(Exception e2) {}
            }
        });
        
        bk.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                AddBookstore ad = new AddBookstore();
                frame.setVisible(false);
   
            }
            
        });
        

        frame.add(bk);
        frame.add(button);
        frame.add(epass);
        frame.add(la);
        frame.add(write);
        frame.add(write1);
        frame.add(write2);
        frame.add(write3);
        frame.add(read);
        frame.add(read1);
        frame.add(read2);
        frame.add(read3);
        frame.add(edit);
        frame.add(edit1);
        frame.add(edit2);
        frame.add(edit3);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1400,1000);
        frame.setLocation(-10, 0);
        
        
    }
     
    

    
}
