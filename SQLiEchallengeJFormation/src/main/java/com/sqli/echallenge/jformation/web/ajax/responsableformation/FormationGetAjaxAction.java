/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.responsableformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.util.SqliDateHelper;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class FormationGetAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public FormationMetier formationMetier;
	
	private Long idFormation;
	private String status;
	
	private String titreFormation;
	private String descriptionFormation;
	private String dateCreationFormation;
	
	@Override
	public String execute() throws Exception {
		try {
			//get formation by id from db
			Formation formation = formationMetier.get(idFormation);
			titreFormation = formation.getTitreFormation();
			descriptionFormation = formation.getDescriptionFormation();
			dateCreationFormation = SqliDateHelper.getDateString(formation.getDateCreationFormation());
			
			//set success message
			status = ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//set error message
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getTitreFormation() {
		return titreFormation;
	}

	public void setTitreFormation(String titreFormation) {
		this.titreFormation = titreFormation;
	}

	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}

	public String getDateCreationFormation() {
		return dateCreationFormation;
	}

	public void setDateCreationFormation(String dateCreationFormation) {
		this.dateCreationFormation = dateCreationFormation;
	}
	
}
