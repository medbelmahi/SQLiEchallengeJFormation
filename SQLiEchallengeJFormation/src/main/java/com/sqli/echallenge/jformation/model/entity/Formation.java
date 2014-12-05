/**
 * 
 */
package com.sqli.echallenge.jformation.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_FORMATIONS")
public class Formation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMATION")
	private Long idFormation;
	
	@Column(name="TITRE_FORMATION")
	private String titreFormation;
	
	@Column(name="DESCRIPTION_FORMATION")
	private String descriptionFormation;
	
	@Column(name="DATE_CREATION_FORMATION")
	@Temporal(TemporalType.DATE)
	private Date dateCreationFormation;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="formation")
	private Set<SessionFormation> sessionFormations = new HashSet<SessionFormation>();
	
	public Formation() {
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getTitreFormation() {
		return titreFormation;
	}

	public void setTitreFormation(String titreFormation) {
		this.titreFormation = titreFormation;
	}

	public String getDescriptionFormation() {
		return descriptionFormation;
	}

	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}

	public Date getDateCreationFormation() {
		return dateCreationFormation;
	}

	public void setDateCreationFormation(Date dateCreationFormation) {
		if(dateCreationFormation == null)
			this.dateCreationFormation = new Date();
		else
			this.dateCreationFormation = dateCreationFormation;
	}

	public Set<SessionFormation> getSessionFormations() {
		return sessionFormations;
	}

	public void setSessionFormations(Set<SessionFormation> sessionFormations) {
		this.sessionFormations = sessionFormations;
	}
	
}
