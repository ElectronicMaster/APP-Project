import java.sql.*;
import java.sql.Connection;

public class Conn{
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "saianuush#3273");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}