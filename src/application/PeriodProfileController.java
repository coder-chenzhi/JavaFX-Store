package application;

import java.net.URL;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.teach.PeriodBean;
import bean.teach.PeriodOpr;
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

public class PeriodProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField periodID;

	@FXML
	private TextField startTime;

	@FXML
	private TextField endTime;

	private PeriodBean period;
	
	private PeriodsController periodController;
	
	public PeriodBean getPeriod() {
		return period;
	}

	public void setPeriod(PeriodBean period) {
		if (period == null) {
			isUpdate = false;
			this.period = new PeriodBean();
			
		} else {
			isUpdate = true;
			this.period = period;
			
			System.out.println("Period Profile Page:\n" + this.period);
			periodID.setText(String.valueOf(this.period.getPeriodID()));
			startTime.setText(this.period.getStartTime());
			endTime.setText(this.period.getEndTime());
		}
		
		
	}

	public PeriodsController getPeriodController() {
		return periodController;
	}

	public void setPeriodController(PeriodsController parentController) {
		this.periodController = parentController;
	}

	public PeriodProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		String preID = this.period.getPeriodID();
		this.period.setPeriodID(periodID.getText());
		this.period.setStartTime(startTime.getText());
		this.period.setEndTime(endTime.getText());

		
		//System.out.println("Press Save!!!");
		this.periodController.refresh();
		if (isUpdate) {
			PeriodOpr.updatePeriod(preID, period);
		} else {
			PeriodOpr.insertPeriod(period);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
