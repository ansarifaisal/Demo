package com.niit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	//Configuration
	private static final String URL = "jdbc:h2:tcp://localhost/~/testDemo";
	private static final String DRIVER = "org.h2.Driver";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	private static Connection connection = null;
	
	private DBUtil(){
	}
	
	public static Connection getConnection() {	
		if(connection==null){
			try {
				//1. Load The Driver
				Class.forName(DRIVER);
				System.out.println("Driver Loaded Successfully");
				//2. The Connection Object
				connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				System.out.println("Connection Established");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Loading Fail "+e.getMessage());
			} catch (SQLException e) {
				System.out.println("Connection Object Not Created "+e.getMessage());
			}
		}
		return connection;
	}
}
