/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = -913948165801986723L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private Long idUtilisateur;
	
	@Override
	public String execute() throws Exception {
		try {
			//delete utilisateur
			utilisateurMetier.delete(idUtilisateur);
			
			//show success message
			setSessionActionMessageText(getText("utilisateur.delete.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

}
