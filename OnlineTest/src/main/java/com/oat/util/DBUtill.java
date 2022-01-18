package com.oat.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill 
{
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/smalldayit";
	private static String dbUname = "root";
	private static String dbPassword = "";
	private static String dbDriver = "com.mysql.jdbc.Driver";
	public static Connection getDBConnection()
	{
		Connection connection = null;
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
