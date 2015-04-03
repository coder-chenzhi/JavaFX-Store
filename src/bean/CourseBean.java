package bean;

public class CourseBean {
	private int courseID;
	private int teacherID;
	private int roomID;
	private int periodID;
	private String startDate;
	private int week;
	private String type;
	private String instrument;
	private double expense;
	private int volume;
	private int selected;
	private String other;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getPeriod() {
		return periodID;
	}

	public void setPeriod(int periodTime) {
		this.periodID = periodTime;
	}

	public float getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
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

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "CourseBean [courseID=" + courseID + ", teacherID=" + teacherID
				+ ", launchDate=" + startDate + ", launchTime=" + periodID
				+ ", length=" + week + ", type=" + type + ", instrument="
				+ instrument + ", roomID=" + roomID + ", expense=" + expense
				+ ", volume=" + volume + ", selected=" + selected + ", other="
				+ other + "]\n";
	}

}
