package bean;

public class Classes {
	private int courseID;
	private int classID;
	private int teacherID;
	private String onDate;
	private int periodID;
	private int roomID;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getOnDate() {
		return onDate;
	}

	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	@Override
	public String toString() {
		return "Classes [courseID=" + courseID + ", classID=" + classID
				+ ", teacherID=" + teacherID + ", onDate=" + onDate
				+ ", periodID=" + periodID + ", roomID=" + roomID + "]\n";
	}

}
