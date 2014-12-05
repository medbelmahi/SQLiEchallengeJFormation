/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionFormationDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public SessionFormationMetier sessionFormationMetier;
	@Autowired
	public FormationMetier formationMetier;
	
	private Long idFormation;//for reload (redirect)
	private Long idSession;
	
	@Override
	public String execute() throws Exception {
		try {
			//get formation from db (for validation)
			@SuppressWarnings("unused")
			Formation formation = formationMetier.get(idFormation);
			
			//get Session from db
			SessionFormation session = sessionFormationMetier.get(idSession);
						
			//Valid dates!!!
			//is session already started but not ended yet
			Calendar caldebut = Calendar.getInstance(); caldebut.setTime(session.getDateDebutSessionFormation());
	    	Calendar calfin = Calendar.getInstance(); calfin.setTime(session.getDateFinSessionFormation());
	    	Calendar caltoday = Calendar.getInstance();
	    	
	    	if(caldebut.before(caltoday) && calfin.after(caltoday)){
	    		throw new SqliException(getText("session.delete.fail.session_in_progress"));
	    	}
			
			//remove session
			sessionFormationMetier.remove(idSession);
			
			setSessionActionMessageText(getText("session.delete.success"));
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

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
}
