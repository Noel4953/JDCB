package com.revature.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingUtils {
public static void main(String[] args) {
    Statement stmt;
    ResultSet rs;
    // Calling the createConnection method of ConnectionsUtils Class to 
    // get a Connection Object
    Connection conn=ConnectionUtils.createConnection(); 
    
    // Step 3 - Prepare the query
    String sql="select * from client";
    try {
        stmt=conn.createStatement();
        // Step 4 -- Execute the query
        rs=stmt.executeQuery(sql);
        
        // Step 5 -- Process the result set
        while(rs.next())
            System.out.println(rs.getInt(1)+"    "+rs.getString("client_name"));
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    
}
}
