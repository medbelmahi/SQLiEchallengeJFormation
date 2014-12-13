/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.FormationMetier;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class DashboardAction extends SqliActionSupport {
	private static final long serialVersionUID = -1809448457238575781L;
	
	@Autowired
	public FormationMetier formationMetier;

	List<Formation> formations;
	
	@Override
	public String execute() throws Exception {
		try {
			//1// get all formations form db
			formations = formationMetier.getAll();
			
			//2// 
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			return SqliActionSupport.ERROR;
		}
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
}
