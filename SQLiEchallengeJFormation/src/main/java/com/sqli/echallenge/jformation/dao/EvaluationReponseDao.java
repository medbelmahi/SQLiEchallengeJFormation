/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.EvaluationReponse;

/**
 * @author Mouad
 *
 */
public interface EvaluationReponseDao {
	public List<EvaluationReponse> getAll(Long idCollaborateur, Long idSession) throws Exception;
	public void add(EvaluationReponse reponse) throws Exception;
}
