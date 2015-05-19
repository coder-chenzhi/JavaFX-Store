package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.teach.TeacherLeaveOutBean;
import bean.teach.RoomOpr;
import bean.teach.TeacherLeaveOutOpr;
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

public class TeacherLeaveController extends BorderPane implements Initializable{

	@FXML
	private TableView<TeacherLeaveOutBean> tableView = new TableView<TeacherLeaveOutBean>();
	
	@FXML
	private Button add;
	
	@FXML
	private Button refresh;
	
	
	ObservableList<TeacherLeaveOutBean> data = FXCollections.observableArrayList();
	
	static final String properties[] = {
		"teacherID",
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
                    new PropertyValueFactory<TeacherLeaveOutBean, String>(
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
			TeacherLeaveOutBean rowData = null;
            Stage popup = new Stage();
            TeacherLeaveProfileController profileCtrl = null;
            AnchorPane page = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("TeacherLeaveProfile.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            profileCtrl = (TeacherLeaveProfileController) loader.getController();
	            profileCtrl.setTeacherLeave(rowData);
	            profileCtrl.setTeacherLeaveController(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            popup.initModality(Modality.WINDOW_MODAL);
            popup.setScene(new Scene(page));
            popup.initOwner(stageTheEventSourceNodeBelongs);
            popup.show();
		});
		
        
        data.addAll(TeacherLeaveOutOpr.getAll());
        
        tableView.setItems(data);
	}
	
	public void refresh() {
		data.clear();
		data.addAll(TeacherLeaveOutOpr.getAll());

		for (TableColumn<TeacherLeaveOutBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
	public void clear() {
		data.clear();
		for (TableColumn<TeacherLeaveOutBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
}
