/*

Steps to connect
1 - Register the Driver Class(MySQL Driver Class Registration)
2 - Creating Connection String
3 - Creating Statement
4 - Executing MySQL Queries
5 - Closing the Connection

*/

import java.sql.*;
import java.sql.Connection;

public class Conn{
    Connection c;
    Statement s;
    Conn(){
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "saianuush#3273");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}