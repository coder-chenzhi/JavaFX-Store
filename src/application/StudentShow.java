package application;

import bean.teach.StudentBean;

public class StudentShow {
	private int studentID;
	private String realName;
	private String sex;
	private String birthday;
	private String major;
	private String enrollDay;
	private double balance;
	private boolean status;
	
	StudentShow(StudentBean student) {
		this.studentID = student.getStudentID();
		this.realName =student.getRealName();
		this.sex = student.getSex();
		this.birthday = student.getBirthday();
		this.major = student.getMajor();
		this.enrollDay = student.getEnrollDay();
		this.balance = student.getBalance();
		this.status = student.getStatus();
	}
	
	public static StudentShow StudentBeanToShow(StudentBean student) {
		return new StudentShow(student);
	}
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEnrollDay() {
		return enrollDay;
	}

	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}
	
}
