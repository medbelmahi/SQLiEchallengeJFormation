/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.HabilitationMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Component
public class HabilitationDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = 6908938115674049251L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long idHabilitation;
	
	@Override
	public String execute() throws Exception {
		try {
			habilitationMetier.delete(idHabilitation);
			
			setSessionActionMessageText(getText("habilitation.delete.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdHabilitation() {
		return idHabilitation;
	}

	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}

}
