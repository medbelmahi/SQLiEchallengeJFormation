/**
 * 
 */
package com.sqli.echallenge.jformation.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_SEANCES")
public class Seance {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SEANCE")
	private Long idSeance;
	
	@Column(name="TITRE_SEANCE")
	private String titreSeance;
	
	@Column(name="DESCRIPTION_SEANCE")
	private String descriptionSeance;
	
	@Column(name="DATE_SEANCE")
	@Temporal(TemporalType.DATE)
	private Date dateSeance;
	
	@Column(name="HEURE_DEBUT_SEANCE")
	@Temporal(TemporalType.TIME)
	private Date heureDebutSeance;
	
	@Column(name="HEURE_FIN_SEANCE")
	@Temporal(TemporalType.TIME)
	private Date heureFinSeance;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ID_SESSION_FORMATION")
	private SessionFormation sessionFormation;
	
	public Seance() {}

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getTitreSeance() {
		return titreSeance;
	}

	public void setTitreSeance(String titreSeance) {
		this.titreSeance = titreSeance;
	}

	public String getDescriptionSeance() {
		return descriptionSeance;
	}

	public void setDescriptionSeance(String descriptionSeance) {
		this.descriptionSeance = descriptionSeance;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public Date getHeureDebutSeance() {
		return heureDebutSeance;
	}

	public void setHeureDebutSeance(Date heureDebutSeance) {
		this.heureDebutSeance = heureDebutSeance;
	}

	public Date getHeureFinSeance() {
		return heureFinSeance;
	}

	public void setHeureFinSeance(Date heureFinSeance) {
		this.heureFinSeance = heureFinSeance;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}
	
}
