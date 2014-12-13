/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.responsableformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionsGetAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private String status;
	
	private Long idFormation;
	
	private Map<Long, String> sessions = new HashMap<Long, String>();
	
	@Override
	public String execute() throws Exception {
		try {
			//get sessions of formation from db
			List<SessionFormation> list = sessionMetier.getAll(idFormation);
			
			//iterate over session + inflate map
			for(SessionFormation session : list){
				sessions.put(session.getIdSessionFormation(), session.getTitreSessionFormation());
			}
			
			//set success message
			status = ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//set error message
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public Map<Long, String> getSessions() {
		return sessions;
	}

	public void setSessions(Map<Long, String> sessions) {
		this.sessions = sessions;
	}

}
