package bean.market;

/**
 * 
 * @author chenzhi CREATE TABLE SellOrder ( orderID INT, goodID INT,
 *         supplierID INT, amount INT, price INT, commitDate VARCHAR(8), status
 *         Text, PRIMARY KEY (orderID, goodID, supplierID) );
 */

public class SellOrderBean {
	private String orderID;
	private String goodID;
	private String customerID;
	private String amount;
	private String price;
	private String commitDate;
	private String status;
	private String other;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getGoodID() {
		return goodID;
	}

	public void setGoodID(String goodID) {
		this.goodID = goodID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(String commitDate) {
		this.commitDate = commitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SellOrderBean [orderID=" + orderID + ", goodID=" + goodID
				+ ", supplierID=" + customerID + ", amount=" + amount
				+ ", price=" + price + ", commitDate=" + commitDate
				+ ", status=" + status + "]\n";
	}

}
