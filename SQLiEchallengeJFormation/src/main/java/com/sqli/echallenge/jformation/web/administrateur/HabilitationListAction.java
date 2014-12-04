/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.HabilitationMetier;
import com.sqli.echallenge.jformation.model.entity.Habilitation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationListAction extends SqliActionSupport {
	private static final long serialVersionUID = 5016606472586047661L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private List<Habilitation> habilitations;
	
	@Override
	public String execute() throws Exception {
		try {
			//get profils from db
			setHabilitations(habilitationMetier.getAll());
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public List<Habilitation> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}

}
