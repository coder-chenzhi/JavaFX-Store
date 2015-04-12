package application;

import java.net.URL;
import java.util.ResourceBundle;

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
			.observableArrayList("��", "Ů", "����");

	private final ObservableList statusStrings = FXCollections
			.observableArrayList("��У", "��У", "����");
	
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
		sex.setPromptText("��ѡ��");
		sex.setItems(sexStrings);
		status.setId("uneditable-combobox");
		status.setPromptText("��ѡ��");
		status.setItems(statusStrings);
		
		submit.setOnAction(event -> {
			
			
			((Node)event.getSource()).getScene().getWindow().hide();
		});
	}

}