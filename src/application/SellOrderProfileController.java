package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bean.market.SellOrderBean;
import bean.market.SellOrderOpr;
import util.Time;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SellOrderProfileController extends AnchorPane implements
		Initializable {

	private boolean isShow;

	private String purchaseOrderID;

	@FXML
	private TableView<SellOrderBean> tableView = new TableView<SellOrderBean>();

	@FXML
	private Button add;

	@FXML
	private Button save;

	ObservableList<SellOrderBean> data = FXCollections
			.observableArrayList();

	static final String properties[] = { "orderID", "goodID", "customerID",
			"amount", "price", "commitDate", "status" };

	private SellOrdersController purchaseOrderController;

	public void setSellOrders(ArrayList<SellOrderBean> purchaseOrders) {
		if (purchaseOrders != null) {
			isShow = true;
			this.data.addAll(purchaseOrders);
			purchaseOrderID = purchaseOrders.get(0).getOrderID();
		} else {
			purchaseOrderID = String.valueOf(SellOrderOpr.getNextSellOrderID());
		}

	}

	public SellOrdersController getSellOrderController() {
		return purchaseOrderController;
	}

	public void setSellOrderController(
			SellOrdersController parentController) {
		this.purchaseOrderController = parentController;
	}

	public SellOrderProfileController() {
		// TODO Auto-generated constructor stub
		super();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		tableView.setEditable(true);
		Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {
				return new EditingCell();
			}
		};

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		TableColumn orderID = new TableColumn("orderID");
		orderID.setPrefWidth(100);
		tableView.getColumns().add(orderID);
		orderID.setCellValueFactory(
                    new PropertyValueFactory<SellOrderBean, String>("orderID"));
		
		TableColumn goodID = new TableColumn("goodID");
        goodID.setMinWidth(100);
        goodID.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("goodID"));
        goodID.setCellFactory(cellFactory);
        goodID.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setGoodID(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(goodID);
        
        TableColumn customerID = new TableColumn("customerID");
        customerID.setMinWidth(100);
        customerID.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("customerID"));
        customerID.setCellFactory(cellFactory);
        customerID.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                @Override
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCustomerID(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(customerID);
        
        
        TableColumn amount = new TableColumn("amount");
        amount.setMinWidth(100);
        amount.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("amount"));
        amount.setCellFactory(cellFactory);
        amount.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                @Override
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAmount(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(amount);
        
        TableColumn price = new TableColumn("price");
        price.setMinWidth(100);
        price.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("price"));
        price.setCellFactory(cellFactory);
        price.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                @Override
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPrice(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(price);
        
        TableColumn commitDate = new TableColumn("commitDate");
        commitDate.setMinWidth(100);
        commitDate.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("commitDate"));
        commitDate.setCellFactory(cellFactory);
        commitDate.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                @Override
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCommitDate(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(commitDate);
        
        TableColumn other = new TableColumn("other");
        other.setMinWidth(100);
        other.setCellValueFactory(
            new PropertyValueFactory<SellOrderBean, String>("other"));
        other.setCellFactory(cellFactory);
        other.setOnEditCommit(
            new EventHandler<CellEditEvent<SellOrderBean, String>>() {
                @Override
                public void handle(CellEditEvent<SellOrderBean, String> t) {
                    ((SellOrderBean) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setOther(t.getNewValue());
                }
             }
        );
        tableView.getColumns().add(other);
        
		add.setOnAction(event -> {
			SellOrderBean order = new SellOrderBean();
			order.setOrderID(purchaseOrderID);
			order.setCommitDate(Time.getDate());
			data.add(order);
		});

		save.setOnAction(event -> {
			if (isShow) {
				Stage popup = new Stage();
				BorderPane page = new BorderPane();
				page.setPrefSize(200,100);
				Label label = new Label("已下单商品不能新增和修改！！！");
				page.setCenter(label);
				popup.initModality(Modality.WINDOW_MODAL);
	            popup.setScene(new Scene(page));
	            popup.show();
			} else {
				SellOrderOpr.deleteSellOrder(Integer.parseInt(purchaseOrderID));
				for (SellOrderBean order : data) {
					SellOrderOpr.insertSellOrder(order);
				}
			}
		});
		
		data.addAll();

		tableView.setItems(data);
	}

	public void refresh() {
		/*
		 * ArrayList<Integer> ids = new ArrayList<>(); for (SellOrderBean
		 * purchaseOrder : data) { ids.add(purchaseOrder.getSellOrderID());
		 * } data.clear(); for (Integer id : ids) {
		 * data.add(SellOrderOpr.getSellOrderByID(id)); }
		 */
		for (TableColumn<SellOrderBean, ?> item : tableView.getColumns()) {
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

	class EditingCell extends TableCell<SellOrderBean, String> {

		private TextField textField;

		public EditingCell() {
		}

		@Override
		public void startEdit() {
			if (!isEmpty()) {
				super.startEdit();
				createTextField();
				setText(null);
				setGraphic(textField);
				textField.selectAll();
			}
		}

		@Override
		public void cancelEdit() {
			super.cancelEdit();

			setText((String) getItem());
			setGraphic(null);
		}

		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				if (isEditing()) {
					if (textField != null) {
						textField.setText(getString());
					}
					setText(null);
					setGraphic(textField);
				} else {
					setText(getString());
					setGraphic(null);
				}
			}
		}

		private void createTextField() {
			textField = new TextField(getString());
			textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()
					* 2);
			textField.focusedProperty().addListener(
					new ChangeListener<Boolean>() {
						@Override
						public void changed(
								ObservableValue<? extends Boolean> arg0,
								Boolean arg1, Boolean arg2) {
							if (!arg2) {
								commitEdit(textField.getText());
							}
						}
					});
		}

		private String getString() {
			return getItem() == null ? "" : getItem().toString();
		}
	}

	public static void main(String[] args) {

	}

}
