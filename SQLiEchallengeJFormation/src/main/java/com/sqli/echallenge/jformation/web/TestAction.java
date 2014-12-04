/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;


@Controller
public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 7127140319576353508L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	@Override
	public synchronized String execute() throws Exception {

		//myThread.setName("thread1");
		//myThread.start();
		
		return SUCCESS;
	}
}
