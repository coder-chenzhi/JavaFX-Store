package bean;

public class RoomBean {
	private String roomID;
	private String name;
	private int volume;
	private String other;

	public RoomBean(String roomID, String name, int volume, String other) {
		super();
		this.roomID = roomID;
		this.name = name;
		this.volume = volume;
		this.other = other;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
