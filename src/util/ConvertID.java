package util;

public class ConvertID {
	public static String convertToString(int id, int length) {
		return new String(new char[length - Integer.toString(id).length()])
				.replace("\0", "0") + Integer.toString(id);
	}
}
