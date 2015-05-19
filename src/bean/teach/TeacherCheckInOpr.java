package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;
import util.Time;

public class TeacherCheckInOpr {
	static DataBaseIO db = new DataBaseIO();
	
	/**
	 * 插入新的打卡记录
	 * @param record 打卡信息
	 */
	public static void insertRecord(TeacherCheckInBean record) {
		Object params[] = { record.getTeacherID(), record.getCheckDate(),
				record.getCheckTime(), record.getType() };
		String sql = "insert into teacherCheckIn "
				+ "(teacherID, checkDate, checkTime, Type) values(?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	
	/**
	 * 返回某一教师某一时间段的打卡记录
	 * @param teacherID 教师ID
	 * @return 某一教师某一时间段的打卡记录
	 */
	public static ArrayList<TeacherCheckInBean> getRecordByIDAndTime(String teacherID, 
			String startDate, String startTime, String endDate, String endTime) {
		
		String minDate = "00000000";
		String minTime = "000000";
		String maxDate = "99999999";
		String maxTime = "999999";
		
		ArrayList<TeacherCheckInBean> records = new ArrayList<TeacherCheckInBean>();
		
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
		
		Object params[] = {teacherID ,startDate, startTime, endDate, endTime};
		String sql = "select * from teacherCheckIn where teacherID = ? "
				+ "and checkDate >= ? and checkTime >= ? and checkDate <= ? and checkTime <= ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				TeacherCheckInBean record = new TeacherCheckInBean();
				record.setTeacherID(rs.getInt("teacherID"));
				record.setCheckDate(rs.getString("CheckDate"));
				record.setCheckTime(rs.getString("CheckTime"));
				record.setType(rs.getString("Type"));
				records.add(record);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return records;
	}
	
	/**
	 * 某教师最近的一条打卡记录，以确定打卡是否规范
	 * 比如应该打上班的卡，误打了下班的卡，插入记录之前要提示
	 * @param teacherID 教师ID
	 * @return 最近一条打卡记录
	 */
	public static TeacherCheckInBean getLastRecordByID(int teacherID) {
		TeacherCheckInBean record = new TeacherCheckInBean();
		
		Object params[] = {teacherID};
		String sql = "select * from teacherCheckIn where teacherID=? "
				+ "order by checkDate desc, checkTime desc limit 1";
		
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				record.setTeacherID(rs.getInt("teacherID"));
				record.setCheckDate(rs.getString("CheckDate"));
				record.setCheckTime(rs.getString("CheckTime"));
				record.setType(rs.getString("Type"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return record;
	}
	
	/**
	 * 
	 * @param id 教师工号
	 * @return 返回教师的所有打卡记录
	 */
	public static ArrayList<TeacherCheckInBean> getRecordByID(String id) {
		ArrayList<TeacherCheckInBean> records = new ArrayList<TeacherCheckInBean>();
		
		Object params[] = {id};
		String sql = "select * from teacherCheckIn where teacherID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				TeacherCheckInBean record = new TeacherCheckInBean();
				record.setTeacherID(rs.getInt("teacherID"));
				record.setCheckDate(rs.getString("CheckDate"));
				record.setCheckTime(rs.getString("CheckTime"));
				record.setType(rs.getString("Type"));
				records.add(record);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return records;
	}
	
	/**
	 * 
	 * @return 返回所有教师的所有打卡记录
	 */
	public static ArrayList<TeacherCheckInBean> getAllRecord() {
		ArrayList<TeacherCheckInBean> records = new ArrayList<TeacherCheckInBean>();
		
		Object params[] = {};
		String sql = "select * from teacherCheckIn";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				TeacherCheckInBean record = new TeacherCheckInBean();
				record.setTeacherID(rs.getInt("teacherID"));
				record.setCheckDate(rs.getString("CheckDate"));
				record.setCheckTime(rs.getString("CheckTime"));
				record.setType(rs.getString("Type"));
				records.add(record);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return records;
	}
	
	public static void main(String[] args) {
		/*TeacherCheckInBean record = new TeacherCheckInBean();
		record.setTeacherID("001");
		record.setCheckDate(Time.getDate());
		record.setCheckTime(Time.getTime());
		record.setType("上班");
		TeacherCheckInOpr.insertRecord(record);*/
		System.out.println(TeacherCheckInOpr.getRecordByIDAndTime("001", "20140101", null, "20150330", null));
	}
}
