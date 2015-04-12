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
	
	@FXML
	private MenuItem teacherCheckIn;
	
	@FXML
	private MenuItem teacherLeaveOut;
	
	@FXML
	private MenuItem studentLeaveOut;
	
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
		if (text.equals("Ñ§Éúµµ°¸")) {
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
		}
		
	}

}
