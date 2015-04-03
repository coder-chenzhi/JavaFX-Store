package bean;

import database.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomOpr {
	static DataBaseIO db = new DataBaseIO();

	public static void insertRoom(RoomBean room) {
		Object params[] = { room.getRoomID(), room.getName(), room.getVolume(),
				room.getOther() };
		String sql = "insert into rooms (roomID, name,volume,other) values(?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void deleteRoom(int roomID) {
		Object params[] = { roomID };
		String sql = "delete from rooms where roomID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static RoomBean getRoomByID(int roomID) {
		RoomBean room = new RoomBean();
		Object params[] = { roomID };
		String sql = "select * from rooms where roomID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				room.setRoomID(rs.getInt("roomID"));
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

	public static int getVolumeByID(int roomID) {
		int volume  = 0;
		Object params[] = { roomID };
		String sql = "select volume from rooms where roomID = ?";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				volume = rs.getInt("volume");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		return volume;
	}
	
	public static ArrayList<RoomBean> getAllRooms() {
		ArrayList<RoomBean> rooms = new ArrayList<RoomBean>();
		Object params[] = {};
		String sql = "select * from rooms";
		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {

				RoomBean room = new RoomBean();
				room.setRoomID(rs.getInt("roomID"));
				room.setName(rs.getString("name"));
				room.setOther(rs.getString("other"));
				room.setVolume(rs.getInt("volume"));
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
		RoomBean room = new RoomBean();
		room.setRoomID(201);
		room.setName("¥ÛΩÃ “");
		room.setVolume(100);
		room.setOther("test");
		RoomOpr.insertRoom(room);
		System.out.println(RoomOpr.getAllRooms());

		System.out.println(RoomOpr.getRoomByID(405));
		// System.out.println(Integer.parseInt("002"));
	}
}
