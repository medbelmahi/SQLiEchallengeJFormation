/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.ProfilMetier;
import com.sqli.echallenge.jformation.model.entity.Profil;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilListAction extends SqliActionSupport {
	private static final long serialVersionUID = 5016606472586047661L;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	private List<Profil> profils;
	
	@Override
	public String execute() throws Exception {
		try {
			//get profils from db
			profils = profilMetier.getAll();
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

}
