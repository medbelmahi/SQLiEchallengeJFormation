/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Habilitation;

/**
 * @author Mouad
 *
 */
public interface HabilitationMetier {
	public List<Habilitation> getAll() throws Exception;
	public void add(Habilitation habilitation) throws Exception;
	public void delete(Long idHabilitation) throws Exception;
	public Habilitation get(Long idHabilitation) throws Exception;
	public List<Habilitation> getHabilitationCollaborateurs(Long idCollaborateur) throws Exception;//
	public List<Habilitation> getHabilitationNonCollaborateurs(Long idCollaborateur) throws Exception;//
	public void addHabilitationToCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception;
	public void deleteHabilitationFromCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception;
	public void addHabilitationsToCollaborateur(Long idCollaborateur, Long[] idHabilitations) throws Exception;
	public void deleteHabilitationsFromCollaborateur(Long idCollaborateur) throws Exception;
}
