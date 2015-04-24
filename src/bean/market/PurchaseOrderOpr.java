package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
