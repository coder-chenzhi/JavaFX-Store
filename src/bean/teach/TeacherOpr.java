package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Generator;
import util.Time;
import database.DataBaseIO;

public class TeacherOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * ��һ����ʦ�Ĺ��ţ�ע���½�ʦʱ��Ҫ��ʾ�������
	 * 
	 * @return ��һ����ʦ�Ĺ���
	 */
	public static int getNextTeacherID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(teacherID) as maxID from Teachers";
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

		if (id / 1000 == Integer.parseInt(Time.getYear())) {
			id++;
		} else {
			id = Integer.parseInt(Time.getYear()) * 1000 + 1;
		}
		return id;
	}

	/**
	 * ���ӽ�ʦ
	 * 
	 * @param teacher
	 *            ��ʦ
	 */
	public static void insertTeacher(TeacherBean teacher) {
		Object params[] = { teacher.getAddress(), teacher.getBirthday(),
				teacher.getEducation(), teacher.getEnrollDay(),
				teacher.getIdentifyCard(), teacher.getLevel(),
				teacher.getMajor(), teacher.getPhone(), teacher.getRealName(),
				teacher.getSchool(), teacher.getSex(), teacher.getStatus(),
				teacher.getOther(), getNextTeacherID() };
		String sql = "insert into Teachers "
				+ "(address, birthday, education, enrollDay,"
				+ "identifyCard, level, major, phone, realname,"
				+ "school, sex, status, other, teacherID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * ��ID���ҽ�ʦ
	 * 
	 * @param id
	 *            ��ʦ��ID
	 * @return
	 */
	public static TeacherBean getTeacherByID(int id) {
		TeacherBean teacher = new TeacherBean();
		Object params[] = { id };
		String sql = "select * from Teachers where teacherID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				teacher.setTeacherID(rs.getInt("teacherID"));
				teacher.setAddress(rs.getString("address"));
				teacher.setBirthday(rs.getString("birthday"));
				teacher.setEducation(rs.getString("education"));
				teacher.setEnrollDay(rs.getString("enrollDay"));
				teacher.setIdentifyCard(rs.getString("identifyCard"));
				teacher.setLevel(rs.getString("level"));
				teacher.setMajor(rs.getString("major"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setRealName(rs.getString("realName"));
				teacher.setSchool(rs.getString("school"));
				teacher.setSex(rs.getString("sex"));
				teacher.setStatus(rs.getBoolean("status"));
				teacher.setOther(rs.getString("other"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return teacher;
	}

	/**
	 * ��רҵ���Ͳ��ҽ�ʦ
	 * 
	 * @param major
	 *            ��ʦ��רҵ����
	 * @param status
	 *            ��ʦ״̬
	 * @return
	 */
	public static ArrayList<TeacherBean> getTeacherByMajor(String major,
			int status) {
		ArrayList<TeacherBean> teachers = new ArrayList<>();
		Object params[] = null;
		String sql = "";
		try {
			if (status == 2) {
				params = new Object[] { major };
				sql = "select * from Teachers where major = ?";
			} else if (status == 0 || status == 1) {
				params = new Object[] { major, status };
				sql = "select * from Teachers where major = ? and status = ?";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("�Ƿ�״̬��statusֻ����0��1��2");
			e.printStackTrace();
		}

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				TeacherBean teacher = new TeacherBean();
				teacher.setTeacherID(rs.getInt("teacherID"));
				teacher.setAddress(rs.getString("address"));
				teacher.setBirthday(rs.getString("birthday"));
				teacher.setEducation(rs.getString("education"));
				teacher.setEnrollDay(rs.getString("enrollDay"));
				teacher.setIdentifyCard(rs.getString("identifyCard"));
				teacher.setLevel(rs.getString("level"));
				teacher.setMajor(rs.getString("major"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setRealName(rs.getString("realName"));
				teacher.setSchool(rs.getString("school"));
				teacher.setSex(rs.getString("sex"));
				teacher.setStatus(rs.getBoolean("status"));
				teacher.setOther(rs.getString("other"));
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return teachers;
	}

	/**
	 * �����ֲ��ҽ�ʦ��֧��ģ������
	 * 
	 * @param major
	 *            ��ʦ������
	 * @return
	 */
	public static ArrayList<TeacherBean> getTeacherByName(String name) {
		ArrayList<TeacherBean> teachers = new ArrayList<>();

		Object params[] = { "%" + name + "%" };
		String sql = "select * from Teachers where realName like ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				TeacherBean teacher = new TeacherBean();
				teacher.setTeacherID(rs.getInt("teacherID"));
				teacher.setAddress(rs.getString("address"));
				teacher.setBirthday(rs.getString("birthday"));
				teacher.setEducation(rs.getString("education"));
				teacher.setEnrollDay(rs.getString("enrollDay"));
				teacher.setIdentifyCard(rs.getString("identifyCard"));
				teacher.setLevel(rs.getString("level"));
				teacher.setMajor(rs.getString("major"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setRealName(rs.getString("realName"));
				teacher.setSchool(rs.getString("school"));
				teacher.setSex(rs.getString("sex"));
				teacher.setStatus(rs.getBoolean("status"));
				teacher.setOther(rs.getString("other"));
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return teachers;
	}

	/**
	 * �������н�ʦ
	 * 
	 * @param status
	 *            ��ʦ״̬��0��ʾ��У��1��ʾ��У��2��ʾ����
	 * @return
	 */
	public static ArrayList<TeacherBean> getAllTeachers(int status) {
		ArrayList<TeacherBean> teachers = new ArrayList<>();
		Object params[] = {};
		String sql = "";
		try {
			if (status == 0) {
				sql = "select * from Teachers where status = 0";
			} else if (status == 1) {
				sql = "select * from Teachers where status = 1";
			} else if (status == 2) {
				sql = "select * from Teachers";
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
				TeacherBean teacher = new TeacherBean();
				teacher.setTeacherID(rs.getInt("teacherID"));
				teacher.setAddress(rs.getString("address"));
				teacher.setBirthday(rs.getString("birthday"));
				teacher.setEducation(rs.getString("education"));
				teacher.setEnrollDay(rs.getString("enrollDay"));
				teacher.setIdentifyCard(rs.getString("identifyCard"));
				teacher.setLevel(rs.getString("level"));
				teacher.setMajor(rs.getString("major"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setRealName(rs.getString("realName"));
				teacher.setSchool(rs.getString("school"));
				teacher.setSex(rs.getString("sex"));
				teacher.setStatus(rs.getBoolean("status"));
				teacher.setOther(rs.getString("other"));
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return teachers;
	}

	/**
	 * �޸Ľ�ʦ��Ϣ
	 * 
	 * @param teacher
	 */
	public static void updateTeacher(TeacherBean teacher) {
		Object params[] = { teacher.getAddress(), teacher.getBirthday(),
				teacher.getEducation(), teacher.getEnrollDay(),
				teacher.getIdentifyCard(), teacher.getLevel(),
				teacher.getMajor(), teacher.getPhone(), teacher.getRealName(),
				teacher.getSchool(), teacher.getSex(), teacher.getStatus(),
				teacher.getOther(), teacher.getTeacherID() };
		String sql = "update Teachers set address = ?, birthday = ?, education = ?, enrollDay = ?,"
				+ "identifyCard = ?, level = ?, major = ?, phone = ?, realname = ?,"
				+ "school = ?, sex = ?, status = ?, other = ? where teacherID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void main(String[] args) {
		// TeacherBean teacher = new TeacherBean();
		// int num = 5;
		// for(int i = 0; i < num; i++) {
		// teacher.setRealName(Generator.nameGenerator());
		// teacher.setMajor(Generator.instrumentGenerator());
		// teacher.setSex(Generator.sexGenerator());
		// teacher.setEnrollDay(Generator.dayGenerator("19900101", "19950101"));
		// teacher.setStatus(Generator.booleanGenerator());
		// insertTeacher(teacher);
		// }
		System.out.println(getAllTeachers(2));
	}
}
