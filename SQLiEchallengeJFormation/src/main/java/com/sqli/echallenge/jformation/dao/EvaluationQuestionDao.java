/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;

/**
 * @author Mouad
 *
 */
public interface EvaluationQuestionDao {
	public List<EvaluationQuestion> getAll() throws Exception;
	public EvaluationQuestion get(Long idQuestion) throws Exception;
	public void delete(Long idQuestion) throws Exception;
	public void add(EvaluationQuestion question) throws Exception;
}
