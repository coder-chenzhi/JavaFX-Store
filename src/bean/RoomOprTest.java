package bean;

public class RoomOprTest {
	public static void testInsert() {
		RoomBean room = new RoomBean();
		room.setRoomID(201);
		room.setName("�����");
		room.setVolume(30);
		room.setOther("test");
		RoomOpr.insertRoom(room);
		room.setRoomID(202);
		room.setName("С����");
		room.setVolume(10);
		room.setOther("test");
		RoomOpr.insertRoom(room);
		room.setRoomID(301);
		room.setName("С����");
		room.setVolume(10);
		room.setOther("��ǰԤԼ");
		RoomOpr.insertRoom(room);
		room.setRoomID(102);
		room.setName("С����");
		room.setVolume(10);
		room.setOther("��ǰԤԼ");
		RoomOpr.insertRoom(room);
	}
	
	public static void testGetAll() {
		System.out.println(RoomOpr.getAllRooms());
	}
	
	public static void main(String[] args) {
		testInsert();
		testGetAll();
	}
}
