package bean.market;

/*
 CREATE TABLE Suppliers (
 supplierID INT,
 supplierName VARCHAR(255) UNIQUE,
 contactName Text,
 contactAddress Text,
 contactPhone Text,
 other Text,
 PRIMARY KEY (supplierID)
 );
 */

public class SupplierBean {
	private int supplierID;
	private String supplierName;
	private String contactName;
	private String contactAddress;
	private String contactPhone;
	private String other;

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "SupplierBean [supplierID=" + supplierID + ", supplierName="
				+ supplierName + ", contactName=" + contactName
				+ ", contactAddress=" + contactAddress + ", contactPhone="
				+ contactPhone + ", other=" + other + "]\n";
	}

}
