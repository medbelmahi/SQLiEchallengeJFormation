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
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailSender;

/**
 * @author Mouad
 *
 */
@Controller
public class ResetPasswordAction extends SqliActionSupport {
	private static final long serialVersionUID = -6188248136122214630L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	@Autowired
	public SqliMailSender mailSender;
	
	private String email;

	@Override
	public String execute() throws Exception {
		try {
			//Get Utilisateur
			Utilisateur u = utilisateurMetier.getUtilisateur(email);
			
			//Send reset password mail to User
			String template = "com/sqli/echallenge/jformation/web/templatemail/utilisateur-reset-password-email-template.vm";
			SqliEmailModel model = new SqliEmailModel();
			//Inflate Model
			model.addModel(u.getNomUtilsateur());
			model.addModel(u.getPasswordUtilisateur());
			//Send Email
			mailSender.sendMail(u.getEmailUtilisateur(), template, model);
			
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
