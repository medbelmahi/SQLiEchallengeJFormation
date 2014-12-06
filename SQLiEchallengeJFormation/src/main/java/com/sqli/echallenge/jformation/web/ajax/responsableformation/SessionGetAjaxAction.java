/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.responsableformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.util.SqliDateHelper;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionGetAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private Long idSession;
	private String status;
	
	private String titreSessionFormation;
	private String desciptionSessionFormation;
	private String dateCreateionSessionFormation;
	private String dateDebutSessionFormation;
	private String dateFinSessionFormation;
	private String lieuSessionFormation;
	
	private Long idFormation;
	private Long idFormateur;
	
	@Override
	public String execute() throws Exception {
		try {
			//get session by id from db
			SessionFormation session = sessionMetier.get(idSession);
			titreSessionFormation = session.getTitreSessionFormation();
			desciptionSessionFormation = session.getDesciptionSessionFormation();
			lieuSessionFormation = session.getLieuSessionFormation();
			
			dateCreateionSessionFormation = SqliDateHelper.getDateString(session.getDateCreateionSessionFormation());
			dateDebutSessionFormation = SqliDateHelper.getDateString(session.getDateDebutSessionFormation());
			dateFinSessionFormation = SqliDateHelper.getDateString(session.getDateFinSessionFormation());
			
			idFormation = session.getFormation().getIdFormation();
			idFormateur = session.getFormateur().getIdUtilisateur();
			
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

	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public String getTitreSessionFormation() {
		return titreSessionFormation;
	}

	public void setTitreSessionFormation(String titreSessionFormation) {
		this.titreSessionFormation = titreSessionFormation;
	}

	public String getDesciptionSessionFormation() {
		return desciptionSessionFormation;
	}

	public void setDesciptionSessionFormation(String desciptionSessionFormation) {
		this.desciptionSessionFormation = desciptionSessionFormation;
	}

	public String getDateCreateionSessionFormation() {
		return dateCreateionSessionFormation;
	}

	public void setDateCreateionSessionFormation(
			String dateCreateionSessionFormation) {
		this.dateCreateionSessionFormation = dateCreateionSessionFormation;
	}

	public String getDateDebutSessionFormation() {
		return dateDebutSessionFormation;
	}

	public void setDateDebutSessionFormation(String dateDebutSessionFormation) {
		this.dateDebutSessionFormation = dateDebutSessionFormation;
	}

	public String getDateFinSessionFormation() {
		return dateFinSessionFormation;
	}

	public void setDateFinSessionFormation(String dateFinSessionFormation) {
		this.dateFinSessionFormation = dateFinSessionFormation;
	}

	public String getLieuSessionFormation() {
		return lieuSessionFormation;
	}

	public void setLieuSessionFormation(String lieuSessionFormation) {
		this.lieuSessionFormation = lieuSessionFormation;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public Long getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(Long idFormateur) {
		this.idFormateur = idFormateur;
	}
}
