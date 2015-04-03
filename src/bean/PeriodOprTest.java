package bean;

public class PeriodOprTest {
	public static void testInsert() {
		PeriodBean p = new PeriodBean();
		p.setPeriodID("第一节课");
		p.setStartTime("0800");
		p.setEndTime("1000");
		PeriodOpr.insert(p);
		p.setPeriodID("第二节课");
		p.setStartTime("1000");
		p.setEndTime("1200");
		PeriodOpr.insert(p);
		p.setPeriodID("第三节课");
		p.setStartTime("1400");
		p.setEndTime("1600");
		PeriodOpr.insert(p);
		p.setPeriodID("第四节课");
		p.setStartTime("1600");
		p.setEndTime("1800");
		PeriodOpr.insert(p);
	}
	
	public static void testGetAll() {
		System.out.println(PeriodOpr.getAllPeriods());
	}
	
	public static void testUpdate(String periodID) {
		PeriodBean p = new PeriodBean();
		p.setPeriodID("第一节课");
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
		//testGetByID("第一节课");
		testGetAll();
	}
}
