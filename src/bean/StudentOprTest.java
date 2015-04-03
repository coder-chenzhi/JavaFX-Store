package bean;

import java.util.ArrayList;

public class StudentOprTest {
	
	public static ArrayList<StudentBean> studentGenerator() {
		ArrayList<StudentBean> students = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		names.add("李大钊");
		return students;
		
	}
	
	public static void testInsert() {
		StudentBean student = new StudentBean();
		student.setRealName("李大钊");
		student.setMajor("吉他");
		student.setSex("F");
		student.setLevel("五级");
		student.setEnrollDay("20120305");
		student.setStatus(false);
		StudentOpr.insertStudent(student);
		student.setRealName("王思成");
		student.setMajor("大提琴");
		student.setSex("F");
		student.setLevel("四级");
		student.setEnrollDay("20140305");
		student.setStatus(true);
	}
	
	public static void main(String[] args) {
		
	}
}
