/**
 * 
 */
package com.sqli.echallenge.jformation.web.collaborateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionInscriptionConfirmAction extends SqliActionSupport {
	private static final long serialVersionUID = -867281139644932294L;

	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	
	private String code;
	private Boolean confirmation;
	private SessionInscription inscription;
	
	@Override
	public String execute() throws Exception {
		try {
			//get inscription form db
			inscription = inscriptionMetier.get(code);
			
			//Check: 
			//1//if status != null means collaborateur already choose to confirm or decline inscription
			if(inscription.getConfirmedInscription() != null) throw new SqliException(getText("collaborateur.show.inscription.traited"));
			
			//2//see if the collaborateeur already registred in other session with same date
			
			//update inscription
			inscription.setConfirmedInscription(confirmation);
			
			//merge inscription
			inscriptionMetier.update(inscription);
			
			//show success message
			if(confirmation.equals(true)) setSessionActionMessageText(getText("collaborateur.confirme.inscription.success"));
			else setSessionActionMessageText(getText("collaborateur.decline.inscription.success"));
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}

	public SessionInscription getInscription() {
		return inscription;
	}

	public void setInscription(SessionInscription inscription) {
		this.inscription = inscription;
	}
}
