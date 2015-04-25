package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public static void insertPurchaseOrder(PurchaseOrderBean purchaseOrder) {
		Object params[] = { getNextPurchaseOrderID(),
				purchaseOrder.getGoodID(), purchaseOrder.getSupplierID(),
				purchaseOrder.getAmount(), purchaseOrder.getPrice(),
				purchaseOrder.getCommitDate(), purchaseOrder.getStatus(),
				purchaseOrder.getOther() };
		String sql = "insert into PurchaseOrders values(?,?,?,?,?,?,?,?)";
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
				purchaseOrder.setOrderID(rs.getInt("orderID"));
				purchaseOrder.setGoodID(rs.getInt("goodID"));
				purchaseOrder.setSupplierID(rs.getInt("supplierID"));
				purchaseOrder.setAmount(rs.getInt("amount"));
				purchaseOrder.setPrice(rs.getInt("price"));
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
	
	public static PurchaseOrderBean getbyID(int orderID) {
		PurchaseOrderBean purchaseOrder = new PurchaseOrderBean();
		Object[] params = {orderID};
		String sql = "select * from PurchaseOrders where orderID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				purchaseOrder.setOrderID(rs.getInt("orderID"));
				purchaseOrder.setGoodID(rs.getInt("goodID"));
				purchaseOrder.setSupplierID(rs.getInt("supplierID"));
				purchaseOrder.setAmount(rs.getInt("amount"));
				purchaseOrder.setPrice(rs.getInt("price"));
				purchaseOrder.setCommitDate(rs.getString("commitDate"));
				purchaseOrder.setStatus(rs.getString("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return purchaseOrder;
	}
	
}
