package util;

import java.time.ZonedDateTime;

public class Time {
	public static String getDate() {
		return ZonedDateTime.now().toLocalDate().toString().replace("-", "");
	}
	
	public static String getTime() {
		String time = ZonedDateTime.now().toLocalTime().toString();
		time = time.substring(0, time.indexOf(".")).replace(":", "");
		return time;
	}
	
	public static void main(String[] args) {
		System.out.println(Time.getDate());
		System.out.println(Time.getTime());
	}
}
