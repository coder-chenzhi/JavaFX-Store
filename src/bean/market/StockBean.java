package bean.market;

public class StockBean {
	private int goodID;
	private int amount;

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Stocks [goodsID=" + goodID + ", amount=" + amount + "]\n";
	}

}
