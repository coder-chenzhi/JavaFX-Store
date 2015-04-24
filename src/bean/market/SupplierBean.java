package bean.market;

/*
 CREATE TABLE Suppliers (
 supplierID INT,
 supplierName VARCHAR(255) UNIQUE,
 contactName Text,
 contactAdress Text,
 contactPhone Text,
 other Text,
 PRIMARY KEY (supplierID)
 );
 */

public class SupplierBean {
	private int supplierID;
	private String supplierName;
	private String contactName;
	private String contactAdress;
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

	public String getContactAdress() {
		return contactAdress;
	}

	public void setContactAdress(String contactAdress) {
		this.contactAdress = contactAdress;
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
				+ ", contactAdress=" + contactAdress + ", contactPhone="
				+ contactPhone + ", other=" + other + "]\n";
	}

}
