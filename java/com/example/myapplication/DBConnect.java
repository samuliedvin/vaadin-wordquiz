package com.example.myapplication;

import java.sql.*;

public class DBConnect {
	private	Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:8889/sanakoe", "root", "root");
			st = con.createStatement();
			
			} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	/*
	 * public void getData() {
		 try {
			String query = "select * from merkinta";
			rs = st.executeQuery(query);
				System.out.println("Records from database: ");
				while (rs.next()) {
					
				}
			
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
	}
	*/
	
	

}
