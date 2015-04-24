package bean.market;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Time;
import database.DataBaseIO;

public class GoodOpr {
	static DataBaseIO db = new DataBaseIO();

	public static int getNextGoodsID() {
		int id = 0;
		Object params[] = {};
		String sql = "select max(goodID) as maxID from Goods";
		ResultSet rs = db.executeSqlWithResult(sql, params);
		try {
			while (rs.next()) {
				id = rs.getInt("maxID");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}
		if (id / 10000 == Integer.parseInt(Time.getYear())) {
			id++;
		} else {
			id = Integer.parseInt(Time.getYear()) * 10000 + 1;
		}
		return id;
	}

	public static void insertGoods(GoodBean good) {
		Object params[] = { getNextGoodsID(), good.getGoodName(),
				good.getGoodType(), good.getManufact(),
				good.getDefalutPurchasePrice(), good.getDefalutSellPrice(),
				good.getOther() };
		String sql = "insert into goods values(?,?,?,?,?,?,?)";
		db.executeSqlWithoutResult(sql, params);
	}

	public static void updateGoods(GoodBean newGood) {
		Object[] params = { newGood.getGoodName(), newGood.getGoodType(),
				newGood.getManufact(), newGood.getDefalutPurchasePrice(),
				newGood.getDefalutSellPrice(), newGood.getOther(),
				newGood.getGoodID() };
		String sql = "update goods set goodName = ?, goodType = ?, manufact = ?,"
				+ "defalutPurchasePrice = ?, defalutSellPrice = ?, other = ? "
				+ "where goodID = ?";
		db.executeSqlWithoutResult(sql, params);
	}

	public static GoodBean getByGoodID(int GoodID) {
		GoodBean good = new GoodBean();
		Object params[] = { GoodID };
		String sql = "select * from goods where GoodID = ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				good.setGoodID(rs.getInt("goodID"));
				good.setGoodName(rs.getString("goodName"));
				good.setGoodType(rs.getString("goodType"));
				good.setManufact(rs.getString("manufact"));
				good.setDefalutPurchasePrice(rs.getInt("defalutPurchasePrice"));
				good.setDefalutSellPrice(rs.getInt("defalutSellPrice"));
				good.setOther(rs.getString("other"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return good;
	}

	public static ArrayList<GoodBean> getByGoodName(String GoodName) {

		ArrayList<GoodBean> goods = new ArrayList<>();
		Object params[] = { "%" + GoodName + "%" };
		String sql = "select * from goods where GoodName like ?";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				GoodBean good = new GoodBean();
				good.setGoodID(rs.getInt("goodID"));
				good.setGoodName(rs.getString("goodName"));
				good.setGoodType(rs.getString("goodType"));
				good.setManufact(rs.getString("manufact"));
				good.setDefalutPurchasePrice(rs.getInt("defalutPurchasePrice"));
				good.setDefalutSellPrice(rs.getInt("defalutSellPrice"));
				good.setOther(rs.getString("other"));
				goods.add(good);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return goods;
	}

	public static ArrayList<GoodBean> getAllGoods() {
		ArrayList<GoodBean> goods = new ArrayList<>();
		Object[] params = {};
		String sql = "select * from goods";

		ResultSet rs = db.executeSqlWithResult(sql, params);

		try {
			while (rs.next()) {
				GoodBean good = new GoodBean();
				good.setGoodID(rs.getInt("goodID"));
				good.setGoodName(rs.getString("goodName"));
				good.setGoodType(rs.getString("goodType"));
				good.setManufact(rs.getString("manufact"));
				good.setDefalutPurchasePrice(rs.getInt("defalutPurchasePrice"));
				good.setDefalutSellPrice(rs.getInt("defalutSellPrice"));
				good.setOther(rs.getString("other"));
				goods.add(good);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.close();
		}

		return goods;
	}

	public static void main(String[] args) {
		System.out.println(getNextGoodsID());
	}

}
