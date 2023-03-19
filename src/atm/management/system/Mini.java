/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Mini extends JFrame 
{
    String pinnumber;
    Mini(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel statement = new JLabel();
        statement.setBounds(20, 140, 400, 200);
        add(statement);
        
        JLabel name = new JLabel("State Bank of India");
        name.setBounds(120, 20, 150, 20);       
        add(name);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 320, 20);
        add(bal);
        
        
        try{
            Conn c = new Conn();
            
            ResultSet rs =c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        try
        {
            Conn c = new Conn();
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                // Print transaction Statement
                statement.setText(statement.getText()+"<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>" );
                
                // For checking Current Balance
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                        
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                
                bal.setText("Your current balance account is Rs. " +balance);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Mini("").setVisible(true);
    }
    
}
