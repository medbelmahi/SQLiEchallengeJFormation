/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.SeanceMetier;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.util.SqliDateHelper;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SeanceUpdateAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public SeanceMetier seanceMetier;
	
	private String status;
	
	private Long idSeance;
	private String titreSeance;
	private String descriptionSeance;
	private String heureDebutSeance;
	private String heureFinSeance;
	
	@Override
	public String execute() throws Exception {
		try {
			//get Seance from db
			Seance seance = seanceMetier.get(idSeance);
			
			//update Seance
			seance.setTitreSeance(titreSeance);
			seance.setDescriptionSeance(descriptionSeance);
			seance.setHeureDebutSeance(SqliDateHelper.getHeure(heureDebutSeance));
			seance.setHeureFinSeance(SqliDateHelper.getHeure(heureFinSeance));
			
			//merge seance
			seanceMetier.update(seance);
			
			status = ActionSupport.SUCCESS;
			
		} catch (Exception e) {
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

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getTitreSeance() {
		return titreSeance;
	}

	public void setTitreSeance(String titreSeance) {
		this.titreSeance = titreSeance;
	}

	public String getDescriptionSeance() {
		return descriptionSeance;
	}

	public void setDescriptionSeance(String descriptionSeance) {
		this.descriptionSeance = descriptionSeance;
	}

	public String getHeureDebutSeance() {
		return heureDebutSeance;
	}

	public void setHeureDebutSeance(String heureDebutSeance) {
		this.heureDebutSeance = heureDebutSeance;
	}

	public String getHeureFinSeance() {
		return heureFinSeance;
	}

	public void setHeureFinSeance(String heureFinSeance) {
		this.heureFinSeance = heureFinSeance;
	}

}
