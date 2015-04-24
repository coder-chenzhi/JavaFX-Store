package application;

import java.net.URL;
import java.util.ResourceBundle;

import bean.teach.StudentBean;
import bean.teach.StudentOpr;
import util.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StudentSearchController extends AnchorPane implements
		Initializable {

	@FXML
	private TextField studentID;

	@FXML
	private TextField realName;

	@FXML
	private ComboBox<String> sex = new ComboBox<String>();

	@FXML
	private TextField major;

	@FXML
	private DatePicker startDay;

	@FXML
	private DatePicker endDay;

	@FXML
	private ComboBox<String> status;

	@FXML
	private Button submit;

	private final ObservableList sexStrings = FXCollections
			.observableArrayList("男", "女", "不限");

	private final ObservableList statusStrings = FXCollections
			.observableArrayList("在校", "离校", "不限");

	private StudentsController studentController;

	public StudentsController getStudentController() {
		return studentController;
	}

	public void setStudentController(StudentsController studentController) {
		this.studentController = studentController;
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

		submit.setOnAction(event -> {
			final String minDay = "00000000";
			final String maxDay = "99991231";
			String strStartDay = "";
			String strEndDay = "";

			this.studentController.data.clear();
			ObservableList<StudentBean> candidate = FXCollections
					.observableArrayList();
			ObservableList<StudentBean> tmp = FXCollections
					.observableArrayList();
			candidate.addAll(StudentOpr.getAllStudents(2));
			
			System.out.println("studentID: " + studentID.getText());
			if (!studentID.getText().equals("")) {
				for (StudentBean student : candidate) {
					if (student.getStudentID() == Integer.parseInt(studentID
							.getText())) {
						tmp.add(student);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			System.out.println(candidate.size());

			System.out.println("realName: " + realName.getText());
			if (!realName.getText().equals("")) {
				for (StudentBean student : candidate) {
					if (realName.getText().equals(student.getRealName())) {
						tmp.add(student);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			System.out.println(candidate.size());
			
			System.out.println("sex" + sex.getValue());
			if (sex.getValue() != null && !sex.getValue().equals("不限")) {
				for (StudentBean student : candidate) {
					if (sex.getValue().equals(student.getSex())) {
						tmp.add(student);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			System.out.println(candidate.size());
			
			System.out.println("major: " + major.getText());
			if (!major.getText().equals("")) {
				for (StudentBean student : candidate) {
					if (major.getText().equals(student.getMajor())) {
						tmp.add(student);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			System.out.println(candidate.size());

			System.out.println("status: " + status.getValue());
			if (status.getValue() != null && !status.getValue().equals("不限")) {
				for (StudentBean student : candidate) {
					if (status.getValue().equals("在校") && student.getStatus()) {
						tmp.add(student);
					} else if (status.getValue().equals("离校")
							&& !student.getStatus()) {
						tmp.add(student);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			System.out.println(candidate.size());
			
			System.out.println("start day: " + startDay.getValue());
			if (startDay.getValue() != null) {
				strStartDay = Time.localDateToString(startDay.getValue());
			} else {
				strStartDay = minDay;
			}
			
			System.out.println("end day: " + endDay.getValue());
			if (endDay.getValue() != null) {
				strEndDay = Time.localDateToString(endDay.getValue());
			} else {
				strEndDay = maxDay;
			}

			for (StudentBean student : candidate) {
				if (student.getEnrollDay() != null
						&& student.getEnrollDay().compareTo(strStartDay) > 0
						&& student.getEnrollDay().compareTo(strEndDay) < 0) {
					tmp.add(student);
				}
			}
			candidate = tmp;
			tmp = FXCollections.observableArrayList();
			System.out.println(candidate.size());
			
			for (StudentBean student : candidate) {
				this.studentController.data.add(StudentShow.StudentBeanToShow(student));
			}
			
			this.studentController.refresh();
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}

}
