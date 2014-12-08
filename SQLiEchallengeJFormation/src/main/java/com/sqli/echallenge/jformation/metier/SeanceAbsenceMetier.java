/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.SeanceAbsence;

/**
 * @author Mouad
 *
 */
public interface SeanceAbsenceMetier {
	public void add(SeanceAbsence absence) throws Exception;
	public List<SeanceAbsence> getOfSeance(Long idSeance) throws Exception;
	public void deleteAll(Long idSession) throws Exception;
}
