package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBaseIO;

public class StocksOpr {
	static DataBaseIO db = new DataBaseIO();
	
	public static boolean isExist(int goodID) {
		boolean status = false;
		Object[] params = { goodID };
		String sql = "select * from stocks where goodID = ?";
		
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				if(rs.getInt("goodID") == goodID) {
					status = true;
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return status;
	}
	
	
	public static void insert(StockBean stock) {
		Object[] params = { stock.getGoodID(), stock.getAmount() };
		String sql = "insert into stocks values(?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void insert(int goodID, int amount) {
		Object[] params = { goodID, amount };
		String sql = "insert into stocks values(?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static int getAmountByID(int goodID) {
		int amount = 0;
		Object[] params = { goodID };
		String sql = "select amount from stocks where goodID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		
		try {
			while (rs.next()) {
				amount = rs.getInt("amount");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		
		return amount;
	}
	
	public static ArrayList<StockBean> getAllStcoks() {
		ArrayList<StockBean> stocks = new ArrayList<>();
		Object[] params = {};
		String sql = "select * from stocks";
		
		ResultSet rs = db.executeSqlWithResult(sql, params);
		
		try {
			while (rs.next()) {
				StockBean stock  = new StockBean();
				stock.setGoodID(rs.getInt("goodID"));
				stock.setAmount(rs.getInt("amount"));
				stocks.add(stock);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return stocks;
	}
	
	public static void add(int goodID, int amount) {
		if (isExist(goodID)) {
			int nowAmount = getAmountByID(goodID) + amount;
			Object[] params = {nowAmount, goodID};
			String sql  = "update stocks set amount = ? where goodID = ?";
			db.executeSqlWithoutResult(sql, params);
		} else {
			insert(goodID, amount);
		}
	}
	
	public static void minus(int goodID, int amount) {
		int nowAmount = getAmountByID(goodID) - amount;
		Object[] params = {nowAmount, goodID};
		String sql  = "update stocks set amount = ? where goodID = ?";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void main(String[] args) {
		System.out.println(StocksOpr.isExist(20150001));
		System.out.println(StocksOpr.getAmountByID(20150001));
	}
}
