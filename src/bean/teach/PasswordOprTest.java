package bean.teach;

public class PasswordOprTest {
	public static void testGetPasswordByID(int id, String type) {
		System.out.println(PasswordOpr.getPasswordByID(id, type));
	}
	
	public static void testInsert(int id, String type, String password) {
		PasswordBean pass = new PasswordBean();
		pass.setId(id);
		pass.setType(type);
		pass.setPassword(password);
		PasswordOpr.insertPass(pass);
	}
	
	public static void main(String[] args) {
		testInsert(2015001, "教师", "123456");
		//testGetPasswordByID(20150002, "教师");
	}
}
