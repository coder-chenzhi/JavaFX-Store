package bean;

public class CourseRecordBean {
	private int CourseID;
	private int StudentID;
	private int Status;

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "CourseRecordBean [CourseID=" + CourseID + ", StudentID="
				+ StudentID + ", Status=" + Status + "]\n";
	}
	
	
}
