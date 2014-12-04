/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Profil;

/**
 * @author Mouad
 *
 */
public interface ProfilDao {
	public List<Profil> getAll() throws Exception;
	public Profil get(Long idProfil) throws Exception;
	public Profil get(String nomProfil) throws Exception;
	public void delete(Long idProfil) throws Exception;
	public void deleteActions(Long idProfil) throws Exception;
	public void addAction(Long idProfil, String action) throws Exception;
}
