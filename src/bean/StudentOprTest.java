package bean;

import java.util.ArrayList;

import util.Generator;

public class StudentOprTest {
	
	public static void testInsert() {
		StudentBean student = new StudentBean();
		int num = 20;
		for (int i = 0; i < num; i++) {
			student.setRealName(Generator.nameGenerator());
			student.setSex(Generator.sexGenerator());
			student.setMajor(Generator.instrumentGenerator());
			student.setBalance(0);
			student.setEnrollDay(Generator.dayGenerator("20120101", "20150404"));
			student.setStatus(Generator.booleanGenerator());
			StudentOpr.insertStudent(student);
		}
	}
	
	public static void main(String[] args) {
		testInsert();	
	}
}
