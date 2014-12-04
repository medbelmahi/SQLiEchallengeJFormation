/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = -913948165801986723L;
	
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private Long idCollaborateur;
	
	@Override
	public String execute() throws Exception {
		try {
			//delete utilisateur
			collaborateurMetier.delete(idCollaborateur);
			
			//show success message
			setSessionActionMessageText(getText("collaborateur.delete.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
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

}
