package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.market.SellOrderBean;
import bean.market.SellOrderOpr;
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

public class SellOrdersController extends BorderPane implements
		Initializable {

	@FXML
	private TableView<SellOrderShow> tableView = new TableView<SellOrderShow>();

	@FXML
	private Button add;

	ObservableList<SellOrderShow> data = FXCollections
			.observableArrayList();

	static final String properties[] = { "orderID", "customerID",
			"totalCost", "commitDate" };

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for (int i = 0; i < properties.length; i++) {
			TableColumn col = new TableColumn(properties[i]);
			col.setCellValueFactory(new PropertyValueFactory<SellOrderShow, String>(
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
			ArrayList<SellOrderBean> rowData = null;
			Stage popup = new Stage();
			SellOrderProfileController purchaseOrderProfileCtrl = null;
			AnchorPane page = null;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("SellOrderProfile.fxml"));
			try {
				page = (AnchorPane) loader.load();
				purchaseOrderProfileCtrl = (SellOrderProfileController) loader
						.getController();
				purchaseOrderProfileCtrl.setSellOrders(rowData);
				purchaseOrderProfileCtrl.setSellOrderController(this);
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
					TableRow<SellOrderShow> row = new TableRow<>();
					row.setOnMouseClicked(event -> {
						if (event.getClickCount() == 2 && (!row.isEmpty())) {
							SellOrderShow rowData = row.getItem();
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
							SellOrderProfileController purchaseOrderProfileCtrl = null;
							AnchorPane page = null;
							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(Main.class
									.getResource("SellOrderProfile.fxml"));
							try {
								page = (AnchorPane) loader.load();
								purchaseOrderProfileCtrl = (SellOrderProfileController) loader
										.getController();
								ArrayList<SellOrderBean> purchaseOrders = SellOrderOpr
										.getByID(Integer.parseInt(rowData.getOrderID()));
								System.out.println("SellOrders" + purchaseOrders);
								purchaseOrderProfileCtrl
										.setSellOrders(purchaseOrders);
								purchaseOrderProfileCtrl
										.setSellOrderController(this);
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

		for (Integer orderID : SellOrderOpr.getUniqueID()) {
			data.add(new SellOrderShow(orderID));
		}

		tableView.setItems(data);
	}

	public void refresh() {
		/*
		 * ArrayList<Integer> ids = new ArrayList<>(); for (SellOrderBean
		 * purchaseOrder : data) { ids.add(purchaseOrder.getSellOrderID());
		 * } data.clear(); for (Integer id : ids) {
		 * data.add(SellOrderOpr.getSellOrderByID(id)); }
		 */
		for (TableColumn<SellOrderShow, ?> item : tableView.getColumns()) {
			item.setVisible(false);
			item.setVisible(true);
		}
	}

	public void clear() {
		data.clear();
		/*
		 * for (TableColumn<SellOrderBean,?> item : tableView.getColumns())
		 * { item.setVisible(false); item.setVisible(true); }
		 */
	}

}
