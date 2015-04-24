package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import bean.teach.RoomBean;
import bean.teach.RoomOpr;
import util.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RoomProfileController extends AnchorPane implements
		Initializable {
	
	private boolean isUpdate;
	
	@FXML
	private TextField roomID;

	@FXML
	private TextField name;

	@FXML
	private TextField volume;
	
	@FXML
	private TextField other;

	private RoomBean room;
	
	private RoomsController roomController;
	
	public RoomBean getRoom() {
		return room;
	}

	public void setRoom(RoomBean room) {
		if (room == null) {
			isUpdate = false;
			this.room = new RoomBean();
			
		} else {
			isUpdate = true;
			this.room = room;
			
			System.out.println("Room Profile Page:\n" + this.room);
			roomID.setText(String.valueOf(this.room.getRoomID()));
			name.setText(this.room.getName());
			volume.setText(String.valueOf(this.room.getVolume()));

			other.setText(this.room.getOther());
		}
		
		
	}

	public RoomsController getRoomController() {
		return roomController;
	}

	public void setRoomController(RoomsController parentController) {
		this.roomController = parentController;
	}

	public RoomProfileController() {
		// TODO Auto-generated constructor stub
		super();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void processSave() {
		this.room.setRoomID(Integer.parseInt(roomID.getText()));
		this.room.setName(name.getText());
		this.room.setVolume(Integer.parseInt(volume.getText()));
		this.room.setOther(other.getText());

		
		//System.out.println("Press Save!!!");
		this.roomController.refresh();
		if (isUpdate) {
			RoomOpr.updateRoom(room);
		} else {
			RoomOpr.insertRoom(room);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
