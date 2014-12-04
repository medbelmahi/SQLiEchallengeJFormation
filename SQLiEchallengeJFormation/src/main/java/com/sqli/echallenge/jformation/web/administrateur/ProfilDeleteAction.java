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
public class ProfilDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = 6908938115674049251L;

	@Autowired
	public ProfilMetier profilMetier;
	
	private Long idProfil;
	
	@Override
	public String execute() throws Exception {
		try {
			profilMetier.delete(idProfil);
			
			setSessionActionMessageText(getText("profil.delete.success"));
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

}
