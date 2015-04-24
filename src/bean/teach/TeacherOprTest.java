package bean.teach;

import util.Generator;

public class TeacherOprTest {
	
	public static void insert() {
		TeacherBean teacher = new TeacherBean();
		int num = 5;
		for(int i = 0; i < num; i++) {
			teacher.setRealName(Generator.nameGenerator());
			teacher.setMajor(Generator.instrumentGenerator());
			teacher.setSex(Generator.sexGenerator());
			teacher.setEnrollDay(Generator.dayGenerator("19900101", "19950101"));
			teacher.setStatus(Generator.booleanGenerator());
			TeacherOpr.insertTeacher(teacher);
		}
	}
	
	public static void getAllTeacher(int status) {
		System.out.println(TeacherOpr.getAllTeachers(status));
	}
}
