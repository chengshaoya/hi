package bb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


public class TestMysql {
	String url="jdbc:mysql://192.168.6.111:3306/hello?useUnicode=true&characterEncoding=UTF8";
	String user="root";
	String password="P@ssw0rd";
	
	//Create
	@Test
	public void test() {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接
			Connection coon = DriverManager.getConnection(url, user, password);
			//获得预编译对象
			String sql = "INSERT INTO `hello`.`user` (`name`, `age`) VALUES ('呵呵', 99);";
			PreparedStatement ps = coon.prepareStatement(sql);
			//执行语句
			int rs = ps.executeUpdate();
			//获得结果
			System.out.println(rs);
			//释放资源
			ps.close();
			coon.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Retrieve
	@Test
	public void tes2t() {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接
			Connection coon = DriverManager.getConnection(url, user, password);
			//获得预编译对象
			String sql = "select * from `hello`.`user` ;";
			PreparedStatement ps = coon.prepareStatement(sql);
			//执行语句
			 ResultSet rs = ps.executeQuery();
			//获得结果
			 while (rs.next()) {
				 System.out.println(rs.getString(1)+"：：："+rs.getString(2));
			}
			
			//释放资源
			ps.close();
			coon.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update
	@Test
	public void tes3t() {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接
			Connection coon = DriverManager.getConnection(url, user, password);
			//获得预编译对象
			String sql = "UPDATE `hello`.`user` SET `name`='小明', `age`='23' WHERE (`name`='??')";
			PreparedStatement ps = coon.prepareStatement(sql);
			//执行语句
			int  rs = ps.executeUpdate();
			//获得结果
			System.out.println(rs);
			//释放资源
			ps.close();
			coon.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete
	@Test
	public void tes4t() {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接
			Connection coon = DriverManager.getConnection(url, user, password);
			//获得预编译对象
			String sql = "delete from user WHERE name='zoro'";
			PreparedStatement ps = coon.prepareStatement(sql);
			//执行语句
			int  rs = ps.executeUpdate();
			//获得结果
			System.out.println(rs);
			//释放资源
			ps.close();
			coon.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
