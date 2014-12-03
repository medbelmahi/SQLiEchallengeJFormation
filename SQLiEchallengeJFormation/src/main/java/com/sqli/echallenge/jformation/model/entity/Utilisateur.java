package com.sqli.echallenge.jformation.model.entity;

import java.util.Date;

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

@Entity
@Table(name="SQLI_UTILISATEURS")
public class Utilisateur {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_UTILISATEUR")
	private Long idUtilisateur;
	
	@Column(name="NOM_UTILSATEUR")
	private String nomUtilsateur;
	
	@Column(name="PRENOM_UTILISATEUR")
	private String prenomUtilisateur;
	
	@Column(name="EMAIL_UTILISATEUR", unique=true)
	private String emailUtilisateur;
	
	@Column(name="PASSWORD_UTILISATEUR")
	private String passwordUtilisateur;
	
	@Column(name="DATE_NAISSANCE_UTILISATEUR")
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceUtilisateur;
	
	@Column(name="TELEPHONE_UTILISATEUR")
	private String telephoneUtilisateur;
	
	@Column(name="ADRESSE_UTILISATEUR")
	private String adresseUtilisateur;
	
	@Column(name="SEXE_UTILISATEUR")
	private String sexeUtilisateur;//Male, Female

	@Column(name="URL_PHOTO_UTILISATEUR")
	private String urlPhotoUtilisateur;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROFIL")
	private Profil profil;
	
	public Utilisateur() {}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilsateur() {
		return nomUtilsateur;
	}

	public void setNomUtilsateur(String nomUtilsateur) {
		this.nomUtilsateur = nomUtilsateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}

	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}

	public Date getDateNaissanceUtilisateur() {
		return dateNaissanceUtilisateur;
	}

	public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
	}

	public String getTelephoneUtilisateur() {
		return telephoneUtilisateur;
	}

	public void setTelephoneUtilisateur(String telephoneUtilisateur) {
		this.telephoneUtilisateur = telephoneUtilisateur;
	}

	public String getAdresseUtilisateur() {
		return adresseUtilisateur;
	}

	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public String isSexeUtilisateur() {
		return sexeUtilisateur;
	}

	public void setSexeUtilisateur(String sexeUtilisateur) {
		this.sexeUtilisateur = sexeUtilisateur;
	}

	public String getUrlPhotoUtilisateur() {
		return urlPhotoUtilisateur;
	}

	public void setUrlPhotoUtilisateur(String urlPhotoUtilisateur) {
		this.urlPhotoUtilisateur = urlPhotoUtilisateur;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}
