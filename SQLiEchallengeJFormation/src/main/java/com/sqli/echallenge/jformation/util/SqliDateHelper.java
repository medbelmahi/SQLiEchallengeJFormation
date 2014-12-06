package com.sqli.echallenge.jformation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SqliDateHelper {

	public static String getDateString(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	public static String getHeureString(Date date) {
		return new SimpleDateFormat("hh:mm").format(date);
	}

}
