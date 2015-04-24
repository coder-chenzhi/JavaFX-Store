package bean.market;

/**
 * 
 * @author chenzhi CREATE TABLE PurchaseOrder ( orderID INT, goodID INT,
 *         supplierID INT, amount INT, price INT, commitDate VARCHAR(8), status
 *         Text, PRIMARY KEY (orderID, goodID, supplierID) );
 */

public class PurchaseOrderBean {
	private int orderID;
	private int goodID;
	private int supplierID;
	private int amount;
	private int price;
	private String commitDate;
	private String status;
	private String other;

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
		return "PurchaseOrderBean [orderID=" + orderID + ", goodID=" + goodID
				+ ", supplierID=" + supplierID + ", amount=" + amount
				+ ", price=" + price + ", commitDate=" + commitDate
				+ ", status=" + status + "]\n";
	}

}
