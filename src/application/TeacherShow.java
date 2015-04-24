package application;

import bean.teach.TeacherBean;

public class TeacherShow {
	private int teacherID;
	private String realName;
	private String sex;
	private String birthday;
	private String major;
	private String phone;
	private String enrollDay;
	private boolean status;
	
	TeacherShow(TeacherBean teacher) {
		this.teacherID = teacher.getTeacherID();
		this.realName = teacher.getRealName();
		this.sex = teacher.getSex();
		this.birthday = teacher.getBirthday();
		this.major = teacher.getMajor();
		this.phone = teacher.getPhone();
		this.enrollDay = teacher.getEnrollDay();
		this.status = teacher.getStatus();
	}
	
	public static TeacherShow TeacherBeanToShow(TeacherBean teacher) {
		return new TeacherShow(teacher);
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEnrollDay() {
		return enrollDay;
	}

	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
