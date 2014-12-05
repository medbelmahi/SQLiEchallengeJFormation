/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Mouad
 *
 */
@Component
@Scope("prototype")
public class SqliMailThread extends Thread {
	
	@Autowired
	SqliMailSender mailSender;
	
	private String email;
	private SqliEmailModel model;
	private String template;
	
	@Override
	public void run() {
		try {
			System.out.println(">> send Email to: " + email);
			mailSender.sendMail(email, template, model);
			System.out.println(">> send Email to: " + email + " OK");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//this.destroy();
		}
	}

	public SqliEmailModel getModel() {
		return model;
	}

	public void setModel(SqliEmailModel model) {
		this.model = model;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
