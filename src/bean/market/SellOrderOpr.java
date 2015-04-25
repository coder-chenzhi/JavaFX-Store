package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Time;
import database.DataBaseIO;

public class SellOrderOpr {
	static DataBaseIO db = new DataBaseIO();

	public static int getNextSellOrderID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(orderID) as maxID from SellOrders";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				id = rs.getInt("orderID");
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

	public static void insertSellOrder(SellOrderBean sellOrder) {
		Object params[] = { getNextSellOrderID(),
				sellOrder.getGoodID(), sellOrder.getCustomerID(),
				sellOrder.getAmount(), sellOrder.getPrice(),
				sellOrder.getCommitDate(), sellOrder.getStatus(),
				sellOrder.getOther() };
		String sql = "insert into SellOrders values(?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static ArrayList<SellOrderBean> getAll() {
		ArrayList<SellOrderBean> sellOrders = new ArrayList<>();
		Object[] params = {};
		String sql = "select * from SellOrders";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				SellOrderBean sellOrder = new SellOrderBean();
				sellOrder.setOrderID(rs.getInt("orderID"));
				sellOrder.setGoodID(rs.getInt("goodID"));
				sellOrder.setCustomerID(rs.getInt("customerID"));
				sellOrder.setAmount(rs.getInt("amount"));
				sellOrder.setPrice(rs.getInt("price"));
				sellOrder.setCommitDate(rs.getString("commitDate"));
				sellOrder.setStatus(rs.getString("status"));
				sellOrders.add(sellOrder);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return sellOrders;
	}
	
	public static SellOrderBean getbyID(int orderID) {
		SellOrderBean sellOrder = new SellOrderBean();
		Object[] params = {orderID};
		String sql = "select * from SellOrders where orderID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				sellOrder.setOrderID(rs.getInt("orderID"));
				sellOrder.setGoodID(rs.getInt("goodID"));
				sellOrder.setCustomerID(rs.getInt("customerID"));
				sellOrder.setAmount(rs.getInt("amount"));
				sellOrder.setPrice(rs.getInt("price"));
				sellOrder.setCommitDate(rs.getString("commitDate"));
				sellOrder.setStatus(rs.getString("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return sellOrder;
	}
	
}
