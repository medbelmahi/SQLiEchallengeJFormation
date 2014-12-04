/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.HabilitationMetier;
import com.sqli.echallenge.jformation.model.entity.Habilitation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Component
public class HabilitationAddAction extends SqliActionSupport {
	private static final long serialVersionUID = 6908938115674049251L;

	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private String nom;
	private String description;
	
	@Override
	public String execute() throws Exception {
		try {
			//Create and inflate new Habilitaion
			Habilitation habilitation = new Habilitation();
			habilitation.setNomHabilitation(nom);
			habilitation.setDescriptionHabilitation(description);
			
			habilitationMetier.add(habilitation);
			
			setSessionActionMessageText(getText("habilitation.add.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
