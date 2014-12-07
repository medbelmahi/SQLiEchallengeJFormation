/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.SeanceMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.util.SqliDateHelper;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionSeanceUpdateAction extends SqliActionSupport {
	private static final long serialVersionUID = 1518719205870965502L;

	@Autowired
	public SeanceMetier seanceMetier;
	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private Long idSession;//for redirect
	
	private Long[] idSeance;
	private String[] titreSeance;
	private String[] descriptionSeance;
	private Date[] dateSeance;//not updatable
	private String[] heureDebutSeance;
	private String[] heureFinSeance;
	
	private void sqlivalidate() throws Exception {
		//1// check arrays lenght
		if(idSeance.length != titreSeance.length 
				|| idSeance.length != descriptionSeance.length 
				|| idSeance.length != heureDebutSeance.length 
				|| idSeance.length != heureDebutSeance.length){
			
			throw new SqliException(getText("global.param.error"));
		}
		
		//2// check dates
	}
	
	@Override
	public String execute() throws Exception {
		try {
			//validate fields
			sqlivalidate();
			
			//iterate over data
			for(int i=0; i<idSeance.length; i++){
				//get seance from db & update
				Seance seance = seanceMetier.get(idSeance[i]);
				seance.setTitreSeance(titreSeance[i]);
				seance.setDescriptionSeance(descriptionSeance[i]);
				seance.setHeureDebutSeance(SqliDateHelper.getHeure(heureDebutSeance[i]));
				seance.setHeureFinSeance(SqliDateHelper.getHeure(heureFinSeance[i]));
				
				//update seance (merge)
				seanceMetier.update(seance);
			}
			
			//show success message
			setSessionActionMessageText(getText("session.seance.update.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long[] getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long[] idSeance) {
		this.idSeance = idSeance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String[] getTitreSeance() {
		return titreSeance;
	}

	public void setTitreSeance(String[] titreSeance) {
		this.titreSeance = titreSeance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String[] getDescriptionSeance() {
		return descriptionSeance;
	}

	public void setDescriptionSeance(String[] descriptionSeance) {
		this.descriptionSeance = descriptionSeance;
	}

	public Date[] getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date[] dateSeance) {
		this.dateSeance = dateSeance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String[] getHeureDebutSeance() {
		return heureDebutSeance;
	}

	public void setHeureDebutSeance(String[] heureDebutSeance) {
		this.heureDebutSeance = heureDebutSeance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String[] getHeureFinSeance() {
		return heureFinSeance;
	}

	public void setHeureFinSeance(String[] heureFinSeance) {
		this.heureFinSeance = heureFinSeance;
	}
	
}
