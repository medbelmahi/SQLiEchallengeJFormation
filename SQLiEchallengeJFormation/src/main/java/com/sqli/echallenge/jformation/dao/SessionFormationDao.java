/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.SessionFormation;


/**
 * @author Mouad
 *
 */
public interface SessionFormationDao {

	public List<SessionFormation> getAll(Long idFormation) throws Exception;
	public void add(SessionFormation session) throws Exception;
	public void remove(Long idSession) throws Exception;
	public SessionFormation get(Long idSession) throws Exception;
	public void update(SessionFormation session) throws Exception;
	public List<SessionFormation> getAllOfFormateur(Long idFormateur) throws Exception;

	public List<Object[]> getEvaluationResult(Long idSession) throws Exception;
	public List<Object[]> getAbsenceList(Long idSession) throws Exception;
}
