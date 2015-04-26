package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.market.PurchaseOrderBean;
import bean.market.PurchaseOrderOpr;
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

public class PurchaseOrdersController extends BorderPane implements
		Initializable {

	@FXML
	private TableView<PurchaseOrderShow> tableView = new TableView<PurchaseOrderShow>();

	@FXML
	private Button add;

	ObservableList<PurchaseOrderShow> data = FXCollections
			.observableArrayList();

	static final String properties[] = { "orderID", "supplierID",
			"totalCost", "commitDate" };

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for (int i = 0; i < properties.length; i++) {
			TableColumn col = new TableColumn(properties[i]);
			col.setCellValueFactory(new PropertyValueFactory<PurchaseOrderShow, String>(
					properties[i]));
			tableView.getColumns().add(col);
		}

		add.setOnAction(event -> {
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) event
					.getSource()).getScene().getWindow();
			// OR
			// System.out.println(stageTheEventSourceNodeBelongs);
			// Stage stageTheLabelBelongs = (Stage)
			// label.getScene().getWindow();
			// System.out.println(stageTheLabelBelongs);
			// these two of them return the same stage
			// Swap screen
			ArrayList<PurchaseOrderBean> rowData = null;
			Stage popup = new Stage();
			PurchaseOrderProfileController purchaseOrderProfileCtrl = null;
			AnchorPane page = null;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("PurchaseOrderProfile.fxml"));
			try {
				page = (AnchorPane) loader.load();
				purchaseOrderProfileCtrl = (PurchaseOrderProfileController) loader
						.getController();
				purchaseOrderProfileCtrl.setPurchaseOrders(rowData);
				purchaseOrderProfileCtrl.setPurchaseOrderController(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			popup.initModality(Modality.WINDOW_MODAL);
			popup.setScene(new Scene(page));
			popup.initOwner(stageTheEventSourceNodeBelongs);
			popup.show();
		});

		tableView
				.setRowFactory(tv -> {
					TableRow<PurchaseOrderShow> row = new TableRow<>();
					row.setOnMouseClicked(event -> {
						if (event.getClickCount() == 2 && (!row.isEmpty())) {
							PurchaseOrderShow rowData = row.getItem();
							System.out.println("rowData: " + rowData);
							Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) event
									.getSource()).getScene().getWindow();
							// OR
							// System.out.println(stageTheEventSourceNodeBelongs);
							// Stage stageTheLabelBelongs = (Stage)
							// label.getScene().getWindow();
							// System.out.println(stageTheLabelBelongs);
							// these two of them return the same stage
							// Swap screen
							Stage popup = new Stage();
							PurchaseOrderProfileController purchaseOrderProfileCtrl = null;
							AnchorPane page = null;
							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(Main.class
									.getResource("PurchaseOrderProfile.fxml"));
							try {
								page = (AnchorPane) loader.load();
								purchaseOrderProfileCtrl = (PurchaseOrderProfileController) loader
										.getController();
								ArrayList<PurchaseOrderBean> purchaseOrders = PurchaseOrderOpr
										.getByID(rowData.getOrderID());
								purchaseOrderProfileCtrl
										.setPurchaseOrders(purchaseOrders);
								purchaseOrderProfileCtrl
										.setPurchaseOrderController(this);
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
					return row;
				});

		data.addAll();

		for (PurchaseOrderBean purchaseOrder : PurchaseOrderOpr
				.getAll()) {
			data.add(new PurchaseOrderShow(purchaseOrder));
		}

		tableView.setItems(data);
	}

	public void refresh() {
		/*
		 * ArrayList<Integer> ids = new ArrayList<>(); for (PurchaseOrderBean
		 * purchaseOrder : data) { ids.add(purchaseOrder.getPurchaseOrderID());
		 * } data.clear(); for (Integer id : ids) {
		 * data.add(PurchaseOrderOpr.getPurchaseOrderByID(id)); }
		 */
		for (TableColumn<PurchaseOrderShow, ?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}

	public void clear() {
		data.clear();
		/*
		 * for (TableColumn<PurchaseOrderBean,?> item : tableView.getColumns())
		 * { item.setVisible(false); item.setVisible(true); }
		 */
	}

}
