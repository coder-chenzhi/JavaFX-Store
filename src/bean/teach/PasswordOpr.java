package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseIO;

public class PasswordOpr {
	static DataBaseIO db = new DataBaseIO();
	
	/**
	 * �����µ������¼
	 * @param pass Ҫ����������¼
	 */
	public static void insertPass(PasswordBean pass) {
		Object params[] = { pass.getID(), pass.getType(), pass.getPassword()};
		String sql = "insert into pass "
				+ "(id, type, password) values(?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	
	/**
	 * ��ȡ����
	 * @param id �û�ID
	 * @param type �û����ͣ���ʦ������Ա��
	 * @return ����
	 */
	public static String getPasswordByID(int id, String type) {
		String pass = "";
		Object params[] = {id, type};
		String sql = "select password from pass where id = ? and type = ?";
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
	
	
	/**
	 * �޸�����
	 * @param id �û�ID
	 * @param type �û�����
	 * @param password ����
	 */
	public static void updatePassword(int id, String type, String password) {
		Object params[] = { password, id, type };
		String sql = "update pass set password = ? where id = ? and type = ? ";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void main(String[] args) {
//		PasswordBean pass = new PasswordBean();
//		pass.setId("002");
//		pass.setType("��ʦ");
//		pass.setPassword("123456");
//		insert(pass);
	}
}
