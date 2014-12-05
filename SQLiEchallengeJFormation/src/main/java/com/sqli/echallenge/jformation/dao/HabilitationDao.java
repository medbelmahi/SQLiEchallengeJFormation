/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Habilitation;

/**
 * @author Mouad
 *
 */
public interface HabilitationDao {
	public List<Habilitation> getAll() throws Exception;
	public void add(Habilitation habilitation) throws Exception;
	public void delete(Long idHabilitation) throws Exception;
	public Habilitation get(Long idHabilitation) throws Exception;
	public List<Object[]> getHabilitationCollaborateurs(Long idCollaborateur) throws Exception;
	public List<Object[]> getHabilitationNonCollaborateurs(Long idCollaborateur) throws Exception;
	public void addHabilitationToCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception;
	public void deleteHabilitationFromCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception;
}
