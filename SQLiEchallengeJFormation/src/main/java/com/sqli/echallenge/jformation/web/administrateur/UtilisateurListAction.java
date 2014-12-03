/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurListAction extends SqliActionSupport {
	private static final long serialVersionUID = -263166563493354785L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private List<Utilisateur> utilisateurs;
	
	@Override
	public String execute() throws Exception {
		try {
			//get Utilisateur (Administrateur) from Session
			Utilisateur utilisateur = getSessionUser();
			
			//get list utilisateur except admin
			utilisateurs = utilisateurMetier.getAll(utilisateur);
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
