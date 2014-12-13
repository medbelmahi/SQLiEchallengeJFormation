/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.responsableformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.bean.AbsenceSessionBean;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionAbsenceListGetAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private Long idSession;
	private String status;
	
	private List<AbsenceSessionBean> results;
	
	@Override
	public String execute() throws Exception {
		try {
			//get get evaluation result
			results = sessionMetier.getAbsenceList(idSession);
			
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

	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public List<AbsenceSessionBean> getResults() {
		return results;
	}

	public void setResults(List<AbsenceSessionBean> results) {
		this.results = results;
	}

}
