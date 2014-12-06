/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SessionFormationUtil;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionFormationAddAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public SessionFormationMetier sessionFormationMetier;
	@Autowired
	public FormationMetier formationMetier;
	@Autowired
	public UtilisateurMetier formateurMetier;
	
	private Long idFormation;//for reload (redirect)
	private Long idFormateur;
	
	private String titreSessionFormation;
	private String desciptionSessionFormation;
	private Date dateDebutSessionFormation;
	private Date dateFinSessionFormation;
	private String lieuSessionFormation;
	
	public void sqlivalidate() throws Exception {
		//validate Date?
		System.out.println(">>debut: " + dateDebutSessionFormation);
		System.out.println(">>fin: " + dateFinSessionFormation);
		
    	Calendar caldebut = Calendar.getInstance(); caldebut.setTime(dateDebutSessionFormation);
    	Calendar calfin = Calendar.getInstance(); calfin.setTime(dateFinSessionFormation);
    	Calendar calToday = Calendar.getInstance(); 
    	
		//1// dateDebut before Today
    	if(calToday.after(caldebut)){
    		//addActionError(getText("session.add.today.after.datedebut"));//invoke input
    		//setSessionActionErrorText(getText("session.add.today.after.datedebut"));
    		throw new SqliException(getText("session.add.today.after.datedebut"));
    	}
    	
		//2// dateDebut after dateFin
    	if(caldebut.after(calfin)){
    		throw new SqliException(getText("session.add.datedebut.after.datefin"));
    	}
	}
	
	@Override
	public String execute() throws Exception {
		try {
			//call validate first
			sqlivalidate();
			
			//get formation from db
			Formation formation = formationMetier.get(idFormation);
			
			//get formateur (utilisateur) from db
			Utilisateur formateur = formateurMetier.getUtilisateur(idFormateur);
			//formateur should not have a session with the same date
			//boolean cantHaveSession = sessionFormationMetier.hasSessionBetweenInterval(idFormateur, dateDebutSessionFormation, dateFinSessionFormation);
			//if(cantHaveSession) throw new SqliException(getText("session.formateur.cant.have"));
			
			//Create new Session Formation
			SessionFormation session = new SessionFormation();
			session.setTitreSessionFormation(titreSessionFormation);
			session.setDesciptionSessionFormation(desciptionSessionFormation);
			session.setDateCreateionSessionFormation(new Date());//today
			session.setDateDebutSessionFormation(dateDebutSessionFormation);
			session.setDateFinSessionFormation(dateFinSessionFormation);
			session.setLieuSessionFormation(lieuSessionFormation);
			
			session.setFormation(formation);
			session.setFormateur(formateur);
			
			//Create Seances between datedebut & datefin
			Calendar caldebut = Calendar.getInstance(); caldebut.setTime(dateDebutSessionFormation);
	    	Calendar calfin = Calendar.getInstance(); calfin.setTime(dateFinSessionFormation);
	    	
	    	int numeroSeance = 1;//to generate seance name
			while (!caldebut.after(calfin)) {
				Date date = caldebut.getTime();
				
				//creante & inflate new seance
				Seance seance = new Seance();
				seance.setDateSeance(date);
				seance.setTitreSeance("Seance numero " + numeroSeance++);//Generate Seance name "seance numero x"
				
				seance.setHeureDebutSeance(SessionFormationUtil.getHeureDebut(date));//set heureDebut 08:30
				seance.setHeureFinSeance(SessionFormationUtil.getHeureFin(date));//set heureFin 11:30
				
				//add seance to session & session to seance
				session.getSceances().add(seance);
				seance.setSessionFormation(session);
				
				//increment caldebut by 1 day
				caldebut.add(Calendar.DATE, 1);
			}
			
			//Session Persist
			sessionFormationMetier.add(session);
			
			//finalement send mail to formateur (include session informations)
			
			setSessionActionMessageText(getText("session.add.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getTitreSessionFormation() {
		return titreSessionFormation;
	}

	public void setTitreSessionFormation(String titreSessionFormation) {
		this.titreSessionFormation = titreSessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getDesciptionSessionFormation() {
		return desciptionSessionFormation;
	}

	public void setDesciptionSessionFormation(String desciptionSessionFormation) {
		this.desciptionSessionFormation = desciptionSessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateDebutSessionFormation() {
		return dateDebutSessionFormation;
	}

	public void setDateDebutSessionFormation(Date dateDebutSessionFormation) {
		this.dateDebutSessionFormation = dateDebutSessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateFinSessionFormation() {
		return dateFinSessionFormation;
	}

	public void setDateFinSessionFormation(Date dateFinSessionFormation) {
		this.dateFinSessionFormation = dateFinSessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getLieuSessionFormation() {
		return lieuSessionFormation;
	}

	public void setLieuSessionFormation(String lieuSessionFormation) {
		this.lieuSessionFormation = lieuSessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(Long idFormateur) {
		this.idFormateur = idFormateur;
	}
	
	

}
