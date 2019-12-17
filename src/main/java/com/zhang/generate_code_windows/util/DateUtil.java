package com.zhang.generate_code_windows.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 时间日期
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-10 10:16
 **/
public class DateUtil {

	private static final String DATA_PATTERN = "dd.MM.yyyy";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATA_PATTERN);


	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}

		return DATE_FORMATTER.format(date);
	}


	public static boolean validDate(String dateString) {
		// Try to parse the String.
		return DateUtil.parse(dateString) != null;
	}



	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

}
