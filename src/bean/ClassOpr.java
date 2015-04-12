package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class ClassOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * 插入新的课时
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
	 * 修改课时
	 * @param newClass
	 * @return 是否修改成功
	 */
	public static Boolean updateClass(ClassBean newClass) {
		ClassBean oldClass = getClassByCourseIDAndClassID(
				newClass.getCourseID(), newClass.getClassID());
		String curTime = util.Time.getDate();
		if (oldClass.getOnDate().compareTo(curTime) < 0) {
			System.out.println("不允许更改！" + newClass.getCourseID() + "第"
					+ newClass.getClassID() + "课时已经结束或正在进行！！！");
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
			System.out.println("不允许更改！" + courseID + "第"
					+ classID + "课时已经结束或正在进行！！！");
			return false;
		} else {
			Object params[] = { courseID, classID, status };
			String sql = "update classes set status = ? where courseID = ? and classID = ?";
			db.executeSqlWithoutResult(sql, params);
			return true;
		}
	}
	
	/**
	 * 清空所有课时
	 */
	public static void clear() {
		Object params[] = {};
		String sql = "delete from classes";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * 查看某门课的所有课时
	 * @param CourseID 要查看的课程的课程ID
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
	 * 返回某一个课时
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
	 * 用于检测排课是否冲突，如果ArrayList不为空表则冲突
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
