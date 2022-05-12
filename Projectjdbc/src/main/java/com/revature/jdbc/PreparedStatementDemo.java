package com.revature.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
public static void main(String[] args) {
	PreparedStatement pstmt;
	ResultSet rs;
//	CallableStatement cstmt;
	
	Connection conn= ConnectionUtils.createConnection();
	String selectAllFruits="select * from fruits";
	String selectOneFruit="select * from fruits where id =?";
	
	try {
	pstmt=conn.prepareStatement(selectAllFruits);
	rs=pstmt.executeQuery();
	
	while(rs.next())
		System.out.println(rs.getInt(1)+ " "+ rs.getString("name"));
	
	rs.close();
	pstmt.close();
	System.out.println("==========================Select one fruits based on ID =============================");
	
	pstmt= conn.prepareStatement(selectOneFruit);
	pstmt.setInt(1, 2);
	rs= pstmt.executeQuery();
	while(rs.next())
		System.out.println(rs.getInt(1)+ " "+ rs.getString("name"));
	rs.close();pstmt.close();
	
	System.out.println("========Insert DAta to table==============");
	String insertFruit = "Insert into fruits values(?,?)";
	pstmt = conn.prepareStatement(insertFruit);
	pstmt.setInt(1, 8);
	pstmt.setString(2, "Berry");
	pstmt.execute();
	pstmt.close();
	
//	System.out.println("===============Call Statement===========");
//	cstmt = conn.ConnectionUtils(fruits_insert_data);
//	
	
	
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
}
