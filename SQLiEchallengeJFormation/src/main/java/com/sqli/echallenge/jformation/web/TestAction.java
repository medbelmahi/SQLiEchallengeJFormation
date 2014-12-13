/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;

@Controller
public class TestAction extends ActionSupport implements ServletRequestAware  {
	private static final long serialVersionUID = 7127140319576353508L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private HttpServletRequest servletRequest;
	
	
	
	@Override
	public synchronized String execute() throws Exception {
		
		//System.out.println(sessionMetier.getAbsenceList(8L));

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
}
