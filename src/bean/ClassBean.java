package bean;

public class ClassBean {
	private int courseID;
	private int classID;
	private int teacherID;
	private String onDate;
	private String periodID;
	private int roomID;
	private String status;

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

	public String getPeriodID() {
		return periodID;
	}

	public void setPeriodID(String periodID) {
		this.periodID = periodID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClassBean [courseID=" + courseID + ", classID=" + classID
				+ ", teacherID=" + teacherID + ", onDate=" + onDate
				+ ", periodID=" + periodID + ", roomID=" + roomID + ", status="
				+ status + "]\n";
	}

}
