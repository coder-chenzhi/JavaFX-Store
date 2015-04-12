package bean;

public class ClassRecordBean {
	private int CourseID;
	private int ClassID;
	private int StudentID;
	private String Status;

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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getClassID() {
		return ClassID;
	}

	public void setClassID(int classID) {
		ClassID = classID;
	}

	@Override
	public String toString() {
		return "ClassRecordBean [CourseID=" + CourseID + ", ClassID="
				+ ClassID + ", StudentID=" + StudentID + ", Status=" + Status
				+ "]\n";
	}

}
