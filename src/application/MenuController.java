package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController extends BorderPane implements Initializable {

	@FXML
	private TabPane tabs;

	@FXML
	private MenuItem quit;
	
	/* ѧ������ */
	@FXML
	private MenuItem students;
	
	/* ��ʦ���� */
	@FXML
	private MenuItem teachers;
	
	/* �˿͵��� */
	@FXML
	private MenuItem customers;
	
	/* �����̵��� */
	@FXML
	private MenuItem suppliers;
	
	@FXML
	private MenuItem manageCourses;

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

	/* ѧ���Ͽμ�¼ */
	@FXML
	private MenuItem tableStudentTakeCourse;
	
	/* ��� */
	@FXML
	private MenuItem stocks;
	
	/* ��Ʒ */
	@FXML
	private MenuItem goods;
	
	/* ѧ���Ͽμ�¼ */
	@FXML
	private MenuItem purchase;
	
	/* ѧ���Ͽμ�¼ */
	@FXML
	private MenuItem sell;
	
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
		String text = ((MenuItem) (event.getSource())).getText();
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
			tab1.setText("ѧ������");
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
			tab1.setText("��ʦ����");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("�˿͵���")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CustomersMain.fxml"));
			CustomersController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (CustomersController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("�˿͵���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("�����̵���")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("SuppliersMain.fxml"));
			SuppliersController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (SuppliersController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("�����̹���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("���")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("StocksMain.fxml"));
			StocksController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (StocksController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("��Ʒ")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("GoodsMain.fxml"));
			GoodsController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (GoodsController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("��Ʒ����");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("���ҹ���")) {
			if (this.application.getLoggedUser().getType().equals("����Ա")) {
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
				tab1.setText("���ҹ���");
				tab1.setContent(page);
				tabs.getTabs().add(tab1);
			} else {
				Stage popup = new Stage();
				BorderPane page = new BorderPane();
				page.setPrefSize(200,100);
				Label label = new Label("Ȩ�޲��㣡����");
				page.setCenter(label);
				popup.initModality(Modality.WINDOW_MODAL);
	            popup.setScene(new Scene(page));
	            popup.initOwner(this.application.getPrimaryStage());;
	            popup.show();
			}
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
			tab1.setText("ʱ�ι���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("�γ̹���")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CoursesMain.fxml"));
			CoursesController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (CoursesController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("�γ̹���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("����")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("PurchaseOrdersMain.fxml"));
			PurchaseOrdersController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (PurchaseOrdersController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("����");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("����")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("SellOrdersMain.fxml"));
			SellOrdersController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (SellOrdersController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("����");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("ѧ�����")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("StudentLeaveMain.fxml"));
			StudentLeaveController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (StudentLeaveController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("ѧ�����");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("��ʦ���")) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("TeacherLeaveMain.fxml"));
			TeacherLeaveController menu = null;
			AnchorPane page = null;
			try {
				page = (AnchorPane) loader.load();
				menu = (TeacherLeaveController) loader.getController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tab tab1 = new Tab();
			tab1.setText("��ʦ���");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("������")) {
			try {
				System.out.println("Opening calc");
				Runtime runTime = Runtime.getRuntime();
				Process process = runTime.exec("calc");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (text.equals("���±�")) {
			try {
				System.out.println("Opening notepad");
				Runtime runTime = Runtime.getRuntime();
				Process process = runTime.exec("notepad");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (text.equals("�˳�")) {
			tabs = null;
			this.application.gotoLogin();
		}

	}

}
