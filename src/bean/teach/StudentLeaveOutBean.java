package bean.teach;

public class StudentLeaveOutBean {
	private int studentID;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String other;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int teacherID) {
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

	@Override
	public String toString() {
		return "StudentLeaveOutBean [studentID=" + studentID + ", startDate="
				+ startDate + ", startTime=" + startTime + ", endDate="
				+ endDate + ", endTime=" + endTime + ", other=" + other + "]";
	}

}
