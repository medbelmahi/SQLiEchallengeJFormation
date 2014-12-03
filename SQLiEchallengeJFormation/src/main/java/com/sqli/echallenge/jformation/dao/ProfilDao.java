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
	public Profil getProfil(Long idProfil) throws Exception;
}
