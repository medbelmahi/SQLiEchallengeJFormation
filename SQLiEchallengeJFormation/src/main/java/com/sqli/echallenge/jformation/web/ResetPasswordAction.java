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
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailThread;
import com.sqli.echallenge.jformation.util.SqliRandomGenerator;

/**
 * @author Mouad
 *
 */
@Controller
public class ResetPasswordAction extends SqliActionSupport {
	private static final long serialVersionUID = -6188248136122214630L;
	private static final String TEMPLATE_MAIL = "template/utilisateur-reset-password-email-template.vm";
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	@Autowired
	public SqliMailThread sqliMailThread;
	@Autowired
	public SqliRandomGenerator sqliRandomGenerator;
	
	private String email;

	@Override
	public synchronized String execute() throws Exception {
		try {
			//Get Utilisateur
			Utilisateur u = utilisateurMetier.getUtilisateur(email);
			
			//update password
			String newPassword = sqliRandomGenerator.generateRandomString();
			String shaNewPassword = Hashing.sha1().hashString( newPassword, Charsets.UTF_8 ).toString();
			
			u.setPasswordUtilisateur(shaNewPassword);
			utilisateurMetier.update(u);
			
			//Prepare Mail Model
			SqliEmailModel model = new SqliEmailModel();
			model.addModel(u.getFullname());
			model.addModel(newPassword);
			//Prepare Mail Thread
			sqliMailThread.setEmail(email);
			sqliMailThread.setModel(model);
			sqliMailThread.setTemplate(TEMPLATE_MAIL);
			sqliMailThread.start();
			
			//show success message
			setSessionActionMessageText(getText("utilisateur.resetPasswordMail.sent.success"));
			return SqliActionSupport.SUCCESS;

		} catch (Exception e) {

			//show error message
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
