package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class StudentLeaveOutOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insert(StudentLeaveOutBean bean) {
		Object params[] = { bean.getStudentID(), bean.getStartDate(),
				bean.getStartTime(), bean.getEndDate(), bean.getEndTime(),
				bean.getOther() };
		String sql = "insert into StudentLeaveOut (studentID, startDate,"
				+ "startTime, endDate, endTime, other) values (?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static ArrayList<StudentLeaveOutBean> getAll() {
		ArrayList<StudentLeaveOutBean> beans = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from StudentLeaveOut";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				StudentLeaveOutBean bean = new StudentLeaveOutBean();
				bean.setStudentID(rs.getInt("studentID"));
				bean.setStartDate(rs.getString("startDate"));
				bean.setStartTime(rs.getString("startTime"));
				bean.setEndDate(rs.getString("endDate"));
				bean.setEndTime(rs.getString("endTime"));
				bean.setOther(rs.getString("other"));
				beans.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return beans;
	}

	public static void main(String[] args) {

		StudentLeaveOutBean bean = new StudentLeaveOutBean();
		bean.setStudentID(20150001);
		bean.setStartDate("20150101");
		bean.setStartTime("1000");
		bean.setEndDate("20150107");
		bean.setEndTime("1000");
		bean.setOther("hehe");
		//StudentLeaveOutOpr.insert(bean);
		System.out.println(StudentLeaveOutOpr.getAll());

		// TeacherLeaveOutOpr.deleteAll();
	}

}
