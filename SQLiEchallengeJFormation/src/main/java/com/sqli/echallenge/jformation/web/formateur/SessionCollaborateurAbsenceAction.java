/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.metier.SeanceAbsenceMetier;
import com.sqli.echallenge.jformation.metier.SeanceMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.model.entity.SeanceAbsence;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionCollaborateurAbsenceAction extends SqliActionSupport {
	private static final long serialVersionUID = 1518719205870965502L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	@Autowired
	public SeanceMetier seanceMetier;
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	@Autowired
	public SeanceAbsenceMetier absenceMetier;
	
	private Long idSession;
	private Long idSeance;
	private SessionFormation sessionFormation;
	
	private Long[] idCollaborateurs;
	
	@Override
	public String execute() throws Exception {
		try {
			//get Formateur from session
			Utilisateur formateur = getSessionUser();
			
			//get session from db (get seances inside sessionFormation)
			sessionFormation = sessionMetier.get(idSession);
			
			//Check:
			//1// is connected formateur the owner of this session
			if(!sessionFormation.getFormateur().getIdUtilisateur().equals(formateur.getIdUtilisateur())){
				throw new SqliException(getText("session.id.notfound"));
			}
			
			//2// is absence already marked for this seance
			
			//3// get seance from db
			Seance seance = seanceMetier.get(idSeance);
			
			//4// verify if this seance is for this session
			
			//5// mark absences for this seance
			for(Long id : idCollaborateurs){
				SeanceAbsence absence = new SeanceAbsence();
				absence.setCollaborateur(collaborateurMetier.get(id));
				absence.setSeance(seance);
				
				absenceMetier.add(absence);
			}
			
			//get collaborateur with confirmed inscription (true)
			
			//show success message
			setSessionActionMessageText(getText("absence.add.success"));
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

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long[] getIdCollaborateurs() {
		return idCollaborateurs;
	}

	public void setIdCollaborateurs(Long[] idCollaborateurs) {
		this.idCollaborateurs = idCollaborateurs;
	}
	
	

}
