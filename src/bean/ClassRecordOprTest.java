package bean;

public class ClassRecordOprTest {
	
	public static void testInsert() {
		ClassRecordBean record = new ClassRecordBean();
		record.setCourseID(20150001);
		record.setClassID(1);
		record.setStudentID(20150001);
		record.setStatus("��ʱδ��ʼ");
		ClassRecordOpr.insertRecord(record);
		record.setCourseID(20150001);
		record.setClassID(1);
		record.setStudentID(20150002);
		record.setStatus("��ʱδ��ʼ");
		ClassRecordOpr.insertRecord(record);
		record.setCourseID(20150001);
		record.setClassID(1);
		record.setStudentID(20150003);
		record.setStatus("��ʱδ��ʼ");
		ClassRecordOpr.insertRecord(record);
	}
	
	public static void testGetAllRecords() {
		System.out.println(ClassRecordOpr.getAllRecords());
	}
	
	public static void main(String[] args) {
		//testInsert();
		testGetAllRecords();
	}

}
