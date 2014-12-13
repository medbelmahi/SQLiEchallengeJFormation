/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;


/**
 * @author Mouad
 *
 */
@Component
public class SqliFileHelper {
	
	private String OPENSHIFT_DATA_DIR;
	
	public String setRandomName(String filename){
		String extension = filename.substring(filename.lastIndexOf("."));
		
		return new SqliRandomGenerator().generateRandomNumber() + extension;
	}
	
	public String saveDocument(File document, String documentFileName) throws IOException {
		//create Files
		File saveDirReal = new File(OPENSHIFT_DATA_DIR);
		
		//generate names and prepare URI
		String generatedName = setRandomName(documentFileName);
		File fileToSaveReal = new File(saveDirReal, generatedName);
		
		//save file
		FileUtils.copyFile(document, fileToSaveReal);
		
		return generatedName;
	}
	
	public InputStream getDocument(String file) throws Exception {
		File f = new File(OPENSHIFT_DATA_DIR + "/" + file);
		System.out.println(f);
		
		if(f.exists()){
			FileInputStream fileInputStream = new FileInputStream(f);
			return fileInputStream;
		}else{
			throw new Exception();
		}
	}

	public String getOPENSHIFT_DATA_DIR() {
		return OPENSHIFT_DATA_DIR;
	}

	public void setOPENSHIFT_DATA_DIR(String oPENSHIFT_DATA_DIR) {
		OPENSHIFT_DATA_DIR = oPENSHIFT_DATA_DIR;
	}
}
