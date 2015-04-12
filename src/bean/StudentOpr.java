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
	 * ��һ��ѧ����ѧ�ţ�ע����ѧ��ʱ��Ҫ��ʾ���ѧ��
	 * 
	 * @return ��һ��ѧ����ѧ��
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
	 * ����ѧ��
	 * 
	 * @param student
	 *            ѧ��
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
	 * ͨ��������ȡѧ����ע�����������
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
	 * ��ѧ�Ų���ѧ��
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
	 * ��ѧ�Ų�ѯѧ����������֮��������Ĳ���
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
	 * ��ȡ����ѧ��
	 * 
	 * @param status
	 *            ѧ��״̬��0��ʾ��У,1��ʾ��У��2��ʾ����
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
			System.out.println("�Ƿ�״̬��statusֻ����0,1,2");
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
	 * ����ѧ����Ϣ
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
	 * �����˻����
	 * 
	 * @param studentID
	 *            ѧ��ѧ��
	 * @param money
	 *            �䶯������
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
