/**
 * 
 */
package com.sqli.echallenge.jformation.model.bean;

/**
 * @author Mouad
 *
 */
public class EvaluationSessionBean {
	private Long idQuestion;
	private Double avgScore;
	private String question;
	
	public EvaluationSessionBean() {
	}
	
	public Long getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
