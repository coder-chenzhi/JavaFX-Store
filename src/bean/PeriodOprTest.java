package bean;

public class PeriodOprTest {
	public static void testInsert() {
		PeriodBean p = new PeriodBean();
		p.setPeriodID("��һ�ڿ�");
		p.setStartTime("0800");
		p.setEndTime("1000");
		PeriodOpr.insert(p);
		p.setPeriodID("�ڶ��ڿ�");
		p.setStartTime("1000");
		p.setEndTime("1200");
		PeriodOpr.insert(p);
		p.setPeriodID("�����ڿ�");
		p.setStartTime("1400");
		p.setEndTime("1600");
		PeriodOpr.insert(p);
		p.setPeriodID("���Ľڿ�");
		p.setStartTime("1600");
		p.setEndTime("1800");
		PeriodOpr.insert(p);
	}
	
	public static void testGetAll() {
		System.out.println(PeriodOpr.getAllPeriods());
	}
	
	public static void testUpdate(String periodID) {
		PeriodBean p = new PeriodBean();
		p.setPeriodID("��һ�ڿ�");
		p.setStartTime("0800");
		p.setEndTime("1000");
		PeriodOpr.update(periodID, p);
	}
	
	public static void testGetByID(String periodID) {
		System.out.println(PeriodOpr.getPeriodByID(periodID));
	}
	
	public static void main(String[] args) {
		testInsert();
		//testGetAll();
		//testGetByID("��һ�ڿ�");
		testGetAll();
	}
}