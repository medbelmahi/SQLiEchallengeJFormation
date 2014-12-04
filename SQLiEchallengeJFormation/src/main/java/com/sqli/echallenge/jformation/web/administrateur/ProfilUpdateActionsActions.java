/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.ProfilMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Component
public class ProfilUpdateActionsActions extends SqliActionSupport {
	private static final long serialVersionUID = 6757084943679281696L;

	@Autowired
	public ProfilMetier profilMetier;
	
	private Long idProfil;
	private String[] actions;
	
	@Override
	public String execute() throws Exception {
		try {
			//delete old actions
			profilMetier.deleteActions(idProfil);
			
			//update new actions
			profilMetier.updateActions(idProfil, actions);
			
			setSessionActionMessageText(getText("profil.actions.update.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public String[] getActions() {
		return actions;
	}

	public void setActions(String[] actions) {
		this.actions = actions;
	}
}
