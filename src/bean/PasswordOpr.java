package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseIO;

public class PasswordOpr {
	static DataBaseIO db = new DataBaseIO();
	
	public static void insert(PasswordBean pass) {
		Object params[] = { Integer.parseInt(pass.getID()), pass.getType(), pass.getPassword()};
		String sql = "insert into pass "
				+ "(id, type, password) values(?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static String getPasswordByID(String id, String type) {
		String pass = "";
		Object params[] = {Integer.parseInt(id), type};
		String sql = "select * from pass where id = ? and type = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				pass = rs.getString("password");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return pass;
	}
	
	public static void updatePassword(String id, String type, String password) {
		Object params[] = { password, Integer.parseInt(id), type };
		String sql = "update pass set password = ? where id = ? and type = ? ";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void main(String[] args) {
//		PasswordBean pass = new PasswordBean();
//		pass.setId("002");
//		pass.setType("教师");
//		pass.setPassword("123456");
//		insert(pass);
		updatePassword("002", "教师", "123");
		System.out.println(getPasswordByID("002", "教师"));
	}
}
