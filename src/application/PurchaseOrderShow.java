package application;

import bean.market.PurchaseOrderBean;
import bean.market.PurchaseOrderOpr;

public class PurchaseOrderShow {
	private int orderID;
	private int supplierID;
	private int totalCost;
	private String commitDate;
	private String other;
	
	public PurchaseOrderShow(PurchaseOrderBean order) {
		this.setOrderID(order.getOrderID());
		this.setSupplierID(order.getSupplierID());
		this.setCommitDate(order.getCommitDate());
		this.setTotalCost(PurchaseOrderOpr.getTotalCost(order.getOrderID()));
	}
	
	
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

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(String commitDate) {
		this.commitDate = commitDate;
	}


	@Override
	public String toString() {
		return "PurchaseOrderShow [orderID=" + orderID + ", supplierID="
				+ supplierID + ", totalCost=" + totalCost + ", commitDate="
				+ commitDate + ", other=" + other + "]";
	}

}
