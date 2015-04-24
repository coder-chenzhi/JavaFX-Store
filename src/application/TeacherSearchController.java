package application;

import java.net.URL;
import java.util.ResourceBundle;

import bean.teach.TeacherBean;
import bean.teach.TeacherOpr;
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

public class TeacherSearchController extends AnchorPane implements
		Initializable {

	@FXML
	private TextField teacherID;

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

	private TeachersController teacherController;

	public TeachersController getTeacherController() {
		return teacherController;
	}

	public void setTeacherController(TeachersController teacherController) {
		this.teacherController = teacherController;
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

			this.teacherController.data.clear();
			ObservableList<TeacherBean> candidate = FXCollections
					.observableArrayList();
			ObservableList<TeacherBean> tmp = FXCollections
					.observableArrayList();
			candidate.addAll(TeacherOpr.getAllTeachers(2));
			
			//System.out.println("teacherID: " + teacherID.getText());
			if (!teacherID.getText().equals("")) {
				for (TeacherBean teacher : candidate) {
					if (teacher.getTeacherID() == Integer.parseInt(teacherID
							.getText())) {
						tmp.add(teacher);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}

			//System.out.println("realName: " + realName.getText());
			if (!realName.getText().equals("")) {
				for (TeacherBean teacher : candidate) {
					if (realName.getText().equals(teacher.getRealName())) {
						tmp.add(teacher);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			
			//System.out.println("sex" + sex.getValue());
			if (sex.getValue() != null && !sex.getValue().equals("不限")) {
				for (TeacherBean teacher : candidate) {
					if (sex.getValue().equals(teacher.getSex())) {
						tmp.add(teacher);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			
			//System.out.println("major: " + major.getText());
			if (!major.getText().equals("")) {
				for (TeacherBean teacher : candidate) {
					if (major.getText().equals(teacher.getMajor())) {
						tmp.add(teacher);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}

			//System.out.println("status: " + status.getValue());
			if (status.getValue() != null && !status.getValue().equals("不限")) {
				for (TeacherBean teacher : candidate) {
					if (status.getValue().equals("在校") && teacher.getStatus()) {
						tmp.add(teacher);
					} else if (status.getValue().equals("离校")
							&& !teacher.getStatus()) {
						tmp.add(teacher);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}
			
			//System.out.println("start day: " + startDay.getValue());
			if (startDay.getValue() != null) {
				strStartDay = Time.localDateToString(startDay.getValue());
			} else {
				strStartDay = minDay;
			}
			
			//System.out.println("end day: " + endDay.getValue());
			if (endDay.getValue() != null) {
				strEndDay = Time.localDateToString(endDay.getValue());
			} else {
				strEndDay = maxDay;
			}

			for (TeacherBean teacher : candidate) {
				if (teacher.getEnrollDay() != null
						&& teacher.getEnrollDay().compareTo(strStartDay) > 0
						&& teacher.getEnrollDay().compareTo(strEndDay) < 0) {
					tmp.add(teacher);
				}
			}
			candidate = tmp;
			tmp = FXCollections.observableArrayList();
			
			for (TeacherBean teacher : candidate) {
				this.teacherController.data.add(TeacherShow.TeacherBeanToShow(teacher));
			}
			
			this.teacherController.refresh();
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}

}
