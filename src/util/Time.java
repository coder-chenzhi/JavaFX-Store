package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {
	/**
	 * ��ȡ��ǰ����
	 * @return
	 */
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * ��ȡ��ǰ���
	 * @return
	 */
	public static String getYear() {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	
	/**
	 * Date���͵�����תΪyyyyMMdd�ַ�
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * LocalDate���͵�����תΪyyyyMMdd�ַ�
	 * @param localDate
	 * @return
	 */
	public static String localDateToString(LocalDate localDate) {
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return dateToString(date);
	}
	
	/**
	 * yyyyMMdd�ַ�תΪDate���͵�����
	 * @param strDate
	 * @return
	 */
	public static Date stringToDate(String strDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}
	
	/**
	 * yyyyMMdd�ַ�תΪLocalDate���͵�����
	 * @param strDate
	 * @return
	 */
	public static LocalDate stringToLocalDate(String strDate) {
		return stringToDate(strDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	
	
	/**
	 * �ڸ�����date������days������Ȼ�󷵻ض�Ӧdate���ַ���ʽ
	 * @param date ����
	 * @param days ���ӵ�����
	 * @return
	 */
	public static String dateAddDay(String date, int days) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date start = dateFormat.parse(date);
			calendar.setTime(start);
			calendar.add(Calendar.DAY_OF_MONTH, days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateFormat.format(calendar.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(Time.getDate());
		System.out.println(Time.getTime());
		System.out.println(Time.getYear());
		System.out.println(Time.dateToString(Time.stringToDate("20140505")));
		System.out.println(Time.dateAddDay("20150405", 30));
	}
}
