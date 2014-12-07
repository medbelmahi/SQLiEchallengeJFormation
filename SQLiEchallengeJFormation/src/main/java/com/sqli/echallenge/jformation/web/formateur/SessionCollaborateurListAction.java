/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
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
	
	private Long idSession;
	private Long idSeance;
	private SessionFormation sessionFormation;
	
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
			
			//get collaborateur with confirmed inscription
			inscriptionMetier.getConfirmedInscription(idSession);
			
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

}
