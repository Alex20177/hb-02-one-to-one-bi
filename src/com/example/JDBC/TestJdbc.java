package com.example.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
		
			System.out.println("Connection to database"+jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection  sucessfull!!!");
			
			con.close();
			
			System.out.println("Connection closed");
			
		}//Close try 
		
		catch (Exception e) {
			e.printStackTrace();
		}//Close catch
		
	}//Close main method.

}//Close TestJdbc class.
