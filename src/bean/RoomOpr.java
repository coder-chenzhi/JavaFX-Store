package bean;

import database.*;
import util.ConvertID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomOpr {
	static DataBaseIO db = new DataBaseIO();

	public static String getNextRoomID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(roomID) from room";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				id = rs.getInt("max(roomID)");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return ConvertID.convertToString(id, 3);
	}

	public static void insertRoom(RoomBean room) {
		Object params[] = { room.getName(), room.getVolume(), room.getOther() };
		String sql = "insert into room (name,volume,other) values(?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void deleteRoom(String roomID) {
		Object params[] = {roomID};
		String sql = "delete from room where roomID = ?";
		db.executeSqlWithoutResult(sql, params);
	}
	
	public static RoomBean getRoomByID(String roomID) {
		RoomBean room = new RoomBean();
		Object params[] = {roomID};
		String sql = "select * from room where roomID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				room.setRoomID(ConvertID.convertToString(rs.getInt("roomID"), 3));
				System.out.println(rs.getString("name"));
				room.setName(rs.getString("name"));
				room.setOther(rs.getString("other"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return room;
	}
	
	public static ArrayList<RoomBean> getAllRooms() {
		ArrayList<RoomBean> rooms = new ArrayList<RoomBean>();
		Object params[] = {};
		String sql = "select * from room";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				RoomBean room = new RoomBean();
				room.setRoomID(ConvertID.convertToString(rs.getInt("roomID"), 3));
				System.out.println(rs.getString("name"));
				room.setName(rs.getString("name"));
				room.setOther(rs.getString("other"));
				rooms.add(room);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return rooms;
	}

	public static void main(String[] args) {
		// String test = new String(new char[3]).replace("\0", "0");
/*		RoomBean room = new RoomBean();
		room.setName("XIAOΩÃ “");
		room.setVolume(60);
		room.setOther("test");
		RoomOpr.insertRoom(room);
		System.out.println(RoomOpr.getAllRooms());
*/		
		System.out.println(RoomOpr.getRoomByID("002"));
		//System.out.println(Integer.parseInt("002"));
	}
}
