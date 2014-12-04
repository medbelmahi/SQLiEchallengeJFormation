/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Collaborateur;

/**
 * @author Mouad
 *
 */
public interface CollaborateurDao {
	public List<Collaborateur> getAll() throws Exception;
	public Collaborateur get(Long idCollaborateur) throws Exception;
	public void add(Collaborateur collaborateur) throws Exception;
	public void delete(Long idCollaborateur) throws Exception;
	public void update(Collaborateur collaborateur) throws Exception;
}
