package com.sqli.echallenge.jformation.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SQLI_PROFILS")
public class Profil {
	
	public static final String ROLE_ADMINISTRATEUR = "Administrateur";
	public static final String ROLE_RESPONSABLE_FORMATION = "Responsable de formation";
	public static final String ROLE_FORMATEUR = "Formateur";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROFIL")
	private Long idProfil;
	@Column(name="NOM_PROFIL", unique=true)
	private String nomProfil;
	@Column(name="ELEMENTAIRE")
	private boolean elementaire;
	@Column(name="ROLE_BASE")
	private String roleBase;
	@Column(name="DESCRIPTION")
	private String description;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="SQLI_ACTIONS", joinColumns=@JoinColumn(name="ID_PROFIL"))
	@Column(name="ACTION_KEY")
	private List<String> actions = new ArrayList<String>();
	
	public Profil() {
	}

	public boolean isElementaire() {
		return elementaire;
	}

	public void setElementaire(boolean elementaire) {
		this.elementaire = elementaire;
	}

	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public String getRoleBase() {
		return roleBase;
	}

	public void setRoleBase(String roleBase) {
		this.roleBase = roleBase;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
