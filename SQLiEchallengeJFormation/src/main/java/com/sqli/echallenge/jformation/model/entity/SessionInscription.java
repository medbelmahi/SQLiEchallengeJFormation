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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_SESSIONS_INSCRIPTIONS")
public class SessionInscription {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SESSION_INSCRIPTION")
	private Long idSessionInscription;
	
	@Column(name="CODE_INSCRIPTION")
	private String codeInscription;//generated Code 
	
	@Column(name="CONFIRMED_INSCRIPTION")
	private Boolean confirmedInscription;//null = never visited, true=confirmed , false=notConfirmed
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SESSION_FORMATION")
	private SessionFormation sessionFormation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COLLABORATEUR")
	private Collaborateur collaborateur;
	
	public SessionInscription() {}

	public Long getIdSessionInscription() {
		return idSessionInscription;
	}

	public void setIdSessionInscription(Long idSessionInscription) {
		this.idSessionInscription = idSessionInscription;
	}

	public String getCodeInscription() {
		return codeInscription;
	}

	public void setCodeInscription(String codeInscription) {
		this.codeInscription = codeInscription;
	}

	public Boolean getConfirmedInscription() {
		return confirmedInscription;
	}

	public void setConfirmedInscription(Boolean confirmedInscription) {
		this.confirmedInscription = confirmedInscription;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	/*@Transient
	public String getStatus(){
		if(confirmedInscription == true) return "true";
		if(confirmedInscription == false) return "false";
		return "null"; //confirmedInscription == null
	}*/
	
	@Transient
	public int getStatus(){
		if(confirmedInscription != null){
				if(confirmedInscription == true) return 1;
				if(confirmedInscription == false) return 0;
		}
		return -1; //confirmedInscription == null
	}
	
}
