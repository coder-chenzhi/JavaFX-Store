package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController extends BorderPane implements Initializable{

	@FXML
	private TabPane tabs;
	
	@FXML
	private MenuItem quit;
	
	@FXML
	private MenuItem students;
	
	@FXML
	private MenuItem teachers;
	
	@FXML
	private MenuItem searchCourses;
	
	/* ���ҹ��� */
	@FXML
	private MenuItem manageRooms;
	
	/* ʱ�ι��� */
	@FXML
	private MenuItem managePeriods;
	
	/* ��ʦ���� */
	@FXML
	private MenuItem teacherCheckIn;
	
	/* ��ʦ��� */
	@FXML
	private MenuItem teacherLeaveOut;
	
	/* ѧ����� */
	@FXML
	private MenuItem studentLeaveOut;
	
	/* ��ʦ�򿨼�¼ */
	@FXML
	private MenuItem tableTeacherCheckIn;
	
	/* ѧ���Ͽμ�¼  */
	@FXML
	private MenuItem tableStudentTakeCourse;
	
	@FXML
	private MenuItem calculator;
	
	@FXML
	private MenuItem notepad;
	
	private Main application;

	public void setApp(Main application) {
		this.application = application;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
	}
	
	public void processMenuClick(ActionEvent event) {
		String text = ((MenuItem)(event.getSource())).getText();
		System.out.println(text);
		if (text.equals("ѧ������")) {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("StudentsMain.fxml"));
            StudentsController menu = null;
            AnchorPane page = null;
            try {
            	page = (AnchorPane) loader.load();
				menu = (StudentsController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Tab tab1 = new Tab();
            tab1.setText("SearchStudents");
            tab1.setContent(page);
            tabs.getTabs().add(tab1);
		} else if (text.equals("��ʦ����")) {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("TeachersMain.fxml"));
            TeachersController menu = null;
            AnchorPane page = null;
            try {
            	page = (AnchorPane) loader.load();
				menu = (TeachersController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Tab tab1 = new Tab();
            tab1.setText("SearchTeachers");
            tab1.setContent(page);
            tabs.getTabs().add(tab1);
		} else if (text.equals("���ҹ���")) {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RoomsMain.fxml"));
            RoomsController menu = null;
            AnchorPane page = null;
            try {
            	page = (AnchorPane) loader.load();
				menu = (RoomsController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Tab tab1 = new Tab();
            tab1.setText("ShowRooms");
            tab1.setContent(page);
            tabs.getTabs().add(tab1);
		} else if (text.equals("ʱ�ι���")) {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PeriodsMain.fxml"));
            PeriodsController menu = null;
            AnchorPane page = null;
            try {
            	page = (AnchorPane) loader.load();
				menu = (PeriodsController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Tab tab1 = new Tab();
            tab1.setText("ShowPeriods");
            tab1.setContent(page);
            tabs.getTabs().add(tab1);
		}
		
	}

}
