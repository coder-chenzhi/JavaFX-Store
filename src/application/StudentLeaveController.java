package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.StudentLeaveOutBean;
import bean.teach.RoomOpr;
import bean.teach.StudentLeaveOutOpr;
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

public class StudentLeaveController extends BorderPane implements Initializable{

	@FXML
	private TableView<StudentLeaveOutBean> tableView = new TableView<StudentLeaveOutBean>();
	
	@FXML
	private Button add;
	
	@FXML
	private Button refresh;
	
	
	ObservableList<StudentLeaveOutBean> data = FXCollections.observableArrayList();
	
	static final String properties[] = {
		"studentID",
		"startDate",
		"startTime",
		"endDate",
		"endTime",
		"other"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(int i=0; i<properties.length; i++){
            TableColumn col = new TableColumn(properties[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<StudentLeaveOutBean, String>(
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
			StudentLeaveOutBean rowData = null;
            Stage popup = new Stage();
            StudentLeaveProfileController profileCtrl = null;
            AnchorPane page = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("StudentLeaveProfile.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            profileCtrl = (StudentLeaveProfileController) loader.getController();
	            profileCtrl.setStudentLeave(rowData);
	            profileCtrl.setStudentLeaveController(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            popup.initModality(Modality.WINDOW_MODAL);
            popup.setScene(new Scene(page));
            popup.initOwner(stageTheEventSourceNodeBelongs);
            popup.show();
		});
		
        
        data.addAll(StudentLeaveOutOpr.getAll());
        
        tableView.setItems(data);
	}
	
	public void refresh() {
		data.clear();
		data.addAll(StudentLeaveOutOpr.getAll());

		for (TableColumn<StudentLeaveOutBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
	public void clear() {
		data.clear();
		for (TableColumn<StudentLeaveOutBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
}
