package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import util.Time;
import bean.CourseBean;
import bean.CourseOpr;
import bean.TeacherBean;
import bean.TeacherOpr;
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

public class CourseSearchController extends AnchorPane implements Initializable {

	@FXML
	private TextField courseID;

	@FXML
	private TextField teacherID;

	@FXML
	private TextField teacherName;

	@FXML
	private TextField instrument;

	@FXML
	private DatePicker startDay;

	@FXML
	private DatePicker endDay;

	@FXML
	private Button submit;

	private CoursesController courseController;

	public CoursesController getCourseController() {
		return courseController;
	}

	public void setCourseController(CoursesController courseController) {
		this.courseController = courseController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		submit.setOnAction(event -> {
			final String minDay = Time.getDate();
			final String maxDay = "99991231";
			String strStartDay = "";
			String strEndDay = "";

			this.courseController.data.clear();
			ObservableList<CourseBean> candidate = FXCollections
					.observableArrayList();
			ObservableList<CourseBean> tmp = FXCollections
					.observableArrayList();
			candidate.addAll(CourseOpr.getAllCourses(3));

			System.out.println("courseID: " + courseID.getText());
			if (!courseID.getText().equals("")) {
				for (CourseBean course : candidate) {
					if (course.getCourseID() == Integer.parseInt(courseID
							.getText())) {
						tmp.add(course);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
				this.courseController.data.addAll(candidate);
				this.courseController.refresh();
				((Node) event.getSource()).getScene().getWindow().hide();
				return;
			}

			System.out.println("teacherID: " + teacherID.getText());
			if (!teacherID.getText().equals("")) {
				for (CourseBean course : candidate) {
					if (teacherID.getText().equals(course.getTeacherID())) {
						tmp.add(course);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}

			System.out.println("teacherName: " + teacherName.getText());
			if (!teacherName.getText().equals("")) {
				ArrayList<TeacherBean> teachers = TeacherOpr
						.getTeacherByName(teacherName.getText());
				for (CourseBean course : candidate) {
					for (TeacherBean t : teachers) {
						if (t.getTeacherID() == course.getTeacherID()) {
							tmp.add(course);
							break;
						}
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}

			System.out.println("instrument: " + instrument.getText());
			if (!instrument.getText().equals("")) {
				for (CourseBean course : candidate) {
					if (instrument.getText().equals(course.getInstrument())) {
						tmp.add(course);
					}
				}
				candidate = tmp;
				tmp = FXCollections.observableArrayList();
			}

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

			for (CourseBean course : candidate) {
				if (course.getStartDate() != null
						&& course.getStartDate().compareTo(strStartDay) > 0
						&& course.getStartDate().compareTo(strEndDay) < 0) {
					tmp.add(course);
				}
			}
			candidate = tmp;
			tmp = FXCollections.observableArrayList();
			//System.out.println(candidate.size());

			this.courseController.data.addAll(candidate);
			this.courseController.refresh();
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}

}
