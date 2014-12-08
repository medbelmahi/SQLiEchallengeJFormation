/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.SeanceAbsence;

/**
 * @author Mouad
 *
 */
public interface SeanceAbsenceDao {
	public void add(SeanceAbsence absence) throws Exception;
	public List<SeanceAbsence> get(Long idSeance) throws Exception;
	public void delete(Long idSeance) throws Exception;
}
