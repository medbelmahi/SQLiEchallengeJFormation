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
public class FormationListAction extends SqliActionSupport {
	private static final long serialVersionUID = 4290228081029920376L;

	@Autowired
	public FormationMetier formationMetier;
	
	private List<Formation> formations;
	
	@Override
	public String execute() throws Exception {
		try {
			//get All formations from db
			formations = formationMetier.getAll();
			System.out.println(">>Formations: " + formations);//Debug
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
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
