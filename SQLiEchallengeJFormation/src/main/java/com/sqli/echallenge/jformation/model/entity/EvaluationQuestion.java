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
@Table(name="SQLI_EVALUATIONS_QUESTIONS")
public class EvaluationQuestion {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVALUATION_QUESTION")
	private Long idEvaluationQuestion;
	
	@Column(name="QUESTION")
	private String question;

	public EvaluationQuestion() {}

	public Long getIdEvaluationQuestion() {
		return idEvaluationQuestion;
	}

	public void setIdEvaluationQuestion(Long idEvaluationQuestion) {
		this.idEvaluationQuestion = idEvaluationQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
