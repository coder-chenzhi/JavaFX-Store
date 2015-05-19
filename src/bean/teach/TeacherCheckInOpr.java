package bean.teach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;
import util.Time;

public class TeacherCheckInOpr {
	static DataBaseIO db = new DataBaseIO();
	
	/**
	 * �����µĴ򿨼�¼
	 * @param record ����Ϣ
	 */
	public static void insertRecord(TeacherCheckInBean record) {
		Object params[] = { record.getTeacherID(), record.getCheckDate(),
				record.getCheckTime(), record.getType() };
		String sql = "insert into teacherCheckIn "
				+ "(teacherID, checkDate, checkTime, Type) values(?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	
	/**
	 * ����ĳһ��ʦĳһʱ��εĴ򿨼�¼
	 * @param teacherID ��ʦID
	 * @return ĳһ��ʦĳһʱ��εĴ򿨼�¼
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
	 * ĳ��ʦ�����һ���򿨼�¼����ȷ�����Ƿ�淶
	 * ����Ӧ�ô��ϰ�Ŀ���������°�Ŀ��������¼֮ǰҪ��ʾ
	 * @param teacherID ��ʦID
	 * @return ���һ���򿨼�¼
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
	 * @param id ��ʦ����
	 * @return ���ؽ�ʦ�����д򿨼�¼
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
	 * @return �������н�ʦ�����д򿨼�¼
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
		record.setType("�ϰ�");
		TeacherCheckInOpr.insertRecord(record);*/
		System.out.println(TeacherCheckInOpr.getRecordByIDAndTime("001", "20140101", null, "20150330", null));
	}
}
