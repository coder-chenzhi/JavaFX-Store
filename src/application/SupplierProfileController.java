package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.market.SupplierBean;
import bean.market.SupplierOpr;
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

public class SupplierProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField supplierID;

	@FXML
	private TextField supplierName;

	@FXML
	private TextField contactName;
	
	@FXML
	private TextField contactAddress;
	
	@FXML
	private TextField contactPhone;
	
	@FXML
	private TextField other;

	private SupplierBean supplier;
	
	private SuppliersController supplierController;
	
	public SupplierBean getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierBean supplier) {
		if (supplier == null) {
			isUpdate = false;
			this.supplier = new SupplierBean();
			this.supplier.setSupplierID(SupplierOpr.getNextSupplierID());
			supplierID.setText(String.valueOf(SupplierOpr.getNextSupplierID()));
		} else {
			isUpdate = true;
			this.supplier = supplier;
			
			System.out.println("Supplier Profile Page:\n" + this.supplier);
			supplierID.setText(String.valueOf(this.supplier.getSupplierID()));
			supplierName.setText(this.supplier.getSupplierName());
			contactName.setText(this.supplier.getContactName());
			contactAddress.setText(this.supplier.getContactAddress());
			contactPhone.setText(this.supplier.getContactPhone());
			other.setText(this.supplier.getOther());
		}
		
		
	}

	public SuppliersController getSupplierController() {
		return supplierController;
	}

	public void setSupplierController(SuppliersController parentController) {
		this.supplierController = parentController;
	}

	public SupplierProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.supplier.setSupplierID(Integer.parseInt(supplierID.getText()));
		this.supplier.setSupplierName(supplierName.getText());
		this.supplier.setContactName(contactName.getText());
		this.supplier.setContactAddress(contactAddress.getText());
		this.supplier.setContactPhone(contactPhone.getText());
		this.supplier.setOther(other.getText());
		
		//System.out.println("Press Save!!!");
		this.supplierController.refresh();
		if (isUpdate) {
			SupplierOpr.updateSupplier(supplier);
		} else {
			SupplierOpr.insertSupplier(supplier);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
