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
public class SessionInscriptionDisplayAction extends SqliActionSupport {
	private static final long serialVersionUID = -867281139644932294L;

	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	
	private String code;
	private SessionInscription inscription;
	
	@Override
	public String execute() throws Exception {
		try {
			//get inscription form db
			inscription = inscriptionMetier.get(code);
			
			//Check: 
			//1//if status != null means collaborateur already choose to confirm or decline inscription
			if(inscription.getConfirmedInscription() != null) throw new SqliException(getText("collaborateur.show.inscription.traited"));
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
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

	public SessionInscription getInscription() {
		return inscription;
	}

	public void setInscription(SessionInscription inscription) {
		this.inscription = inscription;
	}
}
