/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * @author Mouad
 *
 */
@Component
public class ActionHelper {
	private static final String ACTIONS_PATH = "/util/actions.properties";
	
	public String getAction(String key){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			//get file ressource
			input = ActionHelper.class.getResourceAsStream(ACTIONS_PATH);
	 
			//load a properties file
			prop.load(input);
	 
			//get action for key
			return prop.getProperty(key);
	 
		} catch (IOException ex) {
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {}
			}
		}
		return null;
	}
}
