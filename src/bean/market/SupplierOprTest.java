package bean.market;

import util.Generator;

public class SupplierOprTest {
	public static void testInsert() {
		SupplierBean supplier = new SupplierBean();
		supplier.setSupplierName(Generator.nameGenerator());
		SupplierOpr.insertSupplier(supplier);
	}
	
	public static void testGetAll() {
		System.out.println(SupplierOpr.getAllSuppliers());
	}
	
	public static void testGetByID(int supplierID) {
		System.out.println(SupplierOpr.getSupplierByID(supplierID));
	}
	
	public static void testGetByName(String supplierName) {
		System.out.println(SupplierOpr.getSupplierByName(supplierName));
	}
	
	public static void testUpdate() {
		SupplierBean supplier = SupplierOpr.getSupplierByID(2015002);
		supplier.setSupplierName("�ൺ�����������˾");
		SupplierOpr.updateSupplier(supplier);
	}
	
	public static void main(String[] args) {
		//SupplierOprTest.testInsert();
		//SupplierOprTest.testGetAll();
		//SupplierOprTest.testGetByID(2015001);
		SupplierOprTest.testGetByName("�ൺ");
		//SupplierOprTest.testGetAll();
		//SupplierOprTest.testUpdate();
		//SupplierOprTest.testGetAll();
	}
}
