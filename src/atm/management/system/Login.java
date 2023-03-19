/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField cardno;
    JPasswordField pinno;
    JButton login1, signup1, Reset;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        Color mycolor1 = new Color(0,24,88);//DARK BLUE COLOUR
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img1 =  img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img2= new ImageIcon(img1); 
        JLabel label = new JLabel(img2);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("osward",Font.BOLD ,38));
        text.setBounds(200, 40, 400, 40);
        text.setForeground(mycolor1);
        add(text);
        
        JLabel cardtext = new JLabel("CARD");
        cardtext.setFont(new Font("osward",Font.BOLD,20));
        cardtext.setBounds(200, 150, 100, 20);
        add(cardtext);
        
        cardno = new JTextField();
        cardno.setBounds(300,150,200,25);
        add(cardno);
        
        
        JLabel PINtext = new JLabel("PIN");
        PINtext.setFont(new Font("osward",Font.BOLD,20));
        PINtext.setBounds(200, 200, 100, 20);
        add(PINtext);
        
        
        pinno = new JPasswordField();
        pinno.setBounds(300,200,200,25);
        add(pinno);
        
        login1 = new JButton("Login");
        login1.setForeground(Color.WHITE);
        login1.setBackground(mycolor1);
        login1.setBounds(300, 250, 200, 30);
        login1.addActionListener(this);
        add(login1);
        
        signup1 = new JButton("Signup");
        signup1.setForeground(Color.WHITE);
        signup1.setBackground(mycolor1);
        signup1.setBounds(300, 300, 80, 30);
        signup1.addActionListener(this);
        add(signup1);
        
        Reset = new JButton("Clear");
        Reset.setForeground(Color.WHITE);
        Reset.setBackground(mycolor1);
        Reset.setBounds(420, 300, 80, 30);
        Reset.addActionListener(this);
        add(Reset);
        
        Color mycolor = new Color(243,210,193);
        getContentPane().setBackground(mycolor);
        
     
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
        
             
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login1)
        {
            Conn c = new Conn();
            String cardnumber = cardno.getText();
            String pinnumber = pinno.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin");
                    cardno.setText(null); 
                    pinno.setText(null);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()== Reset)
        {
            cardno.setText(null); 
            pinno.setText(null);
        }
        else if(ae.getSource()== signup1)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        
    }
    
}
    
    public static void main(String[] args)
    {
        new Login();
    }
    
}
