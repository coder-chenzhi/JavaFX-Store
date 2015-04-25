package bean.market;

public class StocksOprTest {
	public static void testInsert() {
		StockBean stock = new StockBean();
		stock.setGoodID(20150002);
		stock.setAmount(10);
		StocksOpr.insert(stock);
	}
	
	public static void testGetAll() {
		System.out.println(StocksOpr.getAllStocks());
	}
	
	public static void testAdd() {
		StocksOpr.add(20150002, 30);
	}
	
	public static void main(String[] args) {
		//testInsert();
		testAdd();
		testGetAll();
	}
}
