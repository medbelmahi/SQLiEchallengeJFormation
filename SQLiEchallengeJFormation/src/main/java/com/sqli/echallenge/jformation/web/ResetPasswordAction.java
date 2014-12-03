/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
public class ResetPasswordAction extends SqliActionSupport {
	private static final long serialVersionUID = -6188248136122214630L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private String email;

	@Override
	public String execute() throws Exception {
		try {
			//Get Utilisateur
			Utilisateur u = utilisateurMetier.getUtilisateur(email);
			
			//Send reset password mail to User
			
			//show success message
			setSessionActionMessageText(getText("utilisateur.resetPasswordMail.sent.success"));
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show erroer message
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
}
