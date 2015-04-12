package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Generator {
	
	public static Object itemGenerator(ArrayList<Object> availables) {
		Random rand = new Random();
		return availables.get((int)(rand.nextDouble() *availables.size()));
	}
	
	public static String nameGenerator() {
		Random rand = new Random();
		String name = "";
		String[] firstName = { "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��" };
		String[] lastNameCharacters = { "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "Դ", "��", "��", "˼", "��", "��", "ʱ", "��", "Ϫ", "��", "��",
				"ʯ", "��", "Ӣ", "��", "��", "˶" };
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
		String[] sexs = { "��", "Ů" };
		return sexs[(int) (rand.nextDouble() * sexs.length)];
	}

	public static String dayGenerator(String startDay, String endDay) {
		Random rand = new Random();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date start = dateFormat.parse(startDay);
			calendar.setTime(start);
			Date end = dateFormat.parse(endDay);
			int range = (int) TimeUnit.MILLISECONDS.toDays(end.getTime()
					- start.getTime());
			int randnum = (int) (rand.nextDouble() * range);
			calendar.add(Calendar.DAY_OF_MONTH, randnum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateFormat.format(calendar.getTime());
	}
	
	public static boolean booleanGenerator() {
		ArrayList<Object> availables = new ArrayList<>();
		availables.add(false);
		availables.add(true);
		return (boolean)itemGenerator(availables);
	}
	
	public static String instrumentGenerator() {
		ArrayList<Object> availables = new ArrayList<>();
		availables.add("����");
		availables.add("����");
		availables.add("������");
		availables.add("С����");
		availables.add("���ӹ�");
		availables.add("������");
		return (String)itemGenerator(availables);
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
		System.out.println(booleanGenerator());
	}
}
