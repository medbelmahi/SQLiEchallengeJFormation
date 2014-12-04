/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailThread;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurSendEmailAction extends SqliActionSupport {
	private static final long serialVersionUID = -5381281436408167182L;
	private static final String TEMPLATE_MAIL = "template/collaborateur-costum-email-template.vm";

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	@Autowired
	public SqliMailThread sqliMailThread;
	
	private Long idCollaborateur;
	private String object;
	private String msg;
	
	@Override
	public String execute() throws Exception {
		try{
			//Get Collaborateur
			Collaborateur c = collaborateurMetier.get(idCollaborateur);
			
			//Prepare Model//Inflate Model
			SqliEmailModel model = new SqliEmailModel();
			model.addModel(c.getFullname());
			model.addModel(msg);
			
			//Prepare Mail Thread
			sqliMailThread.setEmail(c.getEmailCollaborateur());
			sqliMailThread.setModel(model);
			sqliMailThread.setTemplate(TEMPLATE_MAIL);
			sqliMailThread.start();
			
			setSessionActionMessageText(getText("collaborateur.email.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			e.printStackTrace();
			setSessionActionErrorText(getText("collaborateur.email.fail"));
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}

	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
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
