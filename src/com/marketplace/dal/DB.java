package com.marketplace.dal;

public class DB {

	private static String username; //for now, this is your $USER
	private static String password;
	private static String dbURL;
	
	public DB() {
		username = "lladewig"; //please change to be your $USER!
		password = "";
		dbURL = "jdbc:postgresql://localhost:5432/lakeshore_marketplace";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getURL() {
		return dbURL;
	}
	
}
