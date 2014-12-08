/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;

/**
 * @author Mouad
 *
 */
public interface EvaluationQuestionMetier {
	public List<EvaluationQuestion> getAll() throws Exception;
	public EvaluationQuestion get(Long idQuestion) throws Exception;
}
