package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.TeacherBean;
import bean.teach.TeacherOpr;
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

public class TeachersController extends BorderPane implements Initializable{

	@FXML
	private TableView<TeacherShow> tableView = new TableView<TeacherShow>();
	
	@FXML
	private Button add;
	
	@FXML
	private Button search;
	
	ObservableList<TeacherShow> data = FXCollections.observableArrayList();
	
	static final String properties[] = {
		"teacherID",
		"realName",
		"sex",
		"birthday",
		"major",
		"phone",
		"enrollDay",
		"status",
		"other"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(int i=0; i<properties.length; i++){
            TableColumn col = new TableColumn(properties[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<TeacherShow, String>(
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
			TeacherBean rowData = null;
            Stage popup = new Stage();
            TeacherProfileController teacherProfileCtrl = null;
            AnchorPane page = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("teacherProfile.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            teacherProfileCtrl = (TeacherProfileController) loader.getController();
	            teacherProfileCtrl.setTeacher(rowData);
	            teacherProfileCtrl.setTeacherController(this);
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
	        TeacherSearchController teacherSearchCtrl = null;
	        AnchorPane page = null;
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("teacherSearch.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            teacherSearchCtrl = (TeacherSearchController) loader.getController();
	            teacherSearchCtrl.setTeacherController(this);
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
            TableRow<TeacherShow> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                	TeacherShow rowData = row.getItem();
                	Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    // OR
                    // System.out.println(stageTheEventSourceNodeBelongs);
                    // Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
                    // System.out.println(stageTheLabelBelongs);
                    // these two of them return the same stage
                    // Swap screen
                    Stage popup = new Stage();
                    TeacherProfileController teacherProfileCtrl = null;
                    AnchorPane page = null;
                    FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("teacherProfile.fxml"));
					try {
			            page = (AnchorPane) loader.load();
			            teacherProfileCtrl = (TeacherProfileController) loader.getController();
			            TeacherBean teacher = TeacherOpr.getTeacherByID(rowData.getTeacherID());
			            teacherProfileCtrl.setTeacher(teacher);
			            teacherProfileCtrl.setTeacherController(this);
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
                
        for (TeacherBean teacher : TeacherOpr.getAllTeachers(2)) {
        	data.add(TeacherShow.TeacherBeanToShow(teacher));
        }
        
        tableView.setItems(data);
	}
	
	public void refresh() {
		/*
		ArrayList<Integer> ids = new ArrayList<>();
		for (teacherBean teacher : data) {
			ids.add(teacher.getteacherID());
		}
		data.clear();
		for (Integer id : ids) {
			data.add(teacherOpr.getteacherByID(id));
		}
		*/
		for (TableColumn<TeacherShow,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
	public void clear() {
		data.clear();
		/*
		for (TableColumn<teacherBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
		*/
	}
	
}
