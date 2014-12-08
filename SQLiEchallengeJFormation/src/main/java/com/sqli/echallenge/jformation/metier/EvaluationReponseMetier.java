/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.EvaluationReponse;

/**
 * @author Mouad
 *
 */
public interface EvaluationReponseMetier {
	public List<EvaluationReponse> getAll(Long idCollaborateur, Long idSession) throws Exception;
	public void add(EvaluationReponse reponse) throws Exception;
	public void deleteAll(Long idSession) throws Exception;
}
