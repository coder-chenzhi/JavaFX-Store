package bean;

import java.util.ArrayList;

public class StudentOprTest {
	
	public static ArrayList<StudentBean> studentGenerator() {
		ArrayList<StudentBean> students = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		names.add("�����");
		return students;
		
	}
	
	public static void testInsert() {
		StudentBean student = new StudentBean();
		student.setRealName("�����");
		student.setMajor("����");
		student.setSex("F");
		student.setLevel("�弶");
		student.setEnrollDay("20120305");
		student.setStatus(false);
		StudentOpr.insertStudent(student);
		student.setRealName("��˼��");
		student.setMajor("������");
		student.setSex("F");
		student.setLevel("�ļ�");
		student.setEnrollDay("20140305");
		student.setStatus(true);
	}
	
	public static void main(String[] args) {
		
	}
}
