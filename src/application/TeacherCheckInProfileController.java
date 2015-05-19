package application;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.StudentOpr;
import bean.teach.TeacherBean;
import bean.teach.TeacherCheckInBean;
import bean.teach.TeacherCheckInOpr;
import bean.teach.TeacherOpr;
import util.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TeacherCheckInProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField teacherID;

	@FXML
	private ComboBox<String> type;

	private TeacherCheckInBean teacher = new TeacherCheckInBean();
	
	private TeachersCheckInController teacherController;
	
	private final ObservableList typeStrings = FXCollections
			.observableArrayList("…œ∞‡", "œ¬∞‡");
	
	public TeacherCheckInBean getTeacherCheckIn() {
		return teacher;
	}

	public TeachersCheckInController getTeacherController() {
		return teacherController;
	}

	public void setTeacherController(TeachersCheckInController parentController) {
		this.teacherController = parentController;
	}

	public TeacherCheckInProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		type.setPromptText("«Î—°‘Ò");
		type.setItems(typeStrings);
	}
	
	public void processSave() {
		this.teacher.setTeacherID(Integer.parseInt(teacherID.getText()));
		
		this.teacher.setCheckDate(Time.getDate());
		this.teacher.setCheckTime(Time.getTime());
		this.teacher.setType(type.getValue());
		//System.out.println("Press Save!!!");
		this.teacherController.refresh();
		TeacherCheckInOpr.insertRecord(teacher);
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
