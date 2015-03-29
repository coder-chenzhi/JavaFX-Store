package bean;

public class CourseRecordBean {
	private String CourseID;
	private String StudentID;
	private String Status;

	public CourseRecordBean(String courseID, String studentID, String status) {
		super();
		CourseID = courseID;
		StudentID = studentID;
		Status = status;
	}

	public String getCourseID() {
		return CourseID;
	}

	public void setCourseID(String courseID) {
		CourseID = courseID;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
