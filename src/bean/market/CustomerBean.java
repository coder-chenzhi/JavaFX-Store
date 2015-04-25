package bean.market;
/*
   CREATE TABLE Customers (
	customerID INT,
	customerName VARCHAR(255) UNIQUE,
	contactName Text,
	contactAddress Text,
	contactPhone Text,
	other Text,
	PRIMARY KEY (customerID)
);
 */


public class CustomerBean {
	private int customerID;
	private String customerName;
	private String contactName;
	private String contactAddress;
	private String contactPhone;
	private String other;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		return "CustomerBean [customerID=" + customerID + ", customerName="
				+ customerName + ", contactName=" + contactName
				+ ", contactAddress=" + contactAddress + ", contactPhone="
				+ contactPhone + ", other=" + other + "]\n";
	}
	
}
