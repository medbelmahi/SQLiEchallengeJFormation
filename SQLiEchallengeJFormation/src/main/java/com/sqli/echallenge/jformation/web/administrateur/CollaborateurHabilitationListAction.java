/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.metier.HabilitationMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.Habilitation;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurHabilitationListAction extends SqliActionSupport {
	private static final long serialVersionUID = -2820091597615546328L;
	
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long idCollaborateur;
	
	private Collaborateur collaborateur;
	
	private List<Habilitation> collaborateurHabilitations;
	private List<Habilitation> nonCollaborateurHabilitations;
	
	@Override
	public String execute() throws Exception {
		try {
			//get collaborateur for db
			collaborateur = collaborateurMetier.get(idCollaborateur);
			
			//get List collaborateurHabilitations
			collaborateurHabilitations = habilitationMetier.getHabilitationCollaborateurs(idCollaborateur);
			System.out.println("habi: "  + collaborateurHabilitations); 
			
			//get List nonCollaborateurHabilitations
			nonCollaborateurHabilitations = habilitationMetier.getHabilitationNonCollaborateurs(idCollaborateur);
			System.out.println("non habi: "  + nonCollaborateurHabilitations); 
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}

	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}

	public List<Habilitation> getCollaborateurHabilitations() {
		return collaborateurHabilitations;
	}

	public void setCollaborateurHabilitations(
			List<Habilitation> collaborateurHabilitations) {
		this.collaborateurHabilitations = collaborateurHabilitations;
	}

	public List<Habilitation> getNonCollaborateurHabilitations() {
		return nonCollaborateurHabilitations;
	}

	public void setNonCollaborateurHabilitations(
			List<Habilitation> nonCollaborateurHabilitations) {
		this.nonCollaborateurHabilitations = nonCollaborateurHabilitations;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
}
