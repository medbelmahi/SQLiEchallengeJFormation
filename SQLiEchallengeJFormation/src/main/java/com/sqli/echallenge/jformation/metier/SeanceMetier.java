/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import com.sqli.echallenge.jformation.model.entity.Seance;


/**
 * @author Mouad
 *
 */
public interface SeanceMetier {
	public void deleteSeances(Long idSession) throws Exception;
	public Seance get(Long idSeance) throws Exception;
	public void update(Seance seance) throws Exception;
}
