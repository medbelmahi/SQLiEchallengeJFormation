/**
 * 
 */
package com.sqli.echallenge.jformation.util;


/**
 * @author Mouad
 *
 */
public class FileHelper {
	public String setRandomName(String filename){
		String extension = filename.substring(filename.lastIndexOf("."));
		
		return new SqliRandomGenerator().generateRandomNumber() + extension;
	}
}
