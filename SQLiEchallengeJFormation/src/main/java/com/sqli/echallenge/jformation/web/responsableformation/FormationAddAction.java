/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class FormationAddAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public FormationMetier formationMetier;
	
	private String titreFormation;
	private String descriptionFormation;
	
	@Override
	public String execute() throws Exception {
		try {
			//create + inflate new formation
			Formation formation = new Formation();
			formation.setTitreFormation(titreFormation);
			formation.setDescriptionFormation(descriptionFormation);
			formation.setDateCreationFormation(new Date());//today
			
			//persist formation
			formationMetier.add(formation);
			
			//show success message
			setSessionActionMessageText(getText("formation.add.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getTitreFormation() {
		return titreFormation;
	}

	public void setTitreFormation(String titreFormation) {
		this.titreFormation = titreFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}

}
