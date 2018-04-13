package bb;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import util.C3P0Utils;
import vo.User;

public class DBUtilsTest {
	
	
	@Test
	public void cc() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "INSERT INTO `hello`.`user` (`name`, `age`) VALUES (?, ?);";
		Object[] param= {"rose",23};
		try {
			int i = queryRunner.update(sql, param);
			System.out.println(i);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void uu() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="update user set age=? where name=?";
		Object[] param= {20,"rose"};
		try {
			int i = queryRunner.update(sql, param);
			System.out.println(i);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	public void dd() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="delete from user where age=? and name=?";
		Object[] param= {20,"rose"};
		try {
			int i = queryRunner.update(sql, param);
			System.out.println(i);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void rr1() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user";
		Object[] params= {};
		try {
			List<User> list = queryRunner.query(sql, new BeanListHandler<User>(User.class), params);
			for (User user : list) {
				System.out.println(user);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void rr2() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user";
		Object[] params= {};
		try {
			 User user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
				System.out.println(user);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void rr3() {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select count(*) from user";
		Object[] params= {};
		try {
			Long num=(Long)queryRunner.query(sql, new ScalarHandler(), params);
				System.out.println(num);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
