package bean;

public class TeacherCheckInBean {
	private String teacherID;
	private String checkDate;
	private String checkTime;
	private String type;

	public TeacherCheckInBean(String teacherID, String checkDate,
			String checkTime, String type) {
		super();
		this.teacherID = teacherID;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.type = type;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
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

}
