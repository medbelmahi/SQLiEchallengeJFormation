/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;

/**
 * @author Mouad
 *
 */
@Controller
public class LoginAction extends SqliActionSupport {
	private static final long serialVersionUID = -8007302701743213546L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;

	private String email;
	private String password;//not hashed
	
	@Override
	public String execute() {
		try {
			//Get user from DB
			String sha1Password = Hashing.sha1().hashString( password, Charsets.UTF_8 ).toString();
			Utilisateur u = utilisateurMetier.getUtilisateur(email, sha1Password);
			//Set user session
			setSessionUser(u);
			//Return Success
			return SqliActionSupport.SUCCESS;
			
		} catch (Exception e) {
			
			//If user with (email, password) not exist
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	@EmailValidator(shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
