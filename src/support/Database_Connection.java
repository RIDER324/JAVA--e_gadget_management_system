// @author: Akil Sundhar
// @year: 2022
// @purpose: Minor Project

package support;

import java.sql.*;

public class Database_Connection {
    
    final String DB_URL="jdbc:mysql://localhost:3306/e_gadget";
    final String USER="root";
    final String PASSWORD="";
    
    public int DB_Insert(String query){
        int rows;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)
            DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement stmt= con.createStatement();
            rows = stmt.executeUpdate(query);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
            rows = 0;
        }
        return rows;
    }
    
    public ResultSet DB_Select(String query){
        ResultSet rs;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)
            DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement stmt= con.createStatement();
            rs = stmt.executeQuery(query);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
            rs = null;
        }
        return rs;
    }
    
    public int DB_Update(String query){
        int rows;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)
            DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement stmt= con.createStatement();
            rows = stmt.executeUpdate(query);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
            rows = 0;
        }
        return rows;
    }
    
    public int DB_Delete(String query){
        int rows;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)
            DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement stmt= con.createStatement();
            rows = stmt.executeUpdate(query);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
            rows = 0;
        }
        return rows;
    }
}
