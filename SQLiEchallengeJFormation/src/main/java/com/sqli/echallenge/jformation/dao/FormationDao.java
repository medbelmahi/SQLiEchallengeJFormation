/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Formation;

/**
 * @author Mouad
 *
 */
public interface FormationDao {
	public List<Formation> getAll() throws Exception;
	public void add(Formation formation) throws Exception;
	public Formation get(Long idFormation) throws Exception;
	public void update(Formation formation) throws Exception;
	public void delete(Long idFormation) throws Exception;

}
