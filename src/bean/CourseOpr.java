package bean;

import database.*;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Time;

public class CourseOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insertCourse(CourseBean course) {
		Object params[] = { getNextCourseID(), course.getTeacherID(),
				course.getStartDate(), course.getPeriod(),
				course.getWeek(), course.getType(), course.getInstrument(),
				course.getRoomID(), course.getExpense(), course.getVolume(),
				course.getOther(), course.getSelected() };
		String sql = " insert into courses (courseID, teacherID, startDate, periodID, "
				+ "week, type, instrument, roomID, expense, volume, other ,selected)"
				+ "value (?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void updateCourse() {

	}

	public static int getNextCourseID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(courseID) as maxID from courses";
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

	public static ArrayList<CourseBean> getAllCourses() {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from courses";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriod(rs.getInt("periodID"));
				course.setWeek(rs.getInt("week"));
				course.setType(rs.getString("type"));
				course.setInstrument(rs.getString("instrument"));
				course.setRoomID(rs.getInt("roomID"));
				course.setExpense(rs.getDouble("expense"));
				course.setVolume(rs.getInt("volume"));
				course.setOther(rs.getString("other"));
				course.setSelected(rs.getInt("selected"));
				courses.add(course);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return courses;
	}

	public static ArrayList<String> getAllInstruments() {
		ArrayList<String> instruments = new ArrayList<>();
		Object params[] = {};
		String sql = "select distinct instrument from courses";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				String instrument = rs.getString("instrument");
				instruments.add(instrument);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return instruments;
	}

	public static ArrayList<CourseBean> getCoursesByTeacherName() {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from courses where teacherID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriod(rs.getInt("periodID"));
				course.setWeek(rs.getInt("week"));
				course.setType(rs.getString("type"));
				course.setInstrument(rs.getString("instrument"));
				course.setRoomID(rs.getInt("roomID"));
				course.setExpense(rs.getDouble("expense"));
				course.setVolume(rs.getInt("volume"));
				course.setOther(rs.getString("other"));
				course.setSelected(rs.getInt("selected"));
				courses.add(course);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return courses;
	}

	public static ArrayList<CourseBean> getCoursesByInstrument() {
		ArrayList<CourseBean> courses = new ArrayList<>();

		return courses;
	}

	public static ArrayList<CourseBean> getCoursesByType() {
		ArrayList<CourseBean> courses = new ArrayList<>();

		return courses;
	}

	public static ArrayList<CourseBean> getCoursesByTime(String startDate,
			String startTime, String endDate, String endTime) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		String minDate = "00000000";
		String minTime = "000000";
		String maxDate = "99999999";
		String maxTime = "999999";

		if (startDate == null) {
			startDate = minDate;
		}
		if (startTime == null) {
			startTime = minTime;
		}
		if (endDate == null) {
			endDate = maxDate;
		}
		if (endTime == null) {
			endTime = maxTime;
		}

		Object params[] = { startDate, startTime, endDate, endTime };
		String sql = "select * from course where launchDate >= ? and launchTime >= ?"
				+ " and launchDate <= ? and launchTime <= ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		return courses;
	}

	public static void main(String[] args) {
//		CourseBean course = new CourseBean();
//		course.setTeacherID(2015005);
//		course.setExpense(60);
//		course.setInstrument("¸ÖÇÙ");
//		course.setLaunchDate("20150503");
//		course.setLaunchTime("083000");
//		course.setLength(1);
//		course.setOther("ÄãºÃ");
//		course.setRoomID(401);
//		course.setSelected(0);
//		course.setType("Ð¡¿Î");
//		course.setVolume(60);
//		insertCourse(course);
		System.out.println(getAllInstruments());
		System.out.println(getAllCourses());
	}

}
