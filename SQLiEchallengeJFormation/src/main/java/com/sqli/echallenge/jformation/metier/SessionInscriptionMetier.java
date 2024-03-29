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
	public void add(SessionInscription inscription) throws Exception;
	public SessionInscription get(String code) throws Exception;
	public SessionInscription get(Long idInscription) throws Exception;
	public void update(SessionInscription inscription) throws Exception;
	
	public  List<SessionInscription> getConfirmedInscription(Long idSession) throws Exception;
	public void deleteAll(Long idSession) throws Exception;
}
