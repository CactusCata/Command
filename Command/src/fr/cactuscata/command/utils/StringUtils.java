package fr.cactuscata.command.utils;

import java.util.List;

public class StringUtils {

	public static final String join(List<String> list, String separator) {
		return join(list.toArray(new String[list.size()]), separator);
	}

	public static final String join(String[] array, String separator) {
		return join(array, 0, separator);
	}

	public static final String join(String[] array, int indexToStart, String separator) {
		final StringBuilder build = new StringBuilder();
		for (int i = indexToStart, j = array.length; i < j; i++) {
			if (i != indexToStart)
				build.append(separator);
			build.append(array[i]);
		}
		return build.toString();
	}

	public static final String[] removeIndex(final int index, final String[] oldArray) {
		final String[] newArray = new String[oldArray.length - 1];

		for (int i = 0, j = oldArray.length, k = 0; k < j; k++)
			if (k != index) {
				newArray[i] = oldArray[k];
				i++;
			}

		return newArray;
	}

	public static final String[] toStringArray(Object[] arrayObject) {
		String[] arrayString = new String[arrayObject.length];
		for (int i = 0, j = arrayObject.length; i < j; i++)
			arrayString[i] = arrayObject[i].toString();
		return arrayString;
	}

}
