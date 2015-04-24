package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.StudentBean;
import bean.teach.StudentOpr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class StudentsController extends BorderPane implements Initializable{

	@FXML
	private TableView<StudentShow> tableView = new TableView<StudentShow>();
	
	@FXML
	private Button add;
	
	@FXML
	private Button search;
	
	ObservableList<StudentShow> data = FXCollections.observableArrayList();
	
	static final String properties[] = {
		"studentID",
		"realName",
		"sex",
		"birthday",
		"major",
		"enrollDay",
		"balance",
		"status"};
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(int i=0; i<properties.length; i++){
            TableColumn col = new TableColumn(properties[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<StudentShow, String>(
                    		properties[i]));
            tableView.getColumns().add(col);
        }
		
		add.setOnAction(event -> {
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
            // OR
            // System.out.println(stageTheEventSourceNodeBelongs);
            // Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
            // System.out.println(stageTheLabelBelongs);
            // these two of them return the same stage
            // Swap screen
			StudentBean rowData = null;
            Stage popup = new Stage();
            StudentProfileController studentProfileCtrl = null;
            AnchorPane page = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("StudentProfile.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            studentProfileCtrl = (StudentProfileController) loader.getController();
	            studentProfileCtrl.setStudent(rowData);
	            studentProfileCtrl.setStudentController(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            popup.initModality(Modality.WINDOW_MODAL);
            popup.setScene(new Scene(page));
            popup.initOwner(stageTheEventSourceNodeBelongs);
            popup.show();
		});
		
		search.setOnAction(event -> {
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        // OR
	        // System.out.println(stageTheEventSourceNodeBelongs);
	        // Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
	        // System.out.println(stageTheLabelBelongs);
	        // these two of them return the same stage
	        // Swap screen
	        Stage popup = new Stage();
	        StudentSearchController studentSearchCtrl = null;
	        AnchorPane page = null;
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("StudentSearch.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            studentSearchCtrl = (StudentSearchController) loader.getController();
	            studentSearchCtrl.setStudentController(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        popup.initModality(Modality.WINDOW_MODAL);
	        popup.setScene(new Scene(page));
	        popup.initOwner(stageTheEventSourceNodeBelongs);
	        popup.show();
		});
		
		
        tableView.setRowFactory( tv -> {
            TableRow<StudentShow> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                	StudentShow rowData = row.getItem();
                	Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    // OR
                    // System.out.println(stageTheEventSourceNodeBelongs);
                    // Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
                    // System.out.println(stageTheLabelBelongs);
                    // these two of them return the same stage
                    // Swap screen
                    Stage popup = new Stage();
                    StudentProfileController studentProfileCtrl = null;
                    AnchorPane page = null;
                    FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("StudentProfile.fxml"));
					try {
			            page = (AnchorPane) loader.load();
			            studentProfileCtrl = (StudentProfileController) loader.getController();
			            StudentBean student = StudentOpr.getStudentByID(rowData.getStudentID());
			            studentProfileCtrl.setStudent(student);
			            studentProfileCtrl.setStudentController(this);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    popup.initModality(Modality.WINDOW_MODAL);
                    popup.setScene(new Scene(page));
                    popup.initOwner(stageTheEventSourceNodeBelongs);
                    popup.show();
                	
                    System.out.println(rowData);
                }
            });
            return row ;
        });
        
        data.addAll();
        
        for (StudentBean student : StudentOpr.getAllStudents(2)) {
        	data.add(StudentShow.StudentBeanToShow(student));
        }
        
        tableView.setItems(data);
	}
	
	public void refresh() {
		/*
		ArrayList<Integer> ids = new ArrayList<>();
		for (StudentBean student : data) {
			ids.add(student.getStudentID());
		}
		data.clear();
		for (Integer id : ids) {
			data.add(StudentOpr.getStudentByID(id));
		}
		*/
		for (TableColumn<StudentShow,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
	public void clear() {
		data.clear();
		/*
		for (TableColumn<StudentBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
		*/
	}
	
}
