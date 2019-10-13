package com.rmiDB;

import java.io.Serializable;
import java.sql.*;

public class DBmanager {
	private static final String userName = "root";
	private static final String password = "";
	private static final String dburl="jdbc:mysql://localhost:3306/rmidb?useUnicode=true&characterEncoding=utf8";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,userName,password);
		}catch(ClassNotFoundException e) {
			System.out.println("没有找到数据库驱动程序");
		}catch(SQLException e) {
			System.out.println("数据库连接时出现异常，可能由于数据库服务未启动造成，请先启动数据库服务");
			System.out.println(e.toString());
		}
		return conn;
	}
	public static void main(String args[]) {
		conn = getConn();
	}
}
