package bean.teach;

public class StudentBean {
	private int studentID;
	private String realName;
	private String sex;
	private String birthday;
	private String major;
	private String level;
	private String school;
	private String classGrade;
	private String hobby;
	private String instrument;
	private String parentsName;
	private String phone;
	private String address;
	private String enrollDay;
	private String classType;
	private double balance;
	private boolean status;
	private String other;
	
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClassGrade() {
		return classGrade;
	}

	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "StudentBean [studentID=" + studentID + ", realName=" + realName
				+ ", sex=" + sex + ", birthday=" + birthday + ", major="
				+ major + ", level=" + level + ", school=" + school
				+ ", classGrade=" + classGrade + ", hobby=" + hobby
				+ ", instrument=" + instrument + ", parentsName=" + parentsName
				+ ", phone=" + phone + ", address=" + address + ", enrollDay="
				+ enrollDay + ", classType=" + classType + ", balance="
				+ balance + ", status=" + status + ", other=" + other + "]\n";
	}

}
