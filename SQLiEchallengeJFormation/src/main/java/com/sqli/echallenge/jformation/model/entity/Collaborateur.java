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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.sqli.echallenge.jformation.util.UserHelper;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_COLLABORATEURS")
public class Collaborateur {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COLLABORATEUR")
	private Long idCollaborateur;
	@Column(name="NOM_COLLABORATEUR")
	private String nomCollaborateur;
	@Column(name="PRENOM_COLLABORATEUR")
	private String prenomCollaborateur;
	@Column(name="EMAIL_COLLABORATEUR", unique=true)
	private String emailCollaborateur;
	@Column(name="TELEPHONE_COLLABORATEUR")
	private String telephoneCollaborateur;
	@Column(name="DATE_NAISSANCE_COLLABORATEUR")
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceCollaborateur;
	@Column(name="ADRESSE_COLLABORATEUR")
	private String adresseCollaborateur;
	@Column(name="SEXE_COLLABORATEUR")
	private String sexeCollaborateur;//True = Homme, false = Femme
	@Column(name="URL_PHOTO_COLLABORATEUR")
	private String urlPhotoCollaborateur;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="SQLI_COLLABORATEURS_HABILITATIONS", joinColumns = { 
			@JoinColumn(name = "ID_COLLABORATEUR", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_HABILITATION", nullable = false, updatable = false) })
	private Set<Habilitation> habilitations = new HashSet<Habilitation>();
	
	public Collaborateur() {
	}
	
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public String getNomCollaborateur() {
		return nomCollaborateur;
	}
	public void setNomCollaborateur(String nomCollaborateur) {
		this.nomCollaborateur = nomCollaborateur;
	}
	public String getPrenomCollaborateur() {
		return prenomCollaborateur;
	}
	public void setPrenomCollaborateur(String prenomCollaborateur) {
		this.prenomCollaborateur = prenomCollaborateur;
	}
	public String getEmailCollaborateur() {
		return emailCollaborateur;
	}
	public void setEmailCollaborateur(String emailCollaborateur) {
		this.emailCollaborateur = emailCollaborateur;
	}
	public String getTelephoneCollaborateur() {
		return telephoneCollaborateur;
	}
	public void setTelephoneCollaborateur(String telephoneCollaborateur) {
		this.telephoneCollaborateur = telephoneCollaborateur;
	}
	public Date getDateNaissanceCollaborateur() {
		return dateNaissanceCollaborateur;
	}
	public void setDateNaissanceCollaborateur(Date dateNaissanceCollaborateur) {
		this.dateNaissanceCollaborateur = dateNaissanceCollaborateur;
	}
	public String getAdresseCollaborateur() {
		return adresseCollaborateur;
	}
	public void setAdresseCollaborateur(String adresseCollaborateur) {
		this.adresseCollaborateur = adresseCollaborateur;
	}
	
	public String getSexeCollaborateur() {
		return sexeCollaborateur;
	}

	public void setSexeCollaborateur(String sexeCollaborateur) {
		this.sexeCollaborateur = sexeCollaborateur;
	}

	public String getUrlPhotoCollaborateur() {
		return urlPhotoCollaborateur;
	}
	public void setUrlPhotoCollaborateur(String urlPhotoCollaborateur) {
		this.urlPhotoCollaborateur = urlPhotoCollaborateur;
	}
	
	@Transient
	public String getFullname(){
		return UserHelper.getFullname(nomCollaborateur, prenomCollaborateur);
	}

	public Set<Habilitation> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(Set<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}

}
