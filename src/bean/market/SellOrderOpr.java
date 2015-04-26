package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

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

	public static void insertSellOrder(SellOrderBean sellOrder) {
		Object params[] = { sellOrder.getOrderID(), sellOrder.getGoodID(),
				sellOrder.getCustomerID(), sellOrder.getAmount(),
				sellOrder.getPrice(), sellOrder.getCommitDate(),
				sellOrder.getStatus(), sellOrder.getOther() };
		String sql = "insert into SellOrders values(?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void deleteSellOrder(int orderID) {
		Object params[] = { orderID };
		String sql = "delete from SellOrders where orderID = ?";
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
				sellOrder.setOrderID(String.valueOf(rs.getInt("orderID")));
				sellOrder.setGoodID(String.valueOf(rs.getInt("goodID")));
				sellOrder
						.setCustomerID(String.valueOf(rs.getInt("customerID")));
				sellOrder.setAmount(String.valueOf(rs.getInt("amount")));
				sellOrder.setPrice(String.valueOf(rs.getInt("price")));
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

	public static ArrayList<SellOrderBean> getByID(int orderID) {
		ArrayList<SellOrderBean> sellOrders = new ArrayList<>();
		Object[] params = { orderID };
		String sql = "select * from SellOrders where orderID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				SellOrderBean sellOrder = new SellOrderBean();
				sellOrder.setOrderID(String.valueOf(rs.getInt("orderID")));
				sellOrder.setGoodID(String.valueOf(rs.getInt("goodID")));
				sellOrder
						.setCustomerID(String.valueOf(rs.getInt("customerID")));
				sellOrder.setAmount(String.valueOf(rs.getInt("amount")));
				sellOrder.setPrice(String.valueOf(rs.getInt("price")));
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

	public static int getTotalCost(int orderID) {
		int totalCost = 0;
		Object[] params = { orderID };
		String sql = "select amount, price from SellOrders where orderID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				totalCost += rs.getInt("amount") * rs.getInt("price");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return totalCost;
	}
	
	public static TreeSet<Integer> getUniqueID() {
		TreeSet<Integer> uniqueIDs = new TreeSet<>();
		Object[] params = {};
		String sql = "select distinct orderID from SellOrders";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				uniqueIDs.add(rs.getInt("orderID"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return uniqueIDs;
	}

}
