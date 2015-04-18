package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class PeriodOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insertPeriod(PeriodBean period) {
		Object params[] = { period.getPeriodID(), period.getStartTime(),
				period.getEndTime() };
		String sql = "insert into periods (periodID, startTime, endTime) value (?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static ArrayList<PeriodBean> getAllPeriods() {
		ArrayList<PeriodBean> periods = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from periods";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				PeriodBean period = new PeriodBean();
				period.setPeriodID(rs.getString("periodID"));
				period.setStartTime(rs.getString("startTime"));
				period.setEndTime(rs.getString("endTime"));
				periods.add(period);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return periods;
	}

	public static PeriodBean getPeriodByID(String periodID) {
		PeriodBean period = new PeriodBean();
		Object params[] = {periodID};
		String sql = "select * from periods where periodID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				period.setPeriodID(rs.getString("periodID"));
				period.setStartTime(rs.getString("startTime"));
				period.setEndTime(rs.getString("endTime"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return period;
	}
	
	public static void updatePeriod(String periodID, PeriodBean period) {
		Object params[] = { period.getPeriodID(), period.getStartTime(),
				period.getEndTime(), periodID };
		String sql = "update periods set periodID=?, startTime=?, endTime=? where periodID=?";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void main(String[] args) {
		
	}
}
