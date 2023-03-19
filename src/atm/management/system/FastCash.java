/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton a1, a2, a3, a4, a5, a6, exit;
    String pinnumber;
    FastCash(String pinnumber)
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
        
        JLabel text = new JLabel("Please select Withdrawl Amount");
        text.setBounds(190, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        a1 = new JButton(" Rs.100 ");
        a1.setBounds(190, 415, 135, 30);
        a1.setBackground(myColor);
        a1.setForeground(Color.WHITE);
        a1.addActionListener(this);
        image.add(a1);
        
        a2 = new JButton(" Rs.500 ");
        a2.setBounds(350,415,135,30);
        a2.setBackground(myColor);
        a2.setForeground(Color.WHITE);
        a2.addActionListener(this);
        image.add(a2);
        
        a3 = new JButton(" Rs.1000 ");
        a3.setBounds(190, 450, 135, 30);
        a3.setBackground(myColor);
        a3.setForeground(Color.WHITE);
        a3.addActionListener(this);
        image.add(a3);
        
        a4 = new JButton(" Rs.2000 ");
        a4.setBounds(350, 450, 135, 30);
        a4.setBackground(myColor);
        a4.setForeground(Color.WHITE);
        a4.addActionListener(this);
        image.add(a4);
        
        a5 = new JButton(" Rs.5000 ");
        a5.setBounds(190,485, 135, 30);
        a5.setBackground(myColor);
        a5.setForeground(Color.WHITE);
        a5.addActionListener(this);
        image.add(a5);
        
        a6 = new JButton(" Rs.10,000 ");
        a6.setBounds(350,485, 135, 30);
        a6.setBackground(myColor);
        a6.setForeground(Color.WHITE);
        a6.addActionListener(this);
        image.add(a6);
        
        exit = new JButton(" Back ");
        exit.setBounds( 350,520, 135, 30);
        exit.setBackground(myColor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exit)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else
        {
            int amt=0;
            if(ae.getSource()== a1)
            {
                amt=100;
            }
            else if(ae.getSource()== a2)
            {
                amt=500;
            }
            else if(ae.getSource()== a3)
            {
                amt=1000;
            }
            else if(ae.getSource()== a4)
            {
                amt=2000;
            }
            else if(ae.getSource()== a5)
            {
                amt=5000;
            }
            else if(ae.getSource()== a6)
            {
                amt=10000;
            }
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
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
                
                //int a = Integer.parseInt(amt);
                if((ae.getSource() != exit) && (balance < amt))
                {
                    JOptionPane.showMessageDialog(null," Insufficient Balance!!");
                    return;
                }
                
                Date date = new Date();
                String query ="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl' ,'"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+ amt +" has been Debited Successfully.");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);               
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
 
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
    
}
