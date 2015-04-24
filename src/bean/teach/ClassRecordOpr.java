package bean.teach;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.DataBaseIO;

public class ClassRecordOpr {
	static DataBaseIO db = new DataBaseIO();

	/**
	 * ѡ��ʱ���γ��м��ܣ�����Ҫ������Ӧ�������Ŀγ̼�¼
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
	 * ��������ĳһ��ʱ����δ���ͬѧ���Ͽ�״̬���ӡ���ʱδ��ʼ����Ϊ�����ϿΡ�
	 * @param courseID
	 * @param classID
	 */
	public static void checkIn(int courseID, int classID) {
		Object params[] = { courseID, classID };
		String sql = "update classRecords set status = '���Ͽ�' where courseID = ? and classID = ? and status = '��ʱδ��ʼ'";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void checkOut(int courseID, int classID, int studentID) {
		Object params[] = { courseID, classID, studentID };
		String sql = "update classRecords set status = '���' where courseID = ? and classID = ? and studentID = ?";
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
	 * ����ĳһ�γ�ĳһ��ʱ��ѡ�μ�¼
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
	 * ĳһѧ��������ѡ�μ�¼
	 * @param studentID
	 * @return ��ѡ�γ̵�ID
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
