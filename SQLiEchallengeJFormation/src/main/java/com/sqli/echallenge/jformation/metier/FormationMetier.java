/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Formation;

/**
 * @author Mouad
 *
 */
public interface FormationMetier {
	public List<Formation> getAll() throws Exception;
	public void add(Formation formation) throws Exception;
	public Formation get(Long idFormation) throws Exception;
	public void update(Formation formation) throws Exception;

}
