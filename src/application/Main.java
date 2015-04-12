package application;
	
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.PasswordBean;
import bean.PasswordOpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    private PasswordBean loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 1280.0;
    private final double MINIMUM_WINDOW_HEIGHT = 720.0;
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("琴行管理系统");
		primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        gotoLogin();
        primaryStage.show();
	}
	
	public boolean userLogging(int userId, String type, String password){
        if (PasswordOpr.getPasswordByID(userId, type).equals(password)) {
            loggedUser = new PasswordBean();
            loggedUser.setId(userId); loggedUser.setType(type); loggedUser.setPassword(password);
            gotoRootLayout();
            return true;
        } else {
            return false;
        }
    }
	
    private void gotoLogin() {
        try {
            LoginController login = (LoginController) 
            		replaceSceneContent("Login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	/**
     * Initializes the root layout.
     */
    public void gotoRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            BorderPane page = (BorderPane) loader.load();
            MenuController menu = (MenuController) loader.getController();
            menu.setApp(this);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        this.primaryStage.setScene(scene);
        this.primaryStage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
