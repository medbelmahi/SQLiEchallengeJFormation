/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Mouad
 *
 */
public class PropretiesHelper {
	private static final String URL_PATH = "/global.properties";
	
	public String getText(String key){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			//get file Steam
			input = PropretiesHelper.class.getResourceAsStream(URL_PATH);
			
			// load a properties file
			prop.load(input);
			
			//return proprety
			return prop.getProperty(key);
			
		} catch (Exception e) {	
			
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {}
			}
		}
		
		return key;
	}
}
