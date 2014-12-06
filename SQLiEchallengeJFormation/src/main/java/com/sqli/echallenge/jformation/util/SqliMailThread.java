/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<String> email;
	private List<SqliEmailModel> model;
	private String template;
	
	@Override
	public void run() {
		try {
			
			System.out.println(">>SENDING START");//Debug
			
			//iterate over emails
			for(int i=0; i<email.size(); i++){
				//get data
				String email = this.email.get(i);
				SqliEmailModel model = this.model.get(i);
				
				//send emails
				System.out.println(">>SENDING TO:" + email);
				mailSender.sendMail(email, template, model);
				System.out.println(">>SENT TO:" + email);
			}
			
			System.out.println(">>SENDING END");//Debug
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//this.destroy();
		}
	}

	//signal email
	public void setModel(SqliEmailModel model) {
		this.model = new ArrayList<SqliEmailModel>();
		this.model.add(model);
	}

	public void setEmail(String email) {
		this.email = new ArrayList<String>();
		this.email.add(email);
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	//several emails
	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<SqliEmailModel> getModel() {
		return model;
	}

	public void setModel(List<SqliEmailModel> model) {
		this.model = model;
	}
	
}
