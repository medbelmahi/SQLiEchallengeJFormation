/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionFormationListAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public SessionFormationMetier sessionFormationMetier;
	
	private Long idFormation;
	private List<SessionFormation> sessions;
	
	@Override
	public String execute() throws Exception {
		try {
			//get All Sessions of Formation
			sessions = sessionFormationMetier.getAll(idFormation);
			System.out.println(">>Sessions: " + sessions);//Debug
			
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

	public List<SessionFormation> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionFormation> sessions) {
		this.sessions = sessions;
	}

}
