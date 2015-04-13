package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import util.Time;
import bean.StudentBean;
import bean.StudentOpr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class StudentProfileController extends AnchorPane implements
		Initializable {

	@FXML
	private TextField studentID;

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
	private TextField classGrade;

	@FXML
	private TextField hobby;

	@FXML
	private TextField instrument;

	@FXML
	private TextField parentsName;

	@FXML
	private TextField phone;

	@FXML
	private TextField address;

	@FXML
	private DatePicker enrollDay;

	@FXML
	private ComboBox<String> classType;

	@FXML
	private TextField balance;

	@FXML
	private ComboBox<String> status;

	@FXML
	private TextField other;

	private final ObservableList sexStrings = FXCollections
			.observableArrayList("男", "女");

	private final ObservableList classStrings = FXCollections
			.observableArrayList("全课", "半课", "单人课", "两人课", "四人课");
	
	private final ObservableList statusStrings = FXCollections
			.observableArrayList("在校", "离校");
	
	private StudentBean student;
	
	private StudentsController studentController;
	
	public StudentBean getStudent() {
		return student;
	}

	public void setStudent(StudentBean student) {
		if (student == null) {
			this.student = new StudentBean();
			
			this.student.setStudentID(StudentOpr.getNextStudentID());
			studentID.setText(String.valueOf(StudentOpr.getNextStudentID()));
		} else {
			this.student = student;
			
			System.out.println("Student Profile Page:\n" + this.student);
			studentID.setText(String.valueOf(this.student.getStudentID()));
			realName.setText(this.student.getRealName());
			sex.setValue(this.student.getSex());
			System.out.println(this.student.getBirthday());
			if (this.student.getBirthday() != null) {
				birthday.setValue(Time.stringToLocalDate(this.student.getBirthday()));
			}
			major.setText(this.student.getMajor());
			level.setText(this.student.getLevel());
			school.setText(this.student.getSchool());
			classGrade.setText(this.student.getClassGrade());
			hobby.setText(this.student.getHobby());
			instrument.setText(this.student.getInstrument());
			parentsName.setText(this.student.getParentsName());
			phone.setText(this.student.getPhone());
			address.setText(this.student.getAddress());
			if (this.student.getEnrollDay() != null) {
				enrollDay.setValue(Time.stringToLocalDate(this.student.getEnrollDay()));
			}
			
			if (this.student.getStatus()) {
				status.setValue("在校");
			} else {
				status.setValue("离校");
			}
			classType.setValue(this.student.getClassType());
			balance.setText(String.valueOf(this.student.getBalance()));
			other.setText(this.student.getOther());
		}
		
		
	}

	public StudentsController getStudentController() {
		return studentController;
	}

	public void setStudentController(StudentsController parentController) {
		this.studentController = parentController;
	}

	public StudentProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		sex.setId("uneditable-combobox");
		sex.setPromptText("请选择");
		sex.setItems(sexStrings);
		classType.setId("uneditable-combobox");
		classType.setPromptText("请选择");
		classType.setItems(classStrings);
		status.setId("uneditable-combobox");
		status.setPromptText("请选择");
		status.setItems(statusStrings);
	}
	
	public void processSave() {
		this.student.setRealName(realName.getText());
		this.student.setSex(sex.getValue());
		this.student.setMajor(major.getText());
		this.student.setLevel(level.getText());
		this.student.setSchool(school.getText());
		this.student.setClassGrade(classGrade.getText());
		this.student.setHobby(hobby.getText());
		this.student.setInstrument(instrument.getText());
		this.student.setParentsName(parentsName.getText());
		this.student.setPhone(phone.getText());
		this.student.setAddress(address.getText());
		this.student.setClassType(classType.getValue());
		this.student.setOther(other.getText());
		this.student.setBalance(Double.parseDouble(balance.getText()));
		
		//System.out.println(birthday.getValue());
		if (birthday.getValue() != null) {
			this.student.setBirthday(Time.localDateToString(birthday.getValue()));
		}
		
		if (enrollDay.getValue() != null) {
			this.student.setEnrollDay(Time.localDateToString(enrollDay.getValue()));
		}
		
		if (status.getValue() == "在校") {
			this.student.setStatus(true);
		} else if (status.getValue() == "离校") {
			this.student.setStatus(false);
		}
		
		//System.out.println("Press Save!!!");
		this.studentController.refresh();
	}
	
	public static void main(String[] args) {
		
	}
	
}
