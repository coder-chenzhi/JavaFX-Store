package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.TeacherBean;
import bean.teach.TeacherCheckInOpr;
import bean.teach.TeacherOpr;
import bean.teach.TeacherCheckInBean;
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

public class TeacherCheckInSearchController extends AnchorPane implements
		Initializable {

	@FXML
	private TextField teacherID;

	@FXML
	private DatePicker startDay;

	@FXML
	private DatePicker endDay;

	@FXML
	private Button submit;

	private TeachersCheckInController teacherController;

	public TeachersCheckInController getTeacherController() {
		return teacherController;
	}

	public void setTeacherController(TeachersCheckInController teacherController) {
		this.teacherController = teacherController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		submit.setOnAction(event -> {
			final String minDay = "00000000";
			final String maxDay = "99991231";
			String strStartDay = "";
			String strEndDay = "";

			this.teacherController.data.clear();
			ArrayList<TeacherCheckInBean> candidate = TeacherCheckInOpr
					.getRecordByIDAndTime(teacherID.getText(),
							Time.localDateToString(startDay.getValue()),
							"0000", Time.localDateToString(endDay.getValue()),
							"2400");
			System.out.println(candidate);
			this.teacherController.data.addAll(candidate);

			this.teacherController.refresh();
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}

}
