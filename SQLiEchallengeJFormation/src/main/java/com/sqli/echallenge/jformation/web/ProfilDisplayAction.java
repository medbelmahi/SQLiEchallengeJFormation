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
public class ProfilDisplayAction extends SqliActionSupport  {
	private static final long serialVersionUID = -4525937072103982290L;

	@Override
	public String execute() throws Exception {
		return SqliActionSupport.SUCCESS;
	}
}
