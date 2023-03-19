/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener
{  
    JButton deposit, withdrawn, fastcash, ministatement, pin, balanceEnquiry, exit;
    String pinnumber;
    Transaction(String pinnumber)
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
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(190, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,20));
        image.add(text);
        
        deposit = new JButton(" Deposit ");
        deposit.setBounds(190, 415, 135, 30);
        deposit.setBackground(myColor);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawn = new JButton(" Cash Withdraw ");
        withdrawn.setBounds(350,415,135,30);
        withdrawn.setBackground(myColor);
        withdrawn.setForeground(Color.WHITE);
        withdrawn.addActionListener(this);
        image.add(withdrawn);
        
        fastcash = new JButton(" Fast Cash ");
        fastcash.setBounds(190, 450, 135, 30);
        fastcash.setBackground(myColor);
        fastcash.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton(" Mini Statement ");
        ministatement.setBounds(350, 450, 135, 30);
        ministatement.setBackground(myColor);
        ministatement.setForeground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pin = new JButton(" PIN Change ");
        pin.setBounds(190,485, 135, 30);
        pin.setBackground(myColor);
        pin.setForeground(Color.WHITE);
        pin.addActionListener(this);
        image.add(pin);
        
        balanceEnquiry = new JButton(" Balance Enquiry ");
        balanceEnquiry.setBounds(350,485, 135, 30);
        balanceEnquiry.setBackground(myColor);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton(" EXIT ");
        exit.setBounds( 350,520, 135, 30);
        exit.setBackground(myColor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() ==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== withdrawn)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== ministatement)
        {
            //setVisible(false);
            new Mini(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== pin)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== balanceEnquiry)
        {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== exit)
        {
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new Transaction("");
    }
}
