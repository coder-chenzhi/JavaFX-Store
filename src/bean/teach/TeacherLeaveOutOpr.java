package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class TeacherLeaveOutOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insert(TeacherLeaveOutBean bean) {
		Object params[] = {bean.getTeacherID(), bean.getStartDate(), bean.getStartTime(),
				bean.getEndDate(), bean.getEndTime(), bean.getOther()};
		String sql = "insert into TeacherLeaveOut (teacherID, startDate,"
				+ "startTime, endDate, endTime, other) values (?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void deleteAll() {
		Object params[] = {};
		String sql = "delete from TeacherLeaveOut";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static ArrayList<TeacherLeaveOutBean> getAll() {
		ArrayList<TeacherLeaveOutBean> beans = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from TeacherLeaveOut";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				TeacherLeaveOutBean bean = new TeacherLeaveOutBean();
				bean.setTeacherID(rs.getInt("teacherID"));
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
		
		TeacherLeaveOutBean bean = new TeacherLeaveOutBean();
		bean.setTeacherID(20150001);
		bean.setStartDate("20150101");
		bean.setStartTime("1000");
		bean.setEndDate("20150107");
		bean.setEndTime("1000");
		bean.setOther("hehe");
		TeacherLeaveOutOpr.insert(bean);
		System.out.println(TeacherLeaveOutOpr.getAll());
		
		//TeacherLeaveOutOpr.deleteAll();
	}
}
