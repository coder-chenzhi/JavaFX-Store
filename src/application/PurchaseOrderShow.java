package application;

import java.util.ArrayList;

import bean.market.PurchaseOrderBean;
import bean.market.PurchaseOrderOpr;

public class PurchaseOrderShow {
	private String orderID;
	private String supplierID;
	private String totalCost;
	private String commitDate;
	private String other;

	public PurchaseOrderShow(PurchaseOrderBean order) {
		this.setOrderID(order.getOrderID());
		this.setSupplierID(order.getSupplierID());
		this.setCommitDate(order.getCommitDate());
		this.setTotalCost(String.valueOf(PurchaseOrderOpr.getTotalCost(Integer
				.parseInt(order.getOrderID()))));
	}

	public PurchaseOrderShow(int orderID) {
		ArrayList<PurchaseOrderBean> items = PurchaseOrderOpr.getByID(orderID);
		int totalCost = 0;
		this.setOrderID(String.valueOf(orderID));

		this.setSupplierID(items.get(0).getSupplierID());
		this.setCommitDate(items.get(0).getCommitDate());
		for (PurchaseOrderBean item : items) {
			totalCost += Integer.parseInt(item.getPrice())
					* Integer.parseInt(item.getAmount());
		}
		this.setTotalCost(String.valueOf(totalCost));
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

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
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
