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
@Table(name="SQLI_EVALUATIONS_REPONSES")
public class EvaluationReponse {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVALUATION_REPONSE")
	private Long idEvaluationReponse;
	
	@Column(name="SCORE")
	private Integer score;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_QUESTION")
	private EvaluationQuestion question;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COLLABORATEUR")
	private Collaborateur collaborateur;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SESSION")
	private SessionFormation session;

	public EvaluationReponse() {}

	public Long getIdEvaluationReponse() {
		return idEvaluationReponse;
	}

	public void setIdEvaluationReponse(Long idEvaluationReponse) {
		this.idEvaluationReponse = idEvaluationReponse;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public EvaluationQuestion getQuestion() {
		return question;
	}

	public void setQuestion(EvaluationQuestion question) {
		this.question = question;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public SessionFormation getSession() {
		return session;
	}

	public void setSession(SessionFormation session) {
		this.session = session;
	}
}
