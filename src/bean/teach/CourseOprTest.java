package bean.teach;

public class CourseOprTest {
	public static void testInsert() {
		CourseBean course = new CourseBean();
		//已经结束
		course.setTeacherID(2015001);
		course.setRoomID(102);
		course.setPeriodID("第二节课");
		course.setStartDate("20140504");
		course.setWeeks(10);
		course.setType("全课");
		course.setInstrument("吉他");
		course.setExpense(1000);
		course.setVolume(20);
		CourseOpr.insertCourse(course);
		//正在上课
		course.setTeacherID(2015002);
		course.setRoomID(201);
		course.setPeriodID("第一节课");
		course.setStartDate("20150604");
		course.setWeeks(4);
		course.setType("四人课");
		course.setInstrument("架子鼓");
		course.setExpense(1000);
		course.setVolume(4);
		CourseOpr.insertCourse(course);
		//还没开始
		course.setTeacherID(2015002);
		course.setRoomID(201);
		course.setPeriodID("第二节课");
		course.setStartDate("20150501");
		course.setWeeks(8);
		course.setType("两人课");
		course.setInstrument("大提琴");
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
	
	public static void testSelectCourse(int courseID, int studentID) {
		CourseOpr.selectCourse(courseID, studentID);
	}
	
	public static void main(String[] args) {
		//testInsert();
		//testGetByInstrument("钢琴", 2);
		//testGetByType("四人课", 3);
		//testGetAllInstrument();
		//testGetByTeacherID(2015001, 3);
		//testGetCourseByCourseID(20150001);
		//testGetAll(3);
		//testUpdateCourseByCourseID(20150006);
		testInsert();
		//testSelectCourse(20150001, 20150001);
	}
}
