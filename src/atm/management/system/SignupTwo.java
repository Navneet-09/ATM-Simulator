/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//implements ActionListener
public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField  panTextField, adharTextField;
    JRadioButton syes, sno, accyes, accno;
    JButton next;
    JComboBox religion, category, occupation, income, education;
    Long n;
    String form_no;
    
    SignupTwo(String formno)
    {
        form_no = formno;
        setTitle("NEW ACCOUNT APPLICATION Form - PAGE 2");
        setLayout(null);
        Color mycolor1 = new Color(243,210,193);
        Color mycolor2 = new Color(0,24,88);//DARK BLUE COLOUR
        
                          
        JLabel additionalDetails = new JLabel("PAGE 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(285,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {" ","Hindu","Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] ={" ","General","OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[] ={" ","Null","< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,310,200,30);
        add(email);
        
        String valEducation[] = {" ","Non-Graduate", "Graduated", "Post-Graduated", "Doctrate", "Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String valOccupation[] = {" ","Bussiness", "Self-Employed", "Salaried", "Student", "Retired", "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
    
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        panTextField.setBounds(300,440, 400,30);
        add(panTextField);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway", Font.PLAIN, 15));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(mycolor1);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(mycolor1);
        add(sno);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        accyes = new JRadioButton("Yes");
        accyes.setBounds(300,590,100,30);
        accyes.setBackground(mycolor1);
        add(accyes);
        
        accno = new JRadioButton("NO");
        accno.setBounds(450,590,100,30);
        accno.setBackground(mycolor1);
        add(accno);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(accyes);
        accountGroup.add(accno);
        
        next = new JButton("Next");
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
        String rel = (String)religion.getSelectedItem();
        String categ = (String)category.getSelectedItem();
        String inc = (String) income.getSelectedItem();
        String edu = (String) education.getSelectedItem();
        String occ = (String) occupation.getSelectedItem();
        String pan = panTextField.getText();
        String adh = adharTextField.getText();
        String seniorCitizen = null;
        if( syes.isSelected() )
        {
            seniorCitizen = "Yes";
        }
        else if( sno.isSelected() )
        {
            seniorCitizen = "No";
        }
        String exisAcc = null;
        if( accyes.isSelected() )
        {
            exisAcc = "Yes";
        }
        else if( accno.isSelected() )
        {
            exisAcc = "No";
        }
        try{
            if(rel.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Religion!");
            }
            else if(categ.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Category!");
            }
            else if(inc.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Income!");
            }
            else if(edu.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Educational Qualification!");
            }
            else if(occ.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Occupation!");
            }
            else if(pan.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select PAN number!");
            }
            else if(adh.equals(""))
            {
                JOptionPane.showMessageDialog(null, "please select Aadhar number!");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+form_no+"','"+rel+"','"+categ+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+adh+"', '"+seniorCitizen+"', '"+exisAcc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(form_no).setVisible(true);
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
   
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
