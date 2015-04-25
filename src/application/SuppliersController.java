package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.market.SupplierBean;
import bean.market.SupplierOpr;
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

public class SuppliersController extends BorderPane implements Initializable{

	@FXML
	private TableView<SupplierBean> tableView = new TableView<SupplierBean>();
	
	@FXML
	private Button add;
	
	@FXML
	private Button refresh;
	
	
	ObservableList<SupplierBean> data = FXCollections.observableArrayList();
	
	static final String properties[] = {
		"supplierID",
		"supplierName",
		"contactName",
		"contactPhone",
		"contactAddress",
		"other"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(int i=0; i<properties.length; i++){
            TableColumn col = new TableColumn(properties[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<SupplierBean, String>(
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
			SupplierBean rowData = null;
            Stage popup = new Stage();
            SupplierProfileController supplierProfileCtrl = null;
            AnchorPane page = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("supplierProfile.fxml"));
			try {
	            page = (AnchorPane) loader.load();
	            supplierProfileCtrl = (SupplierProfileController) loader.getController();
	            supplierProfileCtrl.setSupplier(rowData);
	            supplierProfileCtrl.setSupplierController(this);
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
            TableRow<SupplierBean> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                	SupplierBean rowData = row.getItem();
                	Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    // OR
                    // System.out.println(stageTheEventSourceNodeBelongs);
                    // Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
                    // System.out.println(stageTheLabelBelongs);
                    // these two of them return the same stage
                    // Swap screen
                    Stage popup = new Stage();
                    SupplierProfileController supplierProfileCtrl = null;
                    AnchorPane page = null;
                    FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Main.class.getResource("supplierProfile.fxml"));
					try {
			            page = (AnchorPane) loader.load();
			            supplierProfileCtrl = (SupplierProfileController) loader.getController();
			            supplierProfileCtrl.setSupplier(rowData);
			            supplierProfileCtrl.setSupplierController(this);
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
        
        data.addAll(SupplierOpr.getAllSuppliers());
        
        tableView.setItems(data);
	}
	
	public void refresh() {
		System.out.println("refresh");
		data.clear();
		data.addAll(SupplierOpr.getAllSuppliers());

		for (TableColumn<SupplierBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
	public void clear() {
		data.clear();
		for (TableColumn<SupplierBean,?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}
	
}
