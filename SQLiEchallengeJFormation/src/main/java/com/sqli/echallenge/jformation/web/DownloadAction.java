package com.sqli.echallenge.jformation.web;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.util.SqliFileHelper;

/**
 * 
 */

/**
 * @author Mouad
 *
 */
@Controller
public class DownloadAction extends SqliActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = -2423053178971729870L;
	
	@Autowired
	public SqliFileHelper sqliFileHelper;
	
	private HttpServletRequest servletRequest;
	
	private InputStream fileInputStream;
	private String file;

	@Override
	public String execute() throws Exception {
		try {
			
			fileInputStream = sqliFileHelper.getDocument(file);

			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return SqliActionSupport.ERROR;
		}
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
