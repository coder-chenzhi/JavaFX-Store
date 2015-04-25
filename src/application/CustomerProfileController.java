package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.market.CustomerBean;
import bean.market.CustomerOpr;
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

public class CustomerProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField customerID;

	@FXML
	private TextField customerName;

	@FXML
	private TextField contactName;
	
	@FXML
	private TextField contactAddress;
	
	@FXML
	private TextField contactPhone;
	
	@FXML
	private TextField other;

	private CustomerBean customer;
	
	private CustomersController customerController;
	
	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		if (customer == null) {
			isUpdate = false;
			this.customer = new CustomerBean();
			this.customer.setCustomerID(CustomerOpr.getNextCustomerID());
			customerID.setText(String.valueOf(CustomerOpr.getNextCustomerID()));
		} else {
			isUpdate = true;
			this.customer = customer;
			
			System.out.println("Customer Profile Page:\n" + this.customer);
			customerID.setText(String.valueOf(this.customer.getCustomerID()));
			customerName.setText(this.customer.getCustomerName());
			contactName.setText(this.customer.getContactName());
			contactAddress.setText(this.customer.getContactAddress());
			contactPhone.setText(this.customer.getContactPhone());
			other.setText(this.customer.getOther());
		}
		
		
	}

	public CustomersController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomersController parentController) {
		this.customerController = parentController;
	}

	public CustomerProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.customer.setCustomerID(Integer.parseInt(customerID.getText()));
		this.customer.setCustomerName(customerName.getText());
		this.customer.setContactName(contactName.getText());
		this.customer.setContactAddress(contactAddress.getText());
		this.customer.setContactPhone(contactPhone.getText());
		this.customer.setOther(other.getText());
		
		//System.out.println("Press Save!!!");
		this.customerController.refresh();
		if (isUpdate) {
			CustomerOpr.updateCustomer(customer);
		} else {
			CustomerOpr.insertCustomer(customer);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
