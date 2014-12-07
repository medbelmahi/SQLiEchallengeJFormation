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

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="SQLI_DOCUMENTS")
public class Document {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DOCUMENT")
	private Long idDocument;
	
	@Column(name="NOM_DOCUMENT")
	private String nomDocument;
	
	@Column(name="DESCRIPTION_DOCUMENT")
	private String descriptionDocument;
	
	@Column(name="URL_DOCUMENT")
	private String urlDocument;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SESSION")
	private SessionFormation sessionFormation;
	
	public Document() {}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getNomDocument() {
		return nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getUrlDocument() {
		return urlDocument;
	}

	public void setUrlDocument(String urlDocument) {
		this.urlDocument = urlDocument;
	}

	public String getDescriptionDocument() {
		return descriptionDocument;
	}

	public void setDescriptionDocument(String descriptionDocument) {
		this.descriptionDocument = descriptionDocument;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}
}