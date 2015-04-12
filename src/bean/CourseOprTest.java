package bean;

public class CourseOprTest {
	public static void testInsert() {
		CourseBean course = new CourseBean();
		//�Ѿ�����
		course.setTeacherID(2015001);
		course.setRoomID(102);
		course.setPeriod("�ڶ��ڿ�");
		course.setStartDate("20140304");
		course.setWeeks(16);
		course.setType("ȫ��");
		course.setInstrument("����");
		course.setExpense(1000);
		course.setVolume(20);
		CourseOpr.insertCourse(course);
		//�����Ͽ�
		course.setTeacherID(2015002);
		course.setRoomID(201);
		course.setPeriod("�����ڿ�");
		course.setStartDate("20150304");
		course.setWeeks(4);
		course.setType("���˿�");
		course.setInstrument("���ӹ�");
		course.setExpense(1000);
		course.setVolume(40);
		CourseOpr.insertCourse(course);
		//��û��ʼ
		course.setTeacherID(2015002);
		course.setRoomID(201);
		course.setPeriod("�ڶ��ڿ�");
		course.setStartDate("20150601");
		course.setWeeks(8);
		course.setType("���˿�");
		course.setInstrument("����");
		course.setExpense(1000);
		course.setVolume(2);
		CourseOpr.insertCourse(course);
	}
	
	public static void testGetAll(int status) {
		System.out.println(CourseOpr.getAllCourses(status));
	}
	
	public static void testGetByInstrument(String instrument, int status) {
		System.out.println(CourseOpr.getCoursesByInstrument(instrument, status));
	}
	
	public static void testGetByType(String type, int status) {
		System.out.println(CourseOpr.getCoursesByType(type, status));
	}
	
	public static void testGetAllInstrument() {
		System.out.println(CourseOpr.getAllInstruments());
	}
	
	public static void testGetByTeacherID(int teacherID, int status) {
		System.out.println(CourseOpr.getCoursesByTeacherID(teacherID, status));
	}
	
	public static void testGetCourseByCourseID(int courseID) {
		System.out.println(CourseOpr.getCourseByCourseID(courseID));
	}
	
	public static void testDeleteCourseByCourseID(int CourseID) {
		CourseOpr.deleteCourse(CourseID);
	}
	
	public static void testUpdateCourseByCourseID(int CourseID) {
		CourseBean course = CourseOpr.getCourseByCourseID(CourseID);
		course.setExpense(100);
		CourseOpr.updateCourse(course);
	}
	
	public static void main(String[] args) {
		//testInsert();
		//testGetByInstrument("����", 2);
		//testGetByType("���˿�", 3);
		//testGetAllInstrument();
		//testGetByTeacherID(2015001, 3);
		//testGetCourseByCourseID(20150001);
		testGetAll(3);
		//testUpdateCourseByCourseID(20150006);
	}
}
