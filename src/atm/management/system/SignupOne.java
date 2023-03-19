/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
//implements ActionListener
public class SignupOne extends JFrame implements ActionListener{
    
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, cityTextField;
    JTextField pincodeTextField;
    JDateChooser dobDateChooser;
    JRadioButton male, female, married, unmarried, Other;
    JButton next;
    Long n;
    
    
    SignupOne()
    {
        setTitle("Signup Form");
        setLayout(null);
        Color mycolor1 = new Color(243,210,193);
        Color mycolor2 = new Color(0,24,88);//DARK BLUE COLOUR
        
        Random r = new Random();
        n = Math.abs((r.nextLong() % 9000L) + 1000L);
        
        
        JLabel form = new JLabel("Application Form No. "+ n);
        form.setFont(new Font("Raleway",Font.BOLD,40));
        form.setBounds(140,20,600,40);
        add(form);
        
        JLabel PersonalDetails = new JLabel("Personal Details");
        PersonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        PersonalDetails.setBounds(285,80,400,30);
        add(PersonalDetails);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.PLAIN,15));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.PLAIN,15));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("D.O.B.");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dobDateChooser = new JDateChooser();
        dobDateChooser.setBounds(300,240,400,30);
        dobDateChooser.setForeground(Color.BLACK);
        add(dobDateChooser);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(mycolor1);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(mycolor1);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("E-mail");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.PLAIN,15));
        emailTextField.setBounds(300, 340, 400, 20);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(mycolor1);
        add(married);
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(mycolor1);
        add(unmarried);
        
        Other = new JRadioButton("Others");
        Other.setBounds(630, 390, 100, 30);
        Other.setBackground(mycolor1);
        add(Other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(Other);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        addressTextField.setBounds(300,440, 400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        stateTextField.setBounds(300,540, 400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        
        next = new JButton("Next>>");
        next.setFont(new Font("Raleway", Font.PLAIN, 15));
        next.setBackground(mycolor2);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        Color mycolor = new Color(243,210,193);
        getContentPane().setBackground(mycolor);
        setSize(850,800);
        setLocation(520,30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + n;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dobDateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender ="FEMALE";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital ="Married";
        }
        else if(unmarried.isSelected())
        {
            marital="UnMarried";
        }
        else if(Other.isSelected())
        {
            marital = "Others";
        }
        String address = addressTextField.getText();
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String pin = pincodeTextField.getText();
        
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required!!");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')" ;
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new SignupOne();
    }
}
