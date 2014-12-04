/**
 * 
 */
package com.sqli.echallenge.jformation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_HABILITATIONS")
public class Habilitation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_HABILITATION")
	private Long idHabilitation;
	@Column(name="NOM_HABILITATION")
	private String nomHabilitation;
	@Column(name="DESCRIPTION_HABILITATION")
	private String descriptionHabilitation;
	
	public Habilitation() {
	}
	
	public Long getIdHabilitation() {
		return idHabilitation;
	}
	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}
	public String getNomHabilitation() {
		return nomHabilitation;
	}
	public void setNomHabilitation(String nomHabilitation) {
		this.nomHabilitation = nomHabilitation;
	}
	public String getDescriptionHabilitation() {
		return descriptionHabilitation;
	}
	public void setDescriptionHabilitation(String descriptionHabilitation) {
		this.descriptionHabilitation = descriptionHabilitation;
	}

}
