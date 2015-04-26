package application;

import java.util.ArrayList;

import bean.market.SellOrderBean;
import bean.market.SellOrderOpr;

public class SellOrderShow {
	private String orderID;
	private String supplierID;
	private String totalCost;
	private String commitDate;
	private String other;

	public SellOrderShow(SellOrderBean order) {
		this.setOrderID(order.getOrderID());
		this.setCustomerID(order.getCustomerID());
		this.setCommitDate(order.getCommitDate());
		this.setTotalCost(String.valueOf(SellOrderOpr.getTotalCost(Integer
				.parseInt(order.getOrderID()))));
	}

	public SellOrderShow(int orderID) {
		ArrayList<SellOrderBean> items = SellOrderOpr.getByID(orderID);
		int totalCost = 0;
		this.setOrderID(String.valueOf(orderID));

		this.setCustomerID(items.get(0).getCustomerID());
		this.setCommitDate(items.get(0).getCommitDate());
		for (SellOrderBean item : items) {
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

	public String getCustomerID() {
		return supplierID;
	}

	public void setCustomerID(String supplierID) {
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
		return "SellOrderShow [orderID=" + orderID + ", supplierID="
				+ supplierID + ", totalCost=" + totalCost + ", commitDate="
				+ commitDate + ", other=" + other + "]";
	}

}
