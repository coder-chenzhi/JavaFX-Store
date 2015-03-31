package bean;

public class StudentLeaveOutBean {
	private String studentID;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String other;

	public String getTeacherID() {
		return studentID;
	}

	public void setTeacherID(String teacherID) {
		this.studentID = teacherID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
