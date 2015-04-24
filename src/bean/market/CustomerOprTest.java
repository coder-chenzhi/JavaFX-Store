package bean.market;

import util.Generator;

public class CustomerOprTest {
	public static void testInsert() {
		CustomerBean customer = new CustomerBean();
		customer.setCustomerName(Generator.nameGenerator());
		CustomerOpr.insertCustomer(customer);
	}
	
	public static void testGetAll() {
		System.out.println(CustomerOpr.getAllCustomers());
	}
	
	public static void testGetByID(int customerID) {
		System.out.println(CustomerOpr.getCustomerByID(customerID));
	}
	
	public static void testGetByName(String customerName) {
		System.out.println(CustomerOpr.getCustomerByName(customerName));
	}
	
	public static void testUpdate() {
		CustomerBean customer = CustomerOpr.getCustomerByID(20150003);
		customer.setContactName("∫«∫«");
		customer.setContactPhone("");
		customer.setContactAdress("«‡µ∫ –");
		CustomerOpr.updateCustomer(customer);
	}
	
	public static void main(String[] args) {
		CustomerOprTest.testInsert();
		//CustomerOprTest.testGetAll();
		//CustomerOprTest.testGetByID(20150002);
		CustomerOprTest.testGetByName("’‘");
		//CustomerOprTest.testGetAll();
		//CustomerOprTest.testUpdate();
		//CustomerOprTest.testGetAll();
	}
}
