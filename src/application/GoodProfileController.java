package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.market.GoodBean;
import bean.market.GoodOpr;
import util.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class GoodProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField goodID;

	@FXML
	private TextField goodName;

	@FXML
	private TextField goodType;
	
	@FXML
	private TextField manufact;
	
	@FXML
	private TextField defalutPurchasePrice;
	
	@FXML
	private TextField defalutSellPrice;
	
	@FXML
	private TextField other;

	private GoodBean good;
	
	private GoodsController goodController;
	
	public GoodBean getGood() {
		return good;
	}

	public void setGood(GoodBean good) {
		if (good == null) {
			isUpdate = false;
			this.good = new GoodBean();
			this.good.setGoodID(GoodOpr.getNextGoodsID());
			goodID.setText(String.valueOf(GoodOpr.getNextGoodsID()));
		} else {
			isUpdate = true;
			this.good = good;
			
			System.out.println("Good Profile Page:\n" + this.good);
			goodID.setText(String.valueOf(this.good.getGoodID()));
			goodName.setText(this.good.getGoodName());
			goodType.setText(this.good.getGoodType());
			manufact.setText(this.good.getManufact());
			defalutPurchasePrice.setText(String.valueOf(this.good.getDefalutPurchasePrice()));
			defalutSellPrice.setText(String.valueOf(this.good.getDefalutSellPrice()));
			other.setText(this.good.getOther());
		}
		
		
	}

	public GoodsController getGoodController() {
		return goodController;
	}

	public void setGoodController(GoodsController parentController) {
		this.goodController = parentController;
	}

	public GoodProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.good.setGoodID(Integer.parseInt(goodID.getText()));
		this.good.setGoodName(goodName.getText());
		this.good.setGoodType(goodType.getText());
		this.good.setManufact(manufact.getText());
		this.good.setDefalutPurchasePrice(Integer.parseInt(defalutPurchasePrice.getText()));
		this.good.setDefalutSellPrice(Integer.parseInt(defalutSellPrice.getText()));
		this.good.setOther(other.getText());
		
		//System.out.println("Press Save!!!");
		this.goodController.refresh();
		if (isUpdate) {
			GoodOpr.updateGoods(good);
		} else {
			GoodOpr.insertGoods(good);
		}
		
	}
	
	public void processClose() {
		other.getScene().getWindow().hide();
	}
	
	public static void main(String[] args) {
		
	}
	
}
