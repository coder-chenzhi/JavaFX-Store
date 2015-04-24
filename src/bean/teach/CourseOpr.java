package bean.teach;

import database.*;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Time;

public class CourseOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insertCourse(CourseBean course) {
		int courseID = getNextCourseID();
		Object params[] = { courseID, course.getTeacherID(),
				course.getStartDate(), course.getPeriodID(), course.getWeeks(),
				course.getType(), course.getInstrument(), course.getRoomID(),
				course.getExpense(), course.getVolume(), course.getOther(),
				course.getSelected() };
		String sql = "insert into courses (courseID, teacherID, startDate, periodID, "
				+ "weeks, type, instrument, roomID, expense, volume, other ,selected)"
				+ "value (?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
		
		/* ���ӿ�ʱ��¼ */
		for (int i = 0; i < course.getWeeks(); i++) {
			String date = Time.dateAddDay(course.getStartDate(), 7 * i);
			Object paramsTmp[] = { courseID, i, course.getTeacherID(), date,
					course.getPeriodID(), course.getRoomID(), "��ʱδ��ʼ"};
			String sqlTmp = "insert into classes (courseID, classID, teacherID, onDate, "
					+ "periodID, roomID, status) value (?,?,?,?,?,?,?)";
			db.executeSqlWithoutResult(sqlTmp, paramsTmp);
		}
	}

	public static Boolean updateCourse(CourseBean newCourse) {
		CourseBean course = getCourseByCourseID(newCourse.getCourseID());
		String curTime = util.Time.getDate();
		if (course.getStartDate().compareTo(curTime) < 0) {
			System.out.println("��������ģ�" + newCourse.getCourseID()
					+ "�Ѿ����������ڽ��У�������Ҫ�������ڽ��еĿγ̣���ȥ�޸ľ���Ŀ�ʱ������");
			return false;
		} else {
			Object params[] = { newCourse.getTeacherID(),
					newCourse.getStartDate(), newCourse.getPeriodID(),
					newCourse.getWeeks(), newCourse.getType(),
					newCourse.getInstrument(), newCourse.getRoomID(),
					newCourse.getExpense(), newCourse.getVolume(),
					newCourse.getOther(), newCourse.getSelected(),
					newCourse.getCourseID() };
			String sql = " update courses set teacherID = ?, startDate = ?, periodID = ?, "
					+ "weeks = ?, type = ?, instrument = ?, roomID = ?, expense = ?, volume = ?, other = ?,selected = ? "
					+ "where courseID = ?";
			db.executeSqlWithoutResult(sql, params);
			
			/* �޸Ŀ�ʱ��¼�����������ֱ��ɾ�����²��� */
			ClassOpr.deleteByCourseID(newCourse.getCourseID());
			insertCourse(newCourse);
			return true;
		}
	}

	public static int getCourseWeeks(int courseID) {
		Object params[] = {courseID};
		String sql = "select weeks from courses where courseID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		int weeks = 1;
		
		try {
			while (rs.next()) {
				weeks = rs.getInt("weeks");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return weeks;
	}
	
	/**
	 * ѧ��ѡ��
	 * @param courseID �γ�ID
	 * @param studentID ѧ��ID
	 */
	public static void selectCourse(int courseID, int studentID) {
		int weeks = getCourseWeeks(courseID);
		ClassRecordBean record = new ClassRecordBean();
		record.setCourseID(courseID);
		record.setStudentID(studentID);
		for (int i = 0; i < weeks; i++) {
			record.setClassID(i);
			record.setStatus(ClassOpr.getClassByCourseIDAndClassID(courseID, i).getStatus());
			ClassRecordOpr.insertRecord(record);
		}
	}
	
	/**
	 * ɾ���γ�
	 * @param courseID
	 * @return
	 */
	public static Boolean deleteCourse(int courseID) {
		CourseBean course = getCourseByCourseID(courseID);
		String curTime = util.Time.getDate();
		if (course.getStartDate().compareTo(curTime) < 0) {
			System.out.println("������ɾ����" + courseID + "�Ѿ����������ڽ��У�����");
			return false;
		} else {
			Object params[] = { courseID };
			String sql = "delete from courses where courseID = ?";
			db.executeSqlWithoutResult(sql, params);
			ClassOpr.deleteByCourseID(courseID);
			return true;
		}
	}

	public static CourseBean getCourseByCourseID(int CourseID) {
		CourseBean course = new CourseBean();
		Object params[] = { CourseID };
		String sql = "select * from courses where courseID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriodID(rs.getString("periodID"));
				course.setWeeks(rs.getInt("weeks"));
				course.setType(rs.getString("type"));
				course.setInstrument(rs.getString("instrument"));
				course.setRoomID(rs.getInt("roomID"));
				course.setExpense(rs.getDouble("expense"));
				course.setVolume(rs.getInt("volume"));
				course.setOther(rs.getString("other"));
				course.setSelected(rs.getInt("selected"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return course;
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

	/**
	 * �鿴���пγ�
	 * 
	 * @param status
	 *            �γ�״̬��0���Ѿ�������1�������ϿΣ�2�ǻ�δ���Σ�3�����пγ�
	 * @return
	 */
	public static ArrayList<CourseBean> getAllCourses(int status) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = {};
		String curTime = util.Time.getDate();
		String sql = "";
		try {
			if (status == 0) {
				ArrayList<CourseBean> candidates = getAllCourses(3);
				for (CourseBean course : candidates) {
					if (Time.dateAddDay(course.getStartDate(),
							course.getWeeks() * 7).compareTo(curTime) < 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 1) {
				ArrayList<CourseBean> candidates = getAllCourses(3);
				for (CourseBean course : candidates) {
					if (course.getStartDate().compareTo(curTime) < 0
							&& Time.dateAddDay(course.getStartDate(),
									course.getWeeks() * 7).compareTo(curTime) > 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 2) {
				params = new Object[] { curTime };
				sql = "select * from courses where startDate > ?";
			} else if (status == 3) {
				sql = "select * from courses";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("�Ƿ�״̬��statusֻ����0,1,2,3");
			e.printStackTrace();
		}
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriodID(rs.getString("periodID"));
				course.setWeeks(rs.getInt("weeks"));
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

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
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

	/**
	 * ͨ����ʦID���ҿγ�
	 * 
	 * @param teacherID
	 *            ��ʦID
	 * @param status
	 *            �γ�״̬ �γ�״̬��0���Ѿ�������1�������ϿΣ�2�ǻ�δ���Σ�3�����пγ�
	 * @return
	 */
	public static ArrayList<CourseBean> getCoursesByTeacherID(int teacherID,
			int status) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = { teacherID };
		String curTime = util.Time.getDate();
		String sql = "";
		try {
			if (status == 0) {
				ArrayList<CourseBean> candidates = getCoursesByTeacherID(
						teacherID, 3);
				for (CourseBean course : candidates) {
					if (Time.dateAddDay(course.getStartDate(),
							course.getWeeks() * 7).compareTo(curTime) < 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 1) {
				ArrayList<CourseBean> candidates = getCoursesByTeacherID(
						teacherID, 3);
				for (CourseBean course : candidates) {
					if (course.getStartDate().compareTo(curTime) < 0
							&& Time.dateAddDay(course.getStartDate(),
									course.getWeeks() * 7).compareTo(curTime) > 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 2) {
				params = new Object[] { teacherID, curTime };
				sql = "select * from courses where teacherID = ? and startDate > ?";
			} else if (status == 3) {
				sql = "select * from courses where teacherID = ?";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("�Ƿ�״̬��statusֻ����0,1,2,3");
			e.printStackTrace();
		}
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriodID(rs.getString("periodID"));
				course.setWeeks(rs.getInt("weeks"));
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

	/**
	 * �����������ҿγ�
	 * 
	 * @param instrument
	 *            ����
	 * @param status
	 *            �γ�״̬��0���Ѿ�������1�������ϿΣ�2�ǻ�δ���Σ�3�����пγ�
	 * @return
	 */
	public static ArrayList<CourseBean> getCoursesByInstrument(
			String instrument, int status) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = { instrument };
		String curTime = util.Time.getDate();
		String sql = "";
		try {
			if (status == 0) {
				ArrayList<CourseBean> candidates = getCoursesByInstrument(
						instrument, 3);
				for (CourseBean course : candidates) {
					if (Time.dateAddDay(course.getStartDate(),
							course.getWeeks() * 7).compareTo(curTime) < 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 1) {
				ArrayList<CourseBean> candidates = getCoursesByInstrument(
						instrument, 3);
				for (CourseBean course : candidates) {
					if (course.getStartDate().compareTo(curTime) < 0
							&& Time.dateAddDay(course.getStartDate(),
									course.getWeeks() * 7).compareTo(curTime) > 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 2) {
				params = new Object[] { instrument, curTime };
				sql = "select * from courses where instrument = ? and startDate > ?";
			} else if (status == 3) {
				sql = "select * from courses where instrument = ?";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("�Ƿ�״̬��statusֻ����0,1,2,3");
			e.printStackTrace();
		}
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriodID(rs.getString("periodID"));
				course.setWeeks(rs.getInt("weeks"));
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

	/**
	 * ���ݿγ����Ͳ��ҿγ�
	 * 
	 * @param type
	 *            �γ�����
	 * @param status
	 *            �γ�״̬��0���Ѿ�������1�������ϿΣ�2�ǻ�δ���Σ�3�����пγ�
	 * @return
	 */
	public static ArrayList<CourseBean> getCoursesByType(String type, int status) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		Object params[] = { type };
		String curTime = util.Time.getDate();
		String sql = "";
		try {
			if (status == 0) {
				ArrayList<CourseBean> candidates = getCoursesByType(type, 3);
				for (CourseBean course : candidates) {
					if (Time.dateAddDay(course.getStartDate(),
							course.getWeeks() * 7).compareTo(curTime) < 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 1) {
				ArrayList<CourseBean> candidates = getCoursesByType(type, 3);
				for (CourseBean course : candidates) {
					if (course.getStartDate().compareTo(curTime) < 0
							&& Time.dateAddDay(course.getStartDate(),
									course.getWeeks() * 7).compareTo(curTime) > 0) {
						courses.add(course);
					}
				}
				return courses;
			} else if (status == 2) {
				params = new Object[] { type, curTime };
				sql = "select * from courses where type = ? and startDate > ?";
			} else if (status == 3) {
				sql = "select * from courses where type = ?";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("�Ƿ�״̬��statusֻ����0,1,2,3");
			e.printStackTrace();
		}
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CourseBean course = new CourseBean();
				course.setCourseID(rs.getInt("courseID"));
				course.setTeacherID(rs.getInt("teacherID"));
				course.setStartDate(rs.getString("startDate"));
				course.setPeriodID(rs.getString("periodID"));
				course.setWeeks(rs.getInt("weeks"));
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

	/**
	 * ���ݿ������ڲ��ҿγ�
	 * 
	 * @param startDate
	 *            �����Ͻ�
	 * @param endDate
	 *            �����½�
	 * @return ����ָ�������ڿ��ε����пγ�
	 */
	public static ArrayList<CourseBean> getCoursesByTime(String startDate,
			String endDate) {
		ArrayList<CourseBean> courses = new ArrayList<>();
		String minDate = "00000000";
		String maxDate = "99999999";

		if (startDate == null) {
			startDate = minDate;
		}
		if (endDate == null) {
			endDate = maxDate;
		}

		Object params[] = { startDate, endDate };
		String sql = "select * from course where startDate >= ? and startDate <= ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		return courses;
	}

	public static void main(String[] args) {

	}

}
