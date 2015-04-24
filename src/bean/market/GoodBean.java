package bean.market;

/**
 * 
 * @author chenzhi CREATE TABLE Goods ( goodID INT, goodName VARCHAR(255)
 *         UNIQUE, 商品名称 goodType Text, 乐器类型 manufact Text, 生产厂商
 *         defalutPurchasePrice INT, 默认进价 defalutSellPrice INT, 默认售价 other Text,
 *         PRIMARY KEY (goodID) );
 */

public class GoodBean {
	private int goodID;
	private String goodName;
	private String goodType;
	private String manufact;
	private int defalutPurchasePrice;
	private int defalutSellPrice;
	private String other;

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getManufact() {
		return manufact;
	}

	public void setManufact(String manufact) {
		this.manufact = manufact;
	}

	public int getDefalutPurchasePrice() {
		return defalutPurchasePrice;
	}

	public void setDefalutPurchasePrice(int defalutPurchasePrice) {
		this.defalutPurchasePrice = defalutPurchasePrice;
	}

	public int getDefalutSellPrice() {
		return defalutSellPrice;
	}

	public void setDefalutSellPrice(int defalutSellPrice) {
		this.defalutSellPrice = defalutSellPrice;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "GoodBean [goodID=" + goodID + ", goodName=" + goodName
				+ ", goodType=" + goodType + ", manufact=" + manufact
				+ ", defalutPurchasePrice=" + defalutPurchasePrice
				+ ", defalutSellPrice=" + defalutSellPrice + ", other=" + other
				+ "]\n";
	}

}
