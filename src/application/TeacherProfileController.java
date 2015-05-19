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

public class TeacherProfileController extends AnchorPane implements
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
			
			imageName = "file:C:\\images\\teacher_"
					+ TeacherOpr.getNextTeacherID() + ".jpg";
			
			this.teacher.setTeacherID(TeacherOpr.getNextTeacherID());
			teacherID.setText(String.valueOf(TeacherOpr.getNextTeacherID()));
		} else {
			isUpdate = true;
			this.teacher = teacher;
			
			imageName = "file:C:\\images\\teacher_"
					+ this.teacher.getTeacherID() + ".jpg";
			
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
						&& node.getId().equals("teacherID")) {
					studentID = ((TextField) node).getText();
					break;
				}
			}
			System.out.println("this is " + studentID);
			destFileName += "teacher_" + studentID + ".jpg";
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
