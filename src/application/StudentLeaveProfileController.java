package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.teach.StudentLeaveOutBean;
import bean.teach.RoomOpr;
import bean.teach.StudentLeaveOutOpr;
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

public class StudentLeaveProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField studentID;

	@FXML
	private DatePicker startDate;
	
	@FXML
	private DatePicker endDate;
	
	@FXML
	private TextField startTime;

	@FXML
	private TextField endTime;
	
	@FXML
	private TextField other;

	private StudentLeaveOutBean studentLeave;
	
	private StudentLeaveController studentLeaveController;
	
	public StudentLeaveOutBean getStudentLeave() {
		return studentLeave;
	}

	public void setStudentLeave(StudentLeaveOutBean room) {
		if (room == null) {
			isUpdate = false;
			this.studentLeave = new StudentLeaveOutBean();
			
		} else {
			isUpdate = true;
			this.studentLeave = room;
			
			System.out.println("Room Profile Page:\n" + this.studentLeave);
			
			studentID.setText(String.valueOf(this.studentLeave.getStudentID()));
			startDate.setValue(Time.stringToLocalDate(this.studentLeave.getStartDate()));
			endDate.setValue(Time.stringToLocalDate(this.studentLeave.getEndDate()));
			startTime.setText(this.studentLeave.getStartTime());
			endTime.setText(String.valueOf(this.studentLeave.getEndTime()));

			other.setText(this.studentLeave.getOther());
		}
		
		
	}

	public StudentLeaveController getStudentLeaveController() {
		return studentLeaveController;
	}

	public void setStudentLeaveController(StudentLeaveController studentLeaveController) {
		this.studentLeaveController = studentLeaveController;
	}

	public StudentLeaveProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.studentLeave.setStudentID(Integer.parseInt(studentID.getText()));
		
		this.studentLeave.setStartDate(Time.localDateToString(startDate.getValue()));
		this.studentLeave.setStartTime(startTime.getText());
		this.studentLeave.setEndDate(Time.localDateToString(endDate.getValue()));
		this.studentLeave.setEndTime(endTime.getText());
		
		this.studentLeave.setOther(other.getText());

		
		//System.out.println("Press Save!!!");
		this.studentLeaveController.refresh();
		StudentLeaveOutOpr.insert(studentLeave);
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
