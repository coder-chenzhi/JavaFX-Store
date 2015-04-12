package bean;

public class ClassOprTest {

	public static void testInsert() {
		ClassBean newClass = new ClassBean();
		newClass.setCourseID(20150006);
		newClass.setClassID(1);
		newClass.setOnDate("20150601");
		newClass.setPeriodID("第二节课");
		newClass.setRoomID(201);
		newClass.setTeacherID(2015002);
		ClassOpr.insertClass(newClass);
		newClass.setCourseID(20150006);
		newClass.setClassID(2);
		newClass.setOnDate("20150608");
		newClass.setPeriodID("第二节课");
		newClass.setRoomID(201);
		newClass.setTeacherID(2015002);
		ClassOpr.insertClass(newClass);
		newClass.setCourseID(20150006);
		newClass.setClassID(3);
		newClass.setOnDate("20150615");
		newClass.setPeriodID("第二节课");
		newClass.setRoomID(201);
		newClass.setTeacherID(2015002);
		ClassOpr.insertClass(newClass);
	}
	
	public static void testGetAllClasses() {
		System.out.println(ClassOpr.getAllClasses());
	}
	
	public static void testGetExactClass(int CourseID, int ClassID) {
		System.out.println(ClassOpr.getClassByCourseIDAndClassID(CourseID, ClassID));
	}
	
	public static void clearClass() {
		ClassOpr.clear();
	}
	
	public static void testGetClassByID(int CourseID) {
		System.out.println(ClassOpr.getClassByCourseID(CourseID));
	}
	
	public static void testGetClassByDateAndPeriodAndRoom(String date, String period, int room) {
		System.out.println(ClassOpr.getClassByDateAndPeriodAndRoom(date, period, room));
	}
	
	public static void testUpdateClass(int CourseID, int ClassID) {
		ClassBean oldClass = ClassOpr.getClassByCourseIDAndClassID(CourseID, ClassID);
		oldClass.setRoomID(102);
		ClassOpr.updateClass(oldClass);
	}
	
	public static void main(String[] args) {
		//testInsert();
		testGetAllClasses();
		//testGetExactClass(20150002, 1);
		//ClassOpr.clear();
		//testGetAllClasses();
		//testGetClassByID(20150006);
		//testGetClassByDateAndPeriodAndRoom("20150601", "第一节课", 201);
		//testUpdateClass(20150002, 2);
	}
}
