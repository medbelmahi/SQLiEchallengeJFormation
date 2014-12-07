/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import com.sqli.echallenge.jformation.model.entity.Seance;


/**
 * @author Mouad
 *
 */
public interface SeanceDao {
	public void deleteSeances(Long idSession) throws Exception;
	public Seance get(Long idSeance) throws Exception;
	public void update(Seance seance) throws Exception;
}
