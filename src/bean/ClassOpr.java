package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class ClassOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * �����µĿ�ʱ
	 * @param newClass
	 */
	public static void insertClass(ClassBean newClass) {
		Object params[] = { newClass.getCourseID(), newClass.getClassID(),
				newClass.getTeacherID(), newClass.getOnDate(),
				newClass.getPeriodID(), newClass.getRoomID(),
				newClass.getStatus() };
		String sql = "insert into classes (courseID, classID, teacherID, onDate, periodID, roomID, status) values (?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * �޸Ŀ�ʱ
	 * @param newClass
	 * @return �Ƿ��޸ĳɹ�
	 */
	public static Boolean updateClass(ClassBean newClass) {
		ClassBean oldClass = getClassByCourseIDAndClassID(
				newClass.getCourseID(), newClass.getClassID());
		String curTime = util.Time.getDate();
		if (oldClass.getOnDate().compareTo(curTime) < 0) {
			System.out.println("��������ģ�" + newClass.getCourseID() + "��"
					+ newClass.getClassID() + "��ʱ�Ѿ����������ڽ��У�����");
			return false;
		} else {
			Object params[] = { newClass.getTeacherID(), newClass.getOnDate(),
					newClass.getPeriodID(), newClass.getRoomID(),
					newClass.getCourseID(), newClass.getClassID(), newClass.getStatus() };
			String sql = "update classes set teacherID = ?, onDate = ?, periodID = ?, roomID = ? status = ? where courseID = ? and classID = ?";
			db.executeSqlWithoutResult(sql, params);
			return true;
		}
	}

	public static Boolean updateStatus(int courseID, int classID, String status) {
		ClassBean oldClass = getClassByCourseIDAndClassID(
				courseID, courseID);
		String curTime = util.Time.getDate();
		if (oldClass.getOnDate().compareTo(curTime) < 0) {
			System.out.println("��������ģ�" + courseID + "��"
					+ classID + "��ʱ�Ѿ����������ڽ��У�����");
			return false;
		} else {
			Object params[] = { courseID, classID, status };
			String sql = "update classes set status = ? where courseID = ? and classID = ?";
			db.executeSqlWithoutResult(sql, params);
			return true;
		}
	}
	
	/**
	 * ������п�ʱ
	 */
	public static void clear() {
		Object params[] = {};
		String sql = "delete from classes";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * �鿴ĳ�ſε����п�ʱ
	 * @param CourseID Ҫ�鿴�Ŀγ̵Ŀγ�ID
	 * @return
	 */
	public static ArrayList<ClassBean> getClassByCourseID(int CourseID) {
		ArrayList<ClassBean> classes = new ArrayList<>();
		Object params[] = { CourseID };
		String sql = "select * from classes where courseID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				ClassBean newClass = new ClassBean();
				newClass.setCourseID(rs.getInt("courseID"));
				newClass.setClassID(rs.getInt("classID"));
				newClass.setTeacherID(rs.getInt("teacherID"));
				newClass.setOnDate(rs.getString("onDate"));
				newClass.setPeriodID(rs.getString("periodID"));
				newClass.setRoomID(rs.getInt("roomID"));
				newClass.setStatus(rs.getString("status"));
				classes.add(newClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return classes;
	}

	/**
	 * ����ĳһ����ʱ
	 * @param CourseID
	 * @param ClassID
	 * @return
	 */
	public static ClassBean getClassByCourseIDAndClassID(int CourseID,
			int ClassID) {
		ClassBean newClass = new ClassBean();
		String sql = "select * from classes where CourseID = ? and ClassID = ?";
		Object params[] = { CourseID, ClassID };
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				newClass.setCourseID(rs.getInt("courseID"));
				newClass.setClassID(rs.getInt("classID"));
				newClass.setTeacherID(rs.getInt("teacherID"));
				newClass.setOnDate(rs.getString("onDate"));
				newClass.setPeriodID(rs.getString("periodID"));
				newClass.setRoomID(rs.getInt("roomID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return newClass;
	}

	public static ArrayList<ClassBean> getAllClasses() {
		ArrayList<ClassBean> classes = new ArrayList<>();
		String sql = "select * from classes";
		Object params[] = {};
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				ClassBean newClass = new ClassBean();
				newClass.setCourseID(rs.getInt("courseID"));
				newClass.setClassID(rs.getInt("classID"));
				newClass.setTeacherID(rs.getInt("teacherID"));
				newClass.setOnDate(rs.getString("onDate"));
				newClass.setPeriodID(rs.getString("periodID"));
				newClass.setRoomID(rs.getInt("roomID"));
				newClass.setStatus(rs.getString("status"));
				classes.add(newClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return classes;
	}

	/**
	 * ���ڼ���ſ��Ƿ��ͻ�����ArrayList��Ϊ�ձ����ͻ
	 * 
	 * @return
	 */
	public static ArrayList<ClassBean> getClassByDateAndPeriodAndRoom(
			String date, String period, int room) {
		ArrayList<ClassBean> classes = new ArrayList<>();
		String sql = "select * from classes where onDate = ? and periodID = ? and roomID = ?";
		Object params[] = { date, period, room };
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				ClassBean newClass = new ClassBean();
				newClass.setCourseID(rs.getInt("courseID"));
				newClass.setClassID(rs.getInt("classID"));
				newClass.setTeacherID(rs.getInt("teacherID"));
				newClass.setOnDate(rs.getString("onDate"));
				newClass.setPeriodID(rs.getString("periodID"));
				newClass.setRoomID(rs.getInt("roomID"));
				newClass.setStatus(rs.getString("status"));
				classes.add(newClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return classes;
	}

	public static void main(String[] args) {

	}

}
