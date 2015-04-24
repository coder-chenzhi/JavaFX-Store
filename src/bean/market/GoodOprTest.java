package bean.market;

public class GoodOprTest {
	public static void testInsert() {
		GoodBean good = new GoodBean();
		good.setGoodName("��¶�С����");
		good.setManufact("��¶�");
		good.setGoodType("С����");
		good.setDefalutPurchasePrice(300);
		good.setDefalutSellPrice(350);
		GoodOpr.insertGoods(good);
	}
	
	public static void testGetByID() {
		System.out.println(GoodOpr.getByGoodID(20150001));
	}
	
	public static void testGetAll() {
		System.out.println(GoodOpr.getAllGoods());
	}
	
	public static void testGetByName(String goodName) {
		System.out.println(GoodOpr.getByGoodName(goodName));
	}
	
	public static void testUpdate() {
		GoodBean good = GoodOpr.getByGoodID(20150001);
		good.setGoodType("����");
		GoodOpr.updateGoods(good);
	}
	
	public static void main(String[] args) {
		//testInsert();
		//testGetAll();
		//testGetByID();
		//testGetByName("�����");
		testGetAll();
		testUpdate();
		testGetAll();
	}
	
}
