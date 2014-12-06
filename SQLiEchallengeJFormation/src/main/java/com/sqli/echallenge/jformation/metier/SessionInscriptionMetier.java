/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;


/**
 * @author Mouad
 *
 */
public interface SessionInscriptionMetier {
	//
	public List<Collaborateur> getRegistredCollaborateurs(Long idSession) throws Exception;
	public List<Collaborateur> getUnregistredCollaborateurs(Long idSession) throws Exception;
	//
	public List<SessionInscription> getAll(Long idSession) throws Exception;
}
