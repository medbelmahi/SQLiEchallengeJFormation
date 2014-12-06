/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.Date;
import java.util.List;

import com.sqli.echallenge.jformation.model.entity.SessionFormation;


/**
 * @author Mouad
 *
 */
public interface SessionFormationMetier {

	public List<SessionFormation> getAll(Long idFormation) throws Exception;
	public void add(SessionFormation session) throws Exception;
	public void remove(Long idSession) throws Exception;
	public SessionFormation get(Long idSession) throws Exception;
	public void update(SessionFormation session) throws Exception;
	public boolean hasSessionBetweenInterval(Long idFormateur, Date debut, Date fin) throws Exception;
}
