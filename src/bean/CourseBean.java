package bean;

public class CourseBean {
	private int courseID;
	private int teacherID;
	private int roomID;
	private String periodID;
	private String startDate;
	private int weeks;
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

	public String getPeriodID() {
		return periodID;
	}

	public void setPeriodID(String periodTime) {
		this.periodID = periodTime;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
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
				+ ", roomID=" + roomID + ", periodID=" + periodID
				+ ", startDate=" + startDate + ", weeks=" + weeks + ", type="
				+ type + ", instrument=" + instrument + ", expense=" + expense
				+ ", volume=" + volume + ", selected=" + selected + ", other="
				+ other + "]\n";
	}

}
