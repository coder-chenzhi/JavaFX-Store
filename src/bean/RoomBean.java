package bean;

public class RoomBean {
	private String roomID;
	private String name;
	private int volume;
	private String other;

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

	@Override
	public String toString() {
		return "RoomBean [roomID=" + roomID + ", name=" + name + ", volume="
				+ volume + ", other=" + other + "]";
	}

}
