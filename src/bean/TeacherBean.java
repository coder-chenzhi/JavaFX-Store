package bean;

public class TeacherBean {
	private int teacherID;
	private String realName;
	private String sex;
	private String birthday;
	private String major;
	private String level;
	private String education;
	private String school;
	private String identifyCard;
	private String phone;
	private String address;
	private String enrollDay;
	private boolean status;

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getIdentifyCard() {
		return identifyCard;
	}

	public void setIdentifyCard(String identifyCard) {
		this.identifyCard = identifyCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnrollDay() {
		return enrollDay;
	}

	public void setEnrollDay(String enrollDay) {
		this.enrollDay = enrollDay;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TeacherBean [teacherID=" + teacherID + ", realName=" + realName
				+ ", sex=" + sex + ", birthday=" + birthday + ", major="
				+ major + ", level=" + level + ", education=" + education
				+ ", school=" + school + ", identifyCard=" + identifyCard
				+ ", phone=" + phone + ", address=" + address + ", enrollDay="
				+ enrollDay + ", status=" + status + "]\n";
	}

}
