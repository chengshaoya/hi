package bb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.JDBCUtils;

public class Test2 {
	
	@Test
	public void c() {
		try {
			Connection coon = JDBCUtils.getConnection();
			String sql = "INSERT INTO `hello`.`user` (`name`, `age`) VALUES ('老赵', 99);";
			PreparedStatement ps = coon.prepareStatement(sql);
			int rs = ps.executeUpdate();
			System.out.println(rs);
			JDBCUtils.release(coon, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void r() {
		try {
			Connection coon = JDBCUtils.getConnection();
			String sql = "select * from `hello`.`user` ;";
			PreparedStatement ps = coon.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
				 System.out.println(rs.getString(1)+"：：："+rs.getString(2));
			}
			JDBCUtils.release(coon, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void u() {
		try {
			Connection coon = JDBCUtils.getConnection();
			String sql = "UPDATE `hello`.`user` SET `name`='小李', `age`='23' WHERE (`name`='老赵')";
			PreparedStatement ps = coon.prepareStatement(sql);
			int  rs = ps.executeUpdate();
			System.out.println(rs);
			JDBCUtils.release(coon, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void d() {
		try {
			Connection coon = JDBCUtils.getConnection();
			String sql = "delete from user WHERE name='小李'";
			PreparedStatement ps = coon.prepareStatement(sql);
			int  rs = ps.executeUpdate();
			System.out.println(rs);
			JDBCUtils.release(coon, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
