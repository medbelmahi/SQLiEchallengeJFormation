/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionInscriptionListAction extends SqliActionSupport {
	private static final long serialVersionUID = 2047500064495757583L;

	@Autowired
	public SessionInscriptionMetier sessionInscriptionMetier;
	@Autowired
	public SessionFormationMetier sessionFormationMetier;
	@Autowired
	public FormationMetier formationMetier;
	
	private Long idFormation;
	private Long idSession;
	
	private List<SessionInscription> collaborateurInscrit;
	private List<Collaborateur> collaborateurNonInscrit;
	
	private SessionFormation sessionFormation;
	
	@Override
	public String execute() throws Exception {
		try{
			//1// get formation from db (for validation)
			@SuppressWarnings("unused")
			Formation formation = formationMetier.get(idFormation);
			
			//2// get session (for validation)
			sessionFormation = sessionFormationMetier.get(idSession);
			
			//3// get Collborateur Inscrit
			try{
				collaborateurInscrit = sessionInscriptionMetier.getAll(idSession);
			}catch(Exception x){
				//don't do anything if list empty
			}
			
			//4// get Collaborateur nonInscrit
			try{
				collaborateurNonInscrit = sessionInscriptionMetier.getUnregistredCollaborateurs(idSession);
			}catch(Exception x){
				//don't do anything if list empty
			}
			
			
			//Ok
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
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
	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public List<SessionInscription> getCollaborateurInscrit() {
		return collaborateurInscrit;
	}

	public void setCollaborateurInscrit(
			List<SessionInscription> collaborateurInscrit) {
		this.collaborateurInscrit = collaborateurInscrit;
	}

	public List<Collaborateur> getCollaborateurNonInscrit() {
		return collaborateurNonInscrit;
	}

	public void setCollaborateurNonInscrit(
			List<Collaborateur> collaborateurNonInscrit) {
		this.collaborateurNonInscrit = collaborateurNonInscrit;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}
	
}
