package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Time;
import database.DataBaseIO;

public class SupplierOpr {
	static DataBaseIO db = new DataBaseIO();

	public static int getNextSupplierID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(supplierID) as maxID from suppliers";
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
		if (id / 1000 == Integer.parseInt(Time.getYear())) {
			id++;
		} else {
			id = Integer.parseInt(Time.getYear()) * 1000 + 1;
		}
		return id;
	}

	public static void insertSupplier(SupplierBean newSupplier) {
		Object params[] = { SupplierOpr.getNextSupplierID(),
				newSupplier.getSupplierName(), newSupplier.getContactName(),
				newSupplier.getContactAddress(), newSupplier.getContactPhone(),
				newSupplier.getOther() };
		String sql = "insert into suppliers (supplierID, supplierName, contactName, contactAddress, contactPhone, other) values (?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void updateSupplier(SupplierBean newSupplier) {
		Object params[] = { newSupplier.getSupplierName(),
				newSupplier.getContactName(), newSupplier.getContactAddress(),
				newSupplier.getContactPhone(), newSupplier.getOther(),
				newSupplier.getSupplierID() };
		String sql = "update suppliers set supplierName = ?, contactName = ?, contactAddress = ?, contactPhone = ?, other = ? where supplierID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static SupplierBean getSupplierByID(int supplierID) {
		SupplierBean supplier = new SupplierBean();
		Object params[] = { supplierID };
		String sql = "select * from suppliers where supplierID = ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				supplier.setSupplierID(rs.getInt("supplierID"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setContactName(rs.getString("contactName"));
				supplier.setContactAddress(rs.getString("contactAddress"));
				supplier.setContactPhone(rs.getString("contactPhone"));
				supplier.setOther(rs.getString("other"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return supplier;
	}

	public static ArrayList<SupplierBean> getSupplierByName(String supplierName) {
		ArrayList<SupplierBean> suppliers = new ArrayList<>();

		Object params[] = { "%" + supplierName + "%" };
		String sql = "select * from suppliers where supplierName like ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				SupplierBean supplier = new SupplierBean();
				supplier.setSupplierID(rs.getInt("supplierID"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setContactName(rs.getString("contactName"));
				supplier.setContactAddress(rs.getString("contactAddress"));
				supplier.setContactPhone(rs.getString("contactPhone"));
				supplier.setOther(rs.getString("other"));
				suppliers.add(supplier);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return suppliers;
	}

	public static ArrayList<SupplierBean> getAllSuppliers() {
		ArrayList<SupplierBean> suppliers = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from suppliers";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				SupplierBean supplier = new SupplierBean();
				supplier.setSupplierID(rs.getInt("supplierID"));
				supplier.setSupplierName(rs.getString("supplierName"));
				supplier.setContactName(rs.getString("contactName"));
				supplier.setContactAddress(rs.getString("contactAddress"));
				supplier.setContactPhone(rs.getString("contactPhone"));
				supplier.setOther(rs.getString("other"));
				suppliers.add(supplier);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return suppliers;
	}

	public static void main(String[] args) {
		System.out.println(getNextSupplierID());
	}
}
