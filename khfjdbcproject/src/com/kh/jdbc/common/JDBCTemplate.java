package com.kh.jdbc.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Properties prop;
	
//	private static JDBCTemplate instance;
	private static Connection conn;
	
	public JDBCTemplate() {}
//		try {
//			Class.forName(DRIVER_NAME);    // 반드시 해줘야하는 것이기 때문
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
	
	
//	public static JDBCTemplate getDriverLoad() {
//		if(instance == null) {
//			instance = new JDBCTemplate();
//		}
//		return instance;
//	}
	
	public static Connection getConnection() {
			try {
				prop = new Properties();
				FileReader reader = new FileReader("resources/dev.properties");
				prop.load(reader);
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				if(conn == null || conn.isClosed()) {
					Class.forName(prop.getProperty("driver"));
					conn = DriverManager.getConnection(url, user, password);
					conn.setAutoCommit(false);    // 오토 커밋 해제
				} 
			}catch (Exception e) {
				e.printStackTrace();
			} 
			return conn;
		}
 
	
	// 커밋
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 롤백
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 연결 해제
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
