package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PeopleGenerator {
	public static String nameGenerator() {
		Random rand = new Random();
		String name = "";
		String[] firstName = { "王", "李", "刘", "陈", "吴", "赵", "熊", "朱", "于",
				"邓", "马" };
		String[] lastNameCharacters = { "力", "杨", "潮", "方", "尼", "辉", "浩", "建",
				"达", "源", "琳", "成", "思", "亦", "灵", "时", "涛", "溪", "正", "中",
				"石", "东", "英", "凌", "钰", "硕" };
		int lastNameAviablelength[] = { 1, 2 };
		int lastNameLength = lastNameAviablelength[(int) (rand.nextDouble() * lastNameAviablelength.length)];
		name += firstName[(int) (rand.nextDouble() * firstName.length)];
		for (int i = 0; i < lastNameLength; i++) {
			name += lastNameCharacters[(int) (rand.nextDouble() * lastNameCharacters.length)];
		}
		return name;
	}

	public static String sexGenerator() {
		Random rand = new Random();
		String[] sexs = { "男", "女" };
		return sexs[(int) (rand.nextDouble() * sexs.length)];
	}

	public static String dayGenerator(String startDay, String endDay) {
		Random rand = new Random();
		String day = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date start = dateFormat.parse(startDay);
			calendar.setTime(start);
			Date end = dateFormat.parse(endDay);
			int range = (int)TimeUnit.MILLISECONDS.toDays(end.getTime() - start.getTime());
			int randnum = (int) (rand.nextDouble() * range);
			calendar.add(Calendar.DAY_OF_MONTH, randnum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dateFormat.format(calendar.getTime());
	}

	public static void main(String[] args) {
		int length = 20;
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			names.add(nameGenerator());
		}
		System.out.println(names);
		System.out.println(sexGenerator());
		System.out.println(dayGenerator("19910101", "19930202"));
	}
}
