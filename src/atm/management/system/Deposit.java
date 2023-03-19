/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
        
public class Deposit extends JFrame implements ActionListener
{
    JTextField amt;
    JButton Dep, back;
    String pinnumber;
    Deposit( String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        Color myColor = new Color(0,24,88);//Dark Blue CoLor
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        
        JLabel text = new JLabel("Enter the Deposit Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        //Deposit TextField
        amt = new JTextField();
        amt.setBounds(190,350,300,30);
        amt.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(amt);
        
        //Deposit Button
        Dep = new JButton(" Deposit ");
        Dep.setBounds(355, 415, 150, 30);
        Dep.setBackground(myColor);
        Dep.setForeground(Color.WHITE);
        Dep.setFont(new Font("Raleway", Font.BOLD,20));
        Dep.addActionListener(this);
        image.add(Dep);
        
        back = new JButton(" Back ");
        back.setBounds( 355, 450, 150, 30);
        back.setBackground(myColor);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== Dep)
        {
            String depositamt = amt.getText();
            Date date = new Date();
            if(depositamt.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter the valid Deposit Amount");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+depositamt+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+depositamt+" Deposited Successfully.");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
