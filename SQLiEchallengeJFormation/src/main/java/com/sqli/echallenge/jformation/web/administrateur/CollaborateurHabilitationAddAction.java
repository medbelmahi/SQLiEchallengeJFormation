/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.HabilitationMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurHabilitationAddAction extends SqliActionSupport {
	private static final long serialVersionUID = -2820091597615546328L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long idCollaborateur;
	private Long idHabilitation;
	
	@Override
	public String execute() throws Exception {
		try {
			//add habilitation to collaborateur
			habilitationMetier.addHabilitationToCollaborateur(idCollaborateur, idHabilitation);
			
			setSessionActionMessageText(getText("collaborateur.habilitation.add.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
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

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdHabilitation() {
		return idHabilitation;
	}

	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}
}
