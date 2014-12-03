package com.sqli.echallenge.jformation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SqliDateHelper {

	public static String getDateString(Date dateNaissanceUtilisateur) {
		return new SimpleDateFormat("dd/MM/yyyy").format(dateNaissanceUtilisateur);
	}

}
