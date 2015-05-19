package application;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.StudentBean;
import bean.teach.StudentOpr;
import bean.teach.TeacherLeaveOutBean;
import util.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentProfileController extends AnchorPane implements
		Initializable {

	private boolean isUpdate;

	private String imageName = "";

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@FXML
	private AnchorPane imagePanel;

	@FXML
	private Button openImage;

	@FXML
	private ImageView imageView;

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
			isUpdate = false;
			this.student = new StudentBean();
			imageName = "file:C:\\images\\student_"
					+ StudentOpr.getNextStudentID() + ".jpg";

			this.student.setStudentID(StudentOpr.getNextStudentID());

			studentID.setText(String.valueOf(StudentOpr.getNextStudentID()));
		} else {
			isUpdate = true;
			this.student = student;
			imageName = "file:C:\\images\\student_"
					+ this.student.getStudentID() + ".jpg";

			System.out.println("Student Profile Page:\n" + this.student);
			studentID.setText(String.valueOf(this.student.getStudentID()));
			realName.setText(this.student.getRealName());
			sex.setValue(this.student.getSex());
			System.out.println(this.student.getBirthday());
			if (this.student.getBirthday() != null) {
				birthday.setValue(Time.stringToLocalDate(this.student
						.getBirthday()));
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
				enrollDay.setValue(Time.stringToLocalDate(this.student
						.getEnrollDay()));
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

		// init imageView
		File folder = new File("C://images");
		ArrayList<String> files = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			files.add(fileEntry.getName());
		}

		boolean flag = false;
		for (String str : files) {
			if (imageName.endsWith(str)) {
				flag = true;
				break;
			}
		}

		System.out.println("imageName" + imageName);
		if (flag) {
			Image image = new Image(imageName);

			imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(140);
			imagePanel.getChildren().add(imageView);
		} else {
			// openImage = new Button("Open Image");
			imagePanel.getChildren().add(openImage);
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

		openImage = new Button("Open JPEG Image...");

		openImage.setOnAction(event -> {
			String destFileName = "C://images/";
			String studentID = "";
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) event
					.getSource()).getScene().getWindow();

			for (Node node : ((Node) event.getSource()).getScene().getRoot()
					.getChildrenUnmodifiable()) {
				// System.out.println(node);
				// System.out.println(node.getId());
				if (node instanceof TextField
						&& node.getId().equals("studentID")) {
					studentID = ((TextField) node).getText();
					break;
				}
			}
			System.out.println("this is " + studentID);
			destFileName += "student_" + studentID + ".jpg";
			File destFile = new File(destFileName);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("JPG", "*.jpg"));
			File file = fileChooser
					.showOpenDialog(stageTheEventSourceNodeBelongs);
			if (file != null) {
				// System.out.println(file.getName());
				try {
					Files.copy(file.toPath(), destFile.toPath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			openImage.setVisible(false);
			Image image = new Image("file:" + destFileName);

			imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(140);
			imagePanel.getChildren().add(imageView);
		});
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

		// System.out.println(birthday.getValue());
		if (birthday.getValue() != null) {
			this.student
					.setBirthday(Time.localDateToString(birthday.getValue()));
		}

		if (enrollDay.getValue() != null) {
			this.student.setEnrollDay(Time.localDateToString(enrollDay
					.getValue()));
		}

		if (status.getValue() == "在校") {
			this.student.setStatus(true);
		} else if (status.getValue() == "离校") {
			this.student.setStatus(false);
		}

		// System.out.println("Press Save!!!");
		this.studentController.refresh();
		if (isUpdate) {
			StudentOpr.updateStudent(student);
		} else {
			StudentOpr.insertStudent(student);
		}

	}

	public static void main(String[] args) {

	}

}
