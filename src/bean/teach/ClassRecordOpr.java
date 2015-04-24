package bean.teach;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.DataBaseIO;

public class ClassRecordOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * 选课时，课程有几周，就需要增加相应的数量的课程记录
	 * 
	 * @param record
	 */
	public static void insertRecord(ClassRecordBean record) {
		Object params[] = { record.getCourseID(), record.getClassID(),
				record.getStudentID(), record.getStatus() };
		String sql = "insert into ClassRecords (courseID, classID, studentID, status) values (?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void deleteRecord(int courseID, int classID, int studentID) {
		Object params[] = { courseID, classID, studentID };
		String sql = "delete from ClassRecords where courseID = ? and classID = ? and studentID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	/**
	 * 批量设置某一课时所有未请假同学的上课状态，从“课时未开始”改为“已上课”
	 * @param courseID
	 * @param classID
	 */
	public static void checkIn(int courseID, int classID) {
		Object params[] = { courseID, classID };
		String sql = "update classRecords set status = '已上课' where courseID = ? and classID = ? and status = '课时未开始'";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void checkOut(int courseID, int classID, int studentID) {
		Object params[] = { courseID, classID, studentID };
		String sql = "update classRecords set status = '请假' where courseID = ? and classID = ? and studentID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void clear() {
		Object params[] = {};
		String sql = "delete from ClassRecords";
		db.executeSqlWithoutResult(sql, params);
	}

	public static ArrayList<ClassRecordBean> getAllRecords() {
		ArrayList<ClassRecordBean> records = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from classRecords";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				ClassRecordBean record = new ClassRecordBean();
				record.setCourseID(rs.getInt("CourseID"));
				record.setClassID(rs.getInt("ClassID"));
				record.setStudentID(rs.getInt("StudentID"));
				record.setStatus(rs.getString("Status"));
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return records;
	}

	/**
	 * 查找某一课程某一课时的选课记录
	 * @param courseID
	 * @param classID
	 * @return
	 */
	public static ArrayList<ClassRecordBean> getAllReordsByClass(int courseID,
			int classID) {
		ArrayList<ClassRecordBean> records = new ArrayList<>();
		Object params[] = { courseID, classID };
		String sql = "select * from classRecords where courseID = ? and classID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				ClassRecordBean record = new ClassRecordBean();
				record.setCourseID(rs.getInt("CourseID"));
				record.setClassID(rs.getInt("ClassID"));
				record.setStudentID(rs.getInt("StudentID"));
				record.setStatus(rs.getString("Status"));
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return records;
	}

	/**
	 * 某一学生的所有选课记录
	 * @param studentID
	 * @return 所选课程的ID
	 */
	public static ArrayList<Integer> getAllCourseByStudentID(int studentID) {
		ArrayList<Integer> records = new ArrayList<>();
		Object params[] = { studentID };
		String sql = "select distinct courseID from classRecords where studentID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				records.add(rs.getInt("courseID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return records;
	}
}
