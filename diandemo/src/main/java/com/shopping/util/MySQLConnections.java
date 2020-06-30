package com.shopping.util;

import java.sql.DriverManager;

import java.sql.Connection;

public class MySQLConnections {
	
	 private String driver = "";
	    private String dbURL = "";
	    private String user = "";
	    private String password = "";
	    private static MySQLConnections connection = null;

	    private MySQLConnections() throws Exception {
	        driver = "com.mysql.jdbc.Driver";
	        dbURL = "jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
	        user = "root";
	        password = "123456";
	        //System.out.println("dbURL:" + dbURL);
	    }

	    public static Connection getConnection() {
	        Connection conn = null;
	        if (connection == null) {
	            try {
	                connection = new MySQLConnections();
	            } catch (Exception e) {
	                e.printStackTrace();
	                return null;
	            }
	        }
	        try {
	            Class.forName(connection.driver);
	            conn = DriverManager.getConnection(connection.dbURL,
	                    connection.user, connection.password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
}
