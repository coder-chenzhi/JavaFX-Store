package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseIO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String url = "jdbc:mysql://localhost:3306/store";
	private String username = "root";
	private String password = "123";
	
	/**
	 * 关闭数据库
	 */
	public void close() {
		System.out.println("Closing the connection.");
		try {
			if (rs != null) {

				rs.close();
				rs = null;
			}
			if (ps != null) {

				ps.close();
				ps = null;
			}
			if (conn != null) {

				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection getConnetion() {
		// 连接数据库
		try {
			System.out.println("Loading driver...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
					"Cannot find the driver in the classpath!", e);
		}

		try {
			System.out.println("Connecting database...");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		} catch (SQLException e) {
			throw new RuntimeException("Cannot connect the database!", e);
		}
		return conn;
	}

	public void executeSqlWithoutResult(String sql, Object[] params) {
		try {
			if (conn == null)
				getConnetion();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 组装SQL Server语句
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			// 执行SQL Server语句
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.close();
			// 关闭数据库连接
		}
	}

	public ResultSet executeSqlWithResult(String sql, Object[] params) {
		// 有返回值的SQL Server语句必须在调用该方法的程序获得返回结果以后再关闭数据库连接，
		// 否则ResultSet中的内容就会被清空
		ResultSet rs = null;
		try {
			if (conn == null)
				getConnetion();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 组装SQL Server语句
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			// 执行SQL Server语句
			rs = pstmt.executeQuery();
			// conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void main(String[] args) {
		DataBaseIO db = new DataBaseIO();
		db.getConnetion();
		db.close();
	}
}
