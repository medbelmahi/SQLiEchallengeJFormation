/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurListAction extends SqliActionSupport {
	private static final long serialVersionUID = -263166563493354785L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private List<Collaborateur> collaborateurs;
	
	@Override
	public String execute() throws Exception {
		try {
			//get list collaboreteurs
			collaborateurs = collaborateurMetier.getAll();
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
			
		}finally{
			
		}
	}

	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

}
