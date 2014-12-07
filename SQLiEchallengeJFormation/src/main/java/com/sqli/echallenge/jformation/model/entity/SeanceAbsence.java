/**
 * 
 */
package com.sqli.echallenge.jformation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Mouad
 *
 */

@Entity
@Table(name="SQLI_SEANCES_ABSENCES")
public class SeanceAbsence {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SEANCE_ABSENCE")
	private Long idSeanceAbsence;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SEANCE")
	private Seance seance;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COLLABORATEUR")
	private Collaborateur collaborateur;

	public SeanceAbsence() {}

	public Long getIdSeanceAbsence() {
		return idSeanceAbsence;
	}

	public void setIdSeanceAbsence(Long idSeanceAbsence) {
		this.idSeanceAbsence = idSeanceAbsence;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
}
