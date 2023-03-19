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
