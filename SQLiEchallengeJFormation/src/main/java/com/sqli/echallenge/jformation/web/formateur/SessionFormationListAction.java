/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionFormationListAction extends SqliActionSupport {
	private static final long serialVersionUID = -3140137387813029978L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private List<SessionFormation> sessions;
	
	@Override
	public String execute() throws Exception {
		try {
			//get Formateur from session
			Utilisateur formateur = getSessionUser();
			
			//get all sessions of formateur
			sessions = sessionMetier.getAllOfFormateur(formateur.getIdUtilisateur());
			System.out.println(">>[DEBUG]sessions : " + sessions);//debug
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public List<SessionFormation> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionFormation> sessions) {
		this.sessions = sessions;
	}
}
