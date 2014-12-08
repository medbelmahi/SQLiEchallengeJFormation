/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.SeanceAbsenceMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionCollaborateurListAction extends SqliActionSupport {
	private static final long serialVersionUID = 1518719205870965502L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	@Autowired
	public SeanceAbsenceMetier absenceMetier;
	
	private Long idSession;
	private SessionFormation sessionFormation;
	
	List<Seance> seances;
	List<SessionInscription> inscriptions;
	
	@Override
	public String execute() throws Exception {
		try {
			//-1// get Formateur from session
			Utilisateur formateur = getSessionUser();
			
			//0// get session from db (get seances inside sessionFormation)
			sessionFormation = sessionMetier.get(idSession);
			
			//Check:
			//1// is connected formateur the owner of this session
			if(!sessionFormation.getFormateur().getIdUtilisateur().equals(formateur.getIdUtilisateur())){
				throw new SqliException(getText("session.id.notfound"));
			}
			
			//3// get collaborateur with confirmed inscription (true)
			inscriptions = inscriptionMetier.getConfirmedInscription(idSession);
			
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

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public List<SessionInscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<SessionInscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

}
