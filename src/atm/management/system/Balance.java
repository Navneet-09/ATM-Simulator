/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener
{
    JButton back;
    String pinnumber;
    Balance(String pinnumber)
    {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        Color myColor = new Color(0,24,88);//Dark Blue CoLor
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        Conn c = new Conn();
        int balance = 0;
        try
        {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                        
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Balance Enquiry");
        text.setBounds(255, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        JLabel show = new JLabel("Your current A/c balance is Rs. " +balance);
        show.setForeground(Color.WHITE);
        show.setFont(new Font("Raleway", Font.BOLD, 17));
        show.setBounds(180, 340, 400, 30);
        image.add(show);
        
        JLabel thank = new JLabel(" Thankyou. ");
        thank.setForeground(Color.WHITE);
        thank.setFont(new Font("Raleway", Font.BOLD, 18));
        thank.setBounds(275, 380, 400, 30);
        image.add(thank);
        
        
        back = new JButton(" Back ");
        back.setBounds( 350,520, 135, 30);
        back.setBackground(myColor);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Balance("").setVisible(true);
    }
    
}
