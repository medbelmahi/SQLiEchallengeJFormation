/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailSender;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurSendEmailAction extends SqliActionSupport {
	private static final long serialVersionUID = -5381281436408167182L;
	private static final String TEMPLATE_MAIL = "template/utilisateur-costum-email-template.vm";

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	@Autowired
	public SqliMailSender mailSender;
	
	private Long idUtilisateur;
	private String object;
	private String msg;
	
	@Override
	public String execute() throws Exception {
		try{
			//Get Utilisateur
			Utilisateur u = utilisateurMetier.getUtilisateur(idUtilisateur);
			
			//Send Email to Utilisateur
			SqliEmailModel model = new SqliEmailModel();
			
			//Inflate Model
			model.addModel(u.getFullname());
			model.addModel(msg);
			mailSender.sendMail(u.getEmailUtilisateur(), TEMPLATE_MAIL, model);//Send Email
			
			setSessionActionMessageText(getText("utilisateur.email.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			setSessionActionErrorText(getText("utilisateur.email.fail"));
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
