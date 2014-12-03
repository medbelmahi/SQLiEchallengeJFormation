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
	public Profil getProfil(Long profil) throws Exception;
}
