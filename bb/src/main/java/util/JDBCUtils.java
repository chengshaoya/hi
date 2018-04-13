package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtils {
	static String driver;
	static String url;
	static String user;
	static String password;
	
	static{
		try {
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
			
			Properties props = new Properties();
			props.load(is);
			
			//2 使用getProperty(key)，通过key获得需要的值，
			driver = props.getProperty("jdbc.driver");
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.user");
			password = props.getProperty("jdbc.password");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	 public static Connection getConnection() {
		 
			try {
				Class.forName(driver);
				//获得链接
				Connection coon = DriverManager.getConnection(url, user, password);
				
				return coon;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	 } 
	 
	 
	 public static void release(Connection coon,PreparedStatement ps,ResultSet rs) {
		 try {
			if (rs!=null) {
				 rs.close();
			}
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		}finally {
			 try {
					if (ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					 throw new RuntimeException(e);
				}finally {
					 try {
							if (coon!=null) {
								coon.close();
							}
						} catch (SQLException e) {
							 throw new RuntimeException(e);
						}
		}
		 
	 }

}
	 
	 
	 }
