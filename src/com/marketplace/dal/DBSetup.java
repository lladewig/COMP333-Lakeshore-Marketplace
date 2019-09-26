package com.marketplace.dal;

import java.sql.*;

public class DBSetup {
	
	public static Connection getConnection() {
		DB dbInfo = new DB();
		
		Connection dbConnection = null; 
		
		try {
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection(dbInfo.getURL(), dbInfo.getUsername(), dbInfo.getPassword());
		}
		catch (SQLException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		
		return dbConnection;
	}
	
	public static void main(String args[]) throws SQLException {
		Connection connection = getConnection();
		System.out.println(connection); //prints the connection
		
		
		//run this to make sure your connection is working!
		Statement state = connection.createStatement();
		ResultSet r = state.executeQuery("SELECT * FROM order_status;");
		r.next();
		System.out.println(r.getString("order_status_name")); //should print "processing"
		
	}
}
