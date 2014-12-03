/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import org.springframework.stereotype.Controller;

/**
 * @author Mouad
 *
 */
@Controller
public class LogoutAction extends SqliActionSupport {
	private static final long serialVersionUID = 5914007477188550017L;
	
	@Override
	public String execute() throws Exception {
		try {
			//Destroy Session And Redirect to Login
			sessionDestroy();
		} catch (Exception e) {}
		
		return SqliActionSupport.SUCCESS;
	}

}
