/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Profil;

/**
 * @author Mouad
 *
 */
public interface ProfilMetier {
	public List<Profil> getAll() throws Exception;
	public Profil get(Long idProfil) throws Exception;
	public Profil get(String nomProfil) throws Exception;
	public void delete(Long idProfil) throws Exception;
	public void deleteActions(Long idProfil) throws Exception;
	public void updateActions(Long idProfil, String[] actions) throws Exception;
	public void add(Profil profil) throws Exception;
}
