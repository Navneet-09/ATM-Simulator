/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class PinChange extends JFrame  implements ActionListener
{
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber)
    {       
        this.pinnumber = pinnumber;
        setLayout(null);
        
        Color myColor = new Color(0,24,88);//Dark Blue CoLor
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(250, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        // NEW pin
        JLabel ptext = new JLabel("New PIN");
        ptext.setBounds(190, 330, 135, 30);
        ptext.setForeground(Color.WHITE);
        ptext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(ptext);
        
        
        pin = new JPasswordField();
        pin.setBounds(330, 330, 175, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pin);
        
        
        // Reenter pin
        
        JLabel rtext = new JLabel("Re-Enter PIN");
        rtext.setBounds(190,360, 135, 30);
        rtext.setForeground(Color.WHITE);
        rtext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(rtext);
        
        repin = new JPasswordField();
        repin.setBounds(330, 360, 175, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repin);
        
        change = new JButton(" Change ");
        change.setBackground(myColor);
        change.setForeground(Color.WHITE);
        change.setBounds(355, 415, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton(" Back ");
        back.setBackground(myColor);
        back.setForeground(Color.WHITE);
        back.setBounds(355, 450, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {      
        if(ae.getSource()==change)
        {
            try
            {
                String newp = pin.getText();
                String rpin = repin.getText();
                if(!newp.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match!!");
                    return;
                }
                if(newp.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if(repin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                }
                
                Conn c = new Conn();
                String query1= "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2= "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3= "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully.");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else 
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
