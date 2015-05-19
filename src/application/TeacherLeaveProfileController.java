package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.teach.TeacherLeaveOutBean;
import bean.teach.RoomOpr;
import bean.teach.TeacherLeaveOutOpr;
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

public class TeacherLeaveProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField teacherID;

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

	private TeacherLeaveOutBean teacherLeave;
	
	private TeacherLeaveController teacherLeaveController;
	
	public TeacherLeaveOutBean getTeacherLeave() {
		return teacherLeave;
	}

	public void setTeacherLeave(TeacherLeaveOutBean room) {
		if (room == null) {
			isUpdate = false;
			this.teacherLeave = new TeacherLeaveOutBean();
			
		} else {
			isUpdate = true;
			this.teacherLeave = room;
			
			System.out.println("Room Profile Page:\n" + this.teacherLeave);
			
			teacherID.setText(String.valueOf(this.teacherLeave.getTeacherID()));
			startDate.setValue(Time.stringToLocalDate(this.teacherLeave.getStartDate()));
			endDate.setValue(Time.stringToLocalDate(this.teacherLeave.getEndDate()));
			startTime.setText(this.teacherLeave.getStartTime());
			endTime.setText(String.valueOf(this.teacherLeave.getEndTime()));

			other.setText(this.teacherLeave.getOther());
		}
		
		
	}

	public TeacherLeaveController getTeacherLeaveController() {
		return teacherLeaveController;
	}

	public void setTeacherLeaveController(TeacherLeaveController teacherLeaveController) {
		this.teacherLeaveController = teacherLeaveController;
	}

	public TeacherLeaveProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.teacherLeave.setTeacherID(Integer.parseInt(teacherID.getText()));
		
		this.teacherLeave.setStartDate(Time.localDateToString(startDate.getValue()));
		this.teacherLeave.setStartTime(startTime.getText());
		this.teacherLeave.setEndDate(Time.localDateToString(endDate.getValue()));
		this.teacherLeave.setEndTime(endTime.getText());
		
		this.teacherLeave.setOther(other.getText());

		
		//System.out.println("Press Save!!!");
		this.teacherLeaveController.refresh();
		TeacherLeaveOutOpr.insert(teacherLeave);
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
