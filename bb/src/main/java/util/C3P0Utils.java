package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 获得数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection() {
		try {
		return	dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
