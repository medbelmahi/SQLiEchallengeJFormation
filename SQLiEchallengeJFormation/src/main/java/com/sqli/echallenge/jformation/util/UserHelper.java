/**
 * 
 */
package com.sqli.echallenge.jformation.util;


/**
 * @author Mouad
 *
 */
public class UserHelper {
	//Gender (Sexe)
	public static final String SEXE_MALE = "Homme";
	public static final String SEXE_FEMALE = "Femme";

	//Format FullName
	static public String getFullname(String nom, String prenom){
		if(prenom==null || nom==null) return null;
		return prenom.substring(0, 1).toUpperCase() + prenom.substring(1) + " " + nom.toUpperCase();
	}
}
