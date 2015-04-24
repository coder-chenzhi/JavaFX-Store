package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.teach.TeacherBean;
import bean.teach.TeacherOpr;
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

public class TeacherProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField teacherID;

	@FXML
	private TextField realName;

	@FXML
	private ComboBox<String> sex = new ComboBox<String>();

	@FXML
	private DatePicker birthday;

	@FXML
	private TextField major;

	@FXML
	private TextField level;

	@FXML
	private TextField school;

	@FXML
	private TextField phone;

	@FXML
	private TextField address;

	@FXML
	private TextField education;

	@FXML
	private TextField identifyCard;
	
	@FXML
	private DatePicker enrollDay;

	@FXML
	private ComboBox<String> status;

	@FXML
	private TextField other;

	private final ObservableList sexStrings = FXCollections
			.observableArrayList("男", "女");

	private final ObservableList statusStrings = FXCollections
			.observableArrayList("在校", "离校");
	
	private TeacherBean teacher;
	
	private TeachersController teacherController;
	
	public TeacherBean getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherBean teacher) {
		if (teacher == null) {
			isUpdate = false;
			this.teacher = new TeacherBean();
			
			this.teacher.setTeacherID(TeacherOpr.getNextTeacherID());
			teacherID.setText(String.valueOf(TeacherOpr.getNextTeacherID()));
		} else {
			isUpdate = true;
			this.teacher = teacher;
			
			System.out.println("Teacher Profile Page:\n" + this.teacher);
			teacherID.setText(String.valueOf(this.teacher.getTeacherID()));
			realName.setText(this.teacher.getRealName());
			sex.setValue(this.teacher.getSex());
			System.out.println(this.teacher.getBirthday());
			if (this.teacher.getBirthday() != null) {
				birthday.setValue(Time.stringToLocalDate(this.teacher.getBirthday()));
			}
			major.setText(this.teacher.getMajor());
			level.setText(this.teacher.getLevel());
			school.setText(this.teacher.getSchool());
			phone.setText(this.teacher.getPhone());
			address.setText(this.teacher.getAddress());
			education.setText(this.teacher.getEducation());
			identifyCard.setText(this.teacher.getIdentifyCard());
			if (this.teacher.getEnrollDay() != null) {
				enrollDay.setValue(Time.stringToLocalDate(this.teacher.getEnrollDay()));
			}
			
			if (this.teacher.getStatus()) {
				status.setValue("在校");
			} else {
				status.setValue("离校");
			}

			other.setText(this.teacher.getOther());
		}
		
		
	}

	public TeachersController getTeacherController() {
		return teacherController;
	}

	public void setTeacherController(TeachersController parentController) {
		this.teacherController = parentController;
	}

	public TeacherProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		sex.setId("uneditable-combobox");
		sex.setPromptText("请选择");
		sex.setItems(sexStrings);
		status.setId("uneditable-combobox");
		status.setPromptText("请选择");
		status.setItems(statusStrings);
	}
	
	public void processSave() {
		this.teacher.setRealName(realName.getText());
		this.teacher.setSex(sex.getValue());
		this.teacher.setMajor(major.getText());
		this.teacher.setLevel(level.getText());
		this.teacher.setSchool(school.getText());
		this.teacher.setPhone(phone.getText());
		this.teacher.setAddress(address.getText());
		this.teacher.setOther(other.getText());
		education.setText(this.teacher.getEducation());
		identifyCard.setText(this.teacher.getIdentifyCard());
		
		//System.out.println(birthday.getValue());
		if (birthday.getValue() != null) {
			this.teacher.setBirthday(Time.localDateToString(birthday.getValue()));
		}
		
		if (enrollDay.getValue() != null) {
			this.teacher.setEnrollDay(Time.localDateToString(enrollDay.getValue()));
		}
		
		if (status.getValue() == "在校") {
			this.teacher.setStatus(true);
		} else if (status.getValue() == "离校") {
			this.teacher.setStatus(false);
		}
		
		//System.out.println("Press Save!!!");
		this.teacherController.refresh();
		if (isUpdate) {
			TeacherOpr.updateTeacher(teacher);
		} else {
			TeacherOpr.insertTeacher(teacher);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
