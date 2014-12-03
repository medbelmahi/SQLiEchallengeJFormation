/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * @author Mouad
 *
 */
public class ActionHelper {
	
	//private static final String ACTIONS_PATH = "/src/main/java/com/sqli/echallenge/jformation/util/actions.properties";
	private static final String ACTIONS_PATH = "/util/actions.properties";
	
	public static final String ROLE_ADMINISTRATEUR = "administrateur";
	public static final String ROLE_RESPONSABLE_FORMATION = "responsableformation";
	public static final String ROLE_FORMATEUR = "formateur";
	
	private static List<String> actions_administrateur = new ArrayList<String>();
	private static List<String> actions_responsableformation = new ArrayList<String>();
	private static List<String> actions_formateur = new ArrayList<String>();
	
	
	static public List<String> getAllActionsOfRole(String role){
		//administrateur actions
		if(role.equals(ROLE_ADMINISTRATEUR)){
			//if list of actions already full return it 
			if(!actions_administrateur.isEmpty()) return actions_administrateur;
			
			//else inflate list of actions the return it
			inflateActionsListOfRole(role, actions_administrateur);
			return actions_administrateur;
		}
		
		//responsable formation actions
		if(role.equals(ROLE_RESPONSABLE_FORMATION)){
			if(!actions_responsableformation.isEmpty()) return actions_responsableformation;
			
			inflateActionsListOfRole(role, actions_responsableformation);
			return actions_responsableformation;
		}
		
		//formateur actions
		if(role.equals(ROLE_FORMATEUR)){
			if(!actions_formateur.isEmpty()) return actions_formateur;
			
			inflateActionsListOfRole(role, actions_formateur);
			return actions_formateur;
		}
		
		return null;
	}
	
	private static void inflateActionsListOfRole(String role, List<String> actions) {
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = ActionHelper.class.getResourceAsStream(ACTIONS_PATH);
	 
			// load a properties file
			prop.load(input);
	 
			//get action of role
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				
				if(key.startsWith(role)){
					String value = prop.getProperty(key);
					actions.add(value);
				}
			}
	 
		} catch (IOException ex) {
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {}
			}
		}
	}

}
