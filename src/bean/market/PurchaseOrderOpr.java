package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import util.Time;
import database.DataBaseIO;

public class PurchaseOrderOpr {
	static DataBaseIO db = new DataBaseIO();

	public static int getNextPurchaseOrderID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(orderID) as maxID from PurchaseOrders";
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

	public static void insertPurchaseOrder(PurchaseOrderBean purchaseOrder) {
		Object params[] = { purchaseOrder.getOrderID(),
				purchaseOrder.getGoodID(), purchaseOrder.getSupplierID(),
				purchaseOrder.getAmount(), purchaseOrder.getPrice(),
				purchaseOrder.getCommitDate(), purchaseOrder.getStatus(),
				purchaseOrder.getOther() };
		String sql = "insert into PurchaseOrders values(?,?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static void deletePurchaseOrder(int orderID) {
		Object params[] = { orderID };
		String sql = "delete from PurchaseOrders where orderID = ?";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static ArrayList<PurchaseOrderBean> getAll() {
		ArrayList<PurchaseOrderBean> purchaseOrders = new ArrayList<>();
		Object[] params = {};
		String sql = "select * from PurchaseOrders";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				PurchaseOrderBean purchaseOrder = new PurchaseOrderBean();
				purchaseOrder.setOrderID(String.valueOf(rs.getInt("orderID")));
				purchaseOrder.setGoodID(String.valueOf(rs.getInt("goodID")));
				purchaseOrder.setSupplierID(String.valueOf(rs.getInt("supplierID")));
				purchaseOrder.setAmount(String.valueOf(rs.getInt("amount")));
				purchaseOrder.setPrice(String.valueOf(rs.getInt("price")));
				purchaseOrder.setCommitDate(rs.getString("commitDate"));
				purchaseOrder.setStatus(rs.getString("status"));
				purchaseOrders.add(purchaseOrder);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return purchaseOrders;
	}
	
	public static ArrayList<PurchaseOrderBean> getByID(int orderID) {
		ArrayList<PurchaseOrderBean> purchaseOrders = new ArrayList<>();
		Object[] params = { orderID };
		String sql = "select * from PurchaseOrders where orderID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				PurchaseOrderBean purchaseOrder = new PurchaseOrderBean();
				purchaseOrder.setOrderID(String.valueOf(rs.getInt("orderID")));
				purchaseOrder.setGoodID(String.valueOf(rs.getInt("goodID")));
				purchaseOrder.setSupplierID(String.valueOf(rs.getInt("supplierID")));
				purchaseOrder.setAmount(String.valueOf(rs.getInt("amount")));
				purchaseOrder.setPrice(String.valueOf(rs.getInt("price")));
				purchaseOrder.setCommitDate(rs.getString("commitDate"));
				purchaseOrder.setStatus(rs.getString("status"));
				purchaseOrders.add(purchaseOrder);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return purchaseOrders;
	}
	
	public static TreeSet<Integer> getUniqueID() {
		TreeSet<Integer> uniqueIDs = new TreeSet<>();
		Object[] params = {};
		String sql = "select distinct orderID from PurchaseOrders";
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
	
	public static int getTotalCost(int orderID) {
		int totalCost = 0;
		Object[] params = {orderID};
		String sql = "select amount, price from PurchaseOrders where orderID = ?";
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
	
	public static void main(String[] args) {
		System.out.println(PurchaseOrderOpr.getTotalCost(20150001));
		System.out.println(PurchaseOrderOpr.getUniqueID());
	}
	
}
