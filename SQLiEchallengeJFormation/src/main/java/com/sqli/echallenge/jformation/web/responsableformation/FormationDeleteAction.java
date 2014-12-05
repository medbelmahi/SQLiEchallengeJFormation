/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class FormationDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public FormationMetier formationMetier;

	private Long idFormation;
	
	@Override
	public String execute() throws Exception {
		try {
			//validation formation (if formations has session can't be deleted)
			Formation formation = formationMetier.get(idFormation);
			Set<SessionFormation> sessions = formation.getSessionFormations();
			if(sessions == null || sessions.size() == 0) throw new SqliException(getText("formation.delete.fail.has.sessions"));
			
			//delete formation
			formationMetier.delete(idFormation);
			
			//show success message
			setSessionActionMessageText(getText("formation.delete.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

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

}
