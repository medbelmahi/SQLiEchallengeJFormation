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
	public String execute() throws Exception {

		System.out.println(utilisateurMetier.getUtilisateur(2L));
		
		return SUCCESS;
	}
}
