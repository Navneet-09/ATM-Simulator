/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*name="elibraryDBConnectionString" 
connectionString="Data Source=LAPTOP-CN23M2K9\SQLEXPRESS;Initial Catalog=elibraryDB;Integrated Security=True"
   providerName="System.Data.SqlClient"*/

package atm.management.system;
import java.sql.*;
public class Conn {
    
    Connection connection;
    Statement s;
    public Conn()
    {
         
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql:///atmmanagementsystem","root_name","password");          
            s = connection.createStatement();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
           
        }
    }  
}
