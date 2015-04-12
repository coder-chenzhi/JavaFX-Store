package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Time;
import util.Generator;
import database.DataBaseIO;

public class StudentOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * 下一个学生的学号，注册新学生时需要显示这个学号
	 * 
	 * @return 下一个学生的学号
	 */
	public static int getNextStudentID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(studentID) as maxID from students;";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				id = rs.getInt("maxID");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		if (id / 10000 == Integer.parseInt(Time.getYear())) {
			id++;
		} else {
			id = Integer.parseInt(Time.getYear()) * 10000 + 1;
		}
		return id;
	}

	/**
	 * 增加学生
	 * 
	 * @param student
	 *            学生
	 */
	public static void insertStudent(StudentBean student) {
		Object params[] = { student.getAddress(), student.getBalance(),
				student.getBirthday(), student.getClassGrade(),
				student.getClassType(), student.getEnrollDay(),
				student.getHobby(), student.getInstrument(),
				student.getLevel(), student.getMajor(), student.getOther(),
				student.getParentsName(), student.getPhone(),
				student.getRealName(), student.getStatus(),
				student.getSchool(), student.getSex(), getNextStudentID() };
		String sql = "insert into students "
				+ "(address, balance, birthday, classGrade, classType, enrollDay,"
				+ "hobby, instrument, level, major, other, parentsname, phone, realname,"
				+ "status, school, sex, studentID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * 通过姓名获取学生，注意可能有重名
	 * 
	 * @param name
	 * @return
	 */
	public static ArrayList<StudentBean> getStudentByName(String name) {
		ArrayList<StudentBean> students = new ArrayList<>();
		Object params[] = { name };
		String sql = "select * from students where realName = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				StudentBean student = new StudentBean();
				student.setStudentID(rs.getInt("studentID"));
				student.setAddress(rs.getString("address"));
				student.setBalance(rs.getDouble("balance"));
				student.setBirthday(rs.getString("birthday"));
				student.setClassGrade(rs.getString("classGrade"));
				student.setClassType(rs.getString("classType"));
				student.setEnrollDay(rs.getString("enrollDay"));
				student.setHobby(rs.getString("hobby"));
				student.setInstrument(rs.getString("instrument"));
				student.setLevel(rs.getString("level"));
				student.setMajor(rs.getString("major"));
				student.setOther(rs.getString("other"));
				student.setParentsName(rs.getString("parentsName"));
				student.setPhone(rs.getString("phone"));
				student.setRealName(rs.getString("realName"));
				student.setSchool(rs.getString("school"));
				student.setSex(rs.getString("sex"));
				student.setStatus(rs.getBoolean("status"));
				students.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return students;
	}

	/**
	 * 按学号查找学生
	 * 
	 * @param studentID
	 * @return
	 */
	public static StudentBean getStudentByID(int studentID) {
		StudentBean student = new StudentBean();
		Object params[] = { studentID };
		String sql = "select * from students where studentID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				student.setStudentID(rs.getInt("studentID"));
				student.setAddress(rs.getString("address"));
				student.setBalance(rs.getDouble("balance"));
				student.setBirthday(rs.getString("birthday"));
				student.setClassGrade(rs.getString("classGrade"));
				student.setClassType(rs.getString("classType"));
				student.setEnrollDay(rs.getString("enrollDay"));
				student.setHobby(rs.getString("hobby"));
				student.setInstrument(rs.getString("instrument"));
				student.setLevel(rs.getString("level"));
				student.setMajor(rs.getString("major"));
				student.setOther(rs.getString("other"));
				student.setParentsName(rs.getString("parentsName"));
				student.setPhone(rs.getString("phone"));
				student.setRealName(rs.getString("realName"));
				student.setSchool(rs.getString("school"));
				student.setSex(rs.getString("sex"));
				student.setStatus(rs.getBoolean("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return student;
	}

	/**
	 * 按学号查询学生的余额，方便之后更改余额的操作
	 * 
	 * @param studentID
	 * @return
	 */
	public static double getBalanceByID(int studentID) {
		double balance = 0;
		Object params[] = { studentID };
		String sql = "select balance from students where studentID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				balance = rs.getDouble("balance");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return balance;
	}

	/**
	 * 获取所有学生
	 * 
	 * @param status
	 *            学生状态，0表示离校,1表示在校，2表示所有
	 * @return
	 */
	public static ArrayList<StudentBean> getAllStudents(int status) {
		ArrayList<StudentBean> students = new ArrayList<>();
		Object params[] = {};
		String sql = "";
		try {
			if (status == 0) {
				sql = "select * from students where status = 0";
			} else if (status == 1) {
				sql = "select * from students where status = 1";
			} else if (status == 2) {
				sql = "select * from students";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("非法状态，status只能是0,1,2");
			e.printStackTrace();
		}
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				StudentBean student = new StudentBean();
				student.setStudentID(rs.getInt("studentID"));
				student.setAddress(rs.getString("address"));
				student.setBalance(rs.getDouble("balance"));
				student.setBirthday(rs.getString("birthday"));
				student.setClassGrade(rs.getString("classGrade"));
				student.setClassType(rs.getString("classType"));
				student.setEnrollDay(rs.getString("enrollDay"));
				student.setHobby(rs.getString("hobby"));
				student.setInstrument(rs.getString("instrument"));
				student.setLevel(rs.getString("level"));
				student.setMajor(rs.getString("major"));
				student.setOther(rs.getString("other"));
				student.setParentsName(rs.getString("parentsName"));
				student.setPhone(rs.getString("phone"));
				student.setRealName(rs.getString("realName"));
				student.setSchool(rs.getString("school"));
				student.setSex(rs.getString("sex"));
				student.setStatus(rs.getBoolean("status"));
				students.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return students;
	}

	/**
	 * 更新学生信息
	 * 
	 * @param student
	 */
	public static void updateStudent(StudentBean student) {
		Object params[] = { student.getAddress(), student.getBalance(),
				student.getBirthday(), student.getClassGrade(),
				student.getClassType(), student.getEnrollDay(),
				student.getHobby(), student.getInstrument(),
				student.getLevel(), student.getMajor(), student.getOther(),
				student.getParentsName(), student.getPhone(),
				student.getRealName(), student.getStatus(),
				student.getSchool(), student.getSex(), student.getStudentID() };
		String sql = "update students "
				+ "set address = ?, balance = ?, birthday = ?, classGrade = ?, classType = ?,"
				+ "enrollDay = ?, hobby = ?, instrument = ?, level = ?, major = ?, other = ?,"
				+ "parentsname = ?, phone = ?, realname = ?, status = ?, school = ?, sex = ?"
				+ "where studentID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * 更新账户余额
	 * 
	 * @param studentID
	 *            学生学号
	 * @param money
	 *            变动的数额
	 * @return
	 */
	public static double updateBalance(int studentID, double money) {
		double balance = getBalanceByID(studentID) + money;
		Object params[] = { balance, studentID };
		String sql = "update students set balance = ? where studentID  = ?";
		db.executeSqlWithoutResult(sql, params);
		return balance;
	}

	public static void main(String[] args) {
//		StudentBean student = new StudentBean();
//		int num = 10;
//		for(int i = 0; i < num; i++) {
//			student.setRealName(Generator.nameGenerator());
//			student.setMajor(Generator.instrumentGenerator());
//			student.setSex(Generator.sexGenerator());
//			student.setEnrollDay(Generator.dayGenerator("19900101", "19950101"));
//			student.setStatus(Generator.booleanGenerator());
//			insertStudent(student);
//		}
		System.out.println(getAllStudents(2));
	}
}
