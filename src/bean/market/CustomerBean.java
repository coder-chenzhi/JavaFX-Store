package bean.market;
/*
   CREATE TABLE Customers (
	customerID INT,
	customerName VARCHAR(255) UNIQUE,
	contactName Text,
	contactAdress Text,
	contactPhone Text,
	other Text,
	PRIMARY KEY (customerID)
);
 */


public class CustomerBean {
	private int customerID;
	private String customerName;
	private String contactName;
	private String contactAdress;
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
		return "CustomerBean [customerID=" + customerID + ", customerName="
				+ customerName + ", contactName=" + contactName
				+ ", contactAdress=" + contactAdress + ", contactPhone="
				+ contactPhone + ", other=" + other + "]\n";
	}
	
}
