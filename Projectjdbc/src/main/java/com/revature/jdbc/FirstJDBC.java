package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		// Calling the CreatConnection method of ConnectionsUtils Class to
		//get a Connection Object
		
		
		try {
	//STEP 1 - load the driver -- Optional from Java6 +
		Class.forName("org.postgresql.Driver");
		//STEP 2 - Obtain a Connection
		String url = System.getenv("mydbl");
		conn = DriverManager.getConnection(url);
		//STEP 3 - Create Statement Obj
		stmt = conn.createStatement();
		
		//STEP 4 - Execute the Query
		
		String selectFruit = "select * from fruits";
		
		rs= stmt.executeQuery(selectFruit);
		
		//Step 5 -- Iterate / Process the ResultSet
		while(rs.next()) {
			//System.out.println(rs.getInt("id")+"  "+rs.getString("client_name"));
			System.out.println(rs.getInt(1)+"  "+rs.getString("name"));
		}
		
		//STEP 6 - Close the resources(should be done in a finally block)
		conn.close();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
