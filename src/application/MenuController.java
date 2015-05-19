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
	
	/* 学生档案 */
	@FXML
	private MenuItem students;
	
	/* 教师档案 */
	@FXML
	private MenuItem teachers;
	
	/* 顾客档案 */
	@FXML
	private MenuItem customers;
	
	/* 供货商档案 */
	@FXML
	private MenuItem suppliers;
	
	@FXML
	private MenuItem manageCourses;

	/* 教室管理 */
	@FXML
	private MenuItem manageRooms;

	/* 时段管理 */
	@FXML
	private MenuItem managePeriods;

	/* 教师考勤 */
	@FXML
	private MenuItem teacherCheckIn;

	/* 教师请假 */
	@FXML
	private MenuItem teacherLeaveOut;

	/* 学生请假 */
	@FXML
	private MenuItem studentLeaveOut;

	/* 教师打卡记录 */
	@FXML
	private MenuItem tableTeacherCheckIn;

	/* 学生上课记录 */
	@FXML
	private MenuItem tableStudentTakeCourse;
	
	/* 库存 */
	@FXML
	private MenuItem stocks;
	
	/* 商品 */
	@FXML
	private MenuItem goods;
	
	/* 学生上课记录 */
	@FXML
	private MenuItem purchase;
	
	/* 学生上课记录 */
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
		if (text.equals("学生档案")) {
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
			tab1.setText("学生档案");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("教师档案")) {
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
			tab1.setText("教师档案");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("顾客档案")) {
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
			tab1.setText("顾客档案");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("供货商档案")) {
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
			tab1.setText("供货商管理");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("库存")) {
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
			tab1.setText("库存");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("商品")) {
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
			tab1.setText("商品管理");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("教室管理")) {
			if (this.application.getLoggedUser().getType().equals("管理员")) {
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
				tab1.setText("教室管理");
				tab1.setContent(page);
				tabs.getTabs().add(tab1);
			} else {
				Stage popup = new Stage();
				BorderPane page = new BorderPane();
				page.setPrefSize(200,100);
				Label label = new Label("权限不足！！！");
				page.setCenter(label);
				popup.initModality(Modality.WINDOW_MODAL);
	            popup.setScene(new Scene(page));
	            popup.initOwner(this.application.getPrimaryStage());;
	            popup.show();
			}
		} else if (text.equals("时段管理")) {
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
			tab1.setText("时段管理");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("课程管理")) {
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
			tab1.setText("课程管理");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("进货")) {
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
			tab1.setText("进货");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("销售")) {
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
			tab1.setText("销售");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("学生请假")) {
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
			tab1.setText("学生请假");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("教师请假")) {
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
			tab1.setText("教师请假");
			tab1.setContent(page);
			tabs.getTabs().add(tab1);
		} else if (text.equals("计算器")) {
			try {
				System.out.println("Opening calc");
				Runtime runTime = Runtime.getRuntime();
				Process process = runTime.exec("calc");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (text.equals("记事本")) {
			try {
				System.out.println("Opening notepad");
				Runtime runTime = Runtime.getRuntime();
				Process process = runTime.exec("notepad");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (text.equals("退出")) {
			tabs = null;
			this.application.gotoLogin();
		}

	}

}
