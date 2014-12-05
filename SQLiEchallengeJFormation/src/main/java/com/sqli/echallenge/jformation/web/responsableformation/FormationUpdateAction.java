/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

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
public class FormationUpdateAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public FormationMetier formationMetier;
	
	private Long idFormation;
	private String titreFormation;
	private String descriptionFormation;
	
	@Override
	public String execute() throws Exception {
		try {
			//get formation from db
			Formation formation = formationMetier.get(idFormation);
			formation.setTitreFormation(titreFormation);
			formation.setDescriptionFormation(descriptionFormation);
			
			//merge formation
			formationMetier.update(formation);
			
			//show success message
			setSessionActionErrorText(getText("formation.update.success"));
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

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

}
