/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener
{
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6,c7;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
        Color mycolor1 = new Color(243,210,193); // background color
        Color mycolor2 = new Color(0,24,88);//DARK BLUE COLOUR
              
        JLabel L1 = new JLabel("Page 3: Account Details");
        L1.setFont(new Font("Raleway",Font.BOLD,22));
        L1.setBounds(280, 40, 400, 40);
        add(L1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,20));
        r1.setBounds(100,180,250,20);
        r1.setBackground(mycolor1);
        add(r1);
        
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,20));
        r2.setBounds(350,180,250,20);
        r2.setBackground(mycolor1);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,20));
        r3.setBounds(100,220,250,20);
        r3.setBackground(mycolor1);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,20));
        r4.setBounds(350,220,350,20);
        r4.setBackground(mycolor1);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-6699");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 310, 300, 20);
        add(number);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,20);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(350,370,300,20);
        add(pnumber);
        
        JLabel service = new JLabel("Services Required : ");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100,450,400,30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(mycolor1);
        c1.setFont(new Font("Raleway", Font.BOLD, 20));
        c1.setBounds(100,500,200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(mycolor1);
        c2.setFont(new Font("Raleway", Font.BOLD, 20));
        c2.setBounds(350,500,250, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(mycolor1);
        c3.setFont(new Font("Raleway", Font.BOLD, 20));
        c3.setBounds(100,550,200, 30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(mycolor1);
        c4.setFont(new Font("Raleway", Font.BOLD, 20));
        c4.setBounds(350,550,300, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(mycolor1);
        c5.setFont(new Font("Raleway", Font.BOLD, 22));
        c5.setBounds(100,600,200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(mycolor1);
        c6.setFont(new Font("Raleway", Font.BOLD, 20));
        c6.setBounds(350,600,200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct.");
        c7.setBackground(mycolor1);
        c7.setFont(new Font("Raleway", Font.BOLD, 20));
        c7.setBounds(100,680,600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(mycolor2);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,730,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(mycolor2);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,730,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        Color mycolor = new Color(243,210,193); 
        getContentPane().setBackground(mycolor);
        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit)
        {
            String accountType = null;
            if(r1.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(r2.isSelected())
            {
                accountType ="Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                accountType ="Current Account";
            }
            else if(r4.isSelected())
            {
                accountType ="Recurring Deposit Account";
            }
            Random random  = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() %9000L) + 1000L);
            String facility = "";
            if(c1.isSelected())
            {
                facility = facility + " ATM CARD ";
            }
            else if(c2.isSelected())
            {
                facility = facility + " Internet Banking ";
            }
            else if(c3.isSelected())
            {
                facility = facility + " Mobile Banking ";
            }
            else if(c4.isSelected())
            {
                facility = facility + " EMAIL & SMS ALERT ";
            }
            else if(c5.isSelected())
            {
                facility = facility + " Cheque Book ";
            }
            else if(c6.isSelected())
            {
                facility = facility + " E-Statement ";
            }
            
            
            try
            {
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }
                else if(facility.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please select the services required");
                }
                else
                {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, " Card Number: " + cardnumber + "\n" + " PIN: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                    
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new SignupThree("");
    }
    
}
