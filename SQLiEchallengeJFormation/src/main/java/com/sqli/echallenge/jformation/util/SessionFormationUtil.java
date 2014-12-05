/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Mouad
 *
 */
public class SessionFormationUtil {
	
	private static final int heureDebut = 8, heureFin = 11;
	private static final int minuteDebut = 30, minuteFin = 30;
	
	public static Date getHeureDebut(Date date){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.set(Calendar.HOUR, heureDebut); 
		cal.set(Calendar.MINUTE, minuteDebut); 
		
    	return cal.getTime();
	}
	
	public static Date getHeureFin(Date date){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.set(Calendar.HOUR, heureFin); 
		cal.set(Calendar.MINUTE, minuteFin); 
		
    	return cal.getTime();
	}
}
