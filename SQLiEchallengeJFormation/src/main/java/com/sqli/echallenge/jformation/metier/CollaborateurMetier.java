/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Collaborateur;

/**
 * @author Mouad
 *
 */
public interface CollaborateurMetier {
	public List<Collaborateur> getAll() throws Exception;
	public Collaborateur get(Long idCollaborateur) throws Exception;
	public void add(Collaborateur collaborateur) throws Exception;
	public void delete(Long idCollaborateur) throws Exception;
	public void update(Collaborateur collaborateur) throws Exception;
}
