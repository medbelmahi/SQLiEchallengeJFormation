/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.util.ActionHelper;

/**
 * @author Mouad
 *
 */
public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 7127140319576353508L;

	@Override
	public String execute() throws Exception {
		
		System.out.println(ActionHelper.getAllActionsOfRole("administrateur"));
		
		return SUCCESS;
	}
}
