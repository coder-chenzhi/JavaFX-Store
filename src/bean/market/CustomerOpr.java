package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Time;
import database.DataBaseIO;

public class CustomerOpr {
	static DataBaseIO db = new DataBaseIO();

	public static int getNextCustomerID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(customerID) as maxID from customers";
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

	public static void insertCustomer(CustomerBean newCustomer) {
		Object params[] = { CustomerOpr.getNextCustomerID(),
				newCustomer.getCustomerName(), newCustomer.getContactName(),
				newCustomer.getContactPhone(), newCustomer.getContactAdress(),
				newCustomer.getOther() };
		String sql = "insert into customers (customerID, customerName, contactName, contactAdress, contactPhone, other) values (?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void updateCustomer(CustomerBean newCustomer) {
		Object params[] = { newCustomer.getCustomerName(),
				newCustomer.getContactName(),
				newCustomer.getContactAdress(), newCustomer.getContactPhone(),
				newCustomer.getOther(), newCustomer.getCustomerID() };
		String sql = "update customers set customerName = ?, contactName = ?, contactAdress = ?, contactPhone = ?, other = ? where customerID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static CustomerBean getCustomerByID(int customerID) {
		CustomerBean customer = new CustomerBean();
		Object params[] = { customerID };
		String sql = "select * from customers where customerID = ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				customer.setCustomerID(rs.getInt("customerID"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactName(rs.getString("contactName"));
				customer.setContactAdress(rs.getString("contactAdress"));
				customer.setContactPhone(rs.getString("contactPhone"));
				customer.setOther(rs.getString("other"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return customer;
	}

	public static ArrayList<CustomerBean> getCustomerByName(String customerName) {
		ArrayList<CustomerBean> customers = new ArrayList<>();
		
		Object params[] = { "%" + customerName + "%"};
		String sql = "select * from customers where customerName like ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomerID(rs.getInt("customerID"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactName(rs.getString("contactName"));
				customer.setContactAdress(rs.getString("contactAdress"));
				customer.setContactPhone(rs.getString("contactPhone"));
				customer.setOther(rs.getString("other"));
				customers.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return customers;
	}

	public static ArrayList<CustomerBean> getAllCustomers() {
		ArrayList<CustomerBean> customers = new ArrayList<>();
		Object params[] = {};
		String sql = "select * from customers";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setCustomerID(rs.getInt("customerID"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactName(rs.getString("contactName"));
				customer.setContactAdress(rs.getString("contactAdress"));
				customer.setContactPhone(rs.getString("contactPhone"));
				customer.setOther(rs.getString("other"));
				customers.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return customers;
	}

	public static void main(String[] args) {
		System.out.println(getNextCustomerID());
	}
}
