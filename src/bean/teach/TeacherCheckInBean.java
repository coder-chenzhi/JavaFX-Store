package bean.teach;

public class TeacherCheckInBean {
	private int teacherID;
	private String checkDate;
	private String checkTime;
	private String type;

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TeacherCheckInBean [teacherID=" + teacherID + ", checkDate="
				+ checkDate + ", checkTime=" + checkTime + ", type=" + type
				+ "]";
	}

}
