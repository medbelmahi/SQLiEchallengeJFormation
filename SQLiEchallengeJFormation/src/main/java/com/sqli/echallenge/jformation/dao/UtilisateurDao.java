package com.sqli.echallenge.jformation.dao;

import com.sqli.echallenge.jformation.model.entity.Utilisateur;


public interface UtilisateurDao {
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception;
	public Utilisateur getUtilisateur(String email, String password) throws Exception;
	public Utilisateur getUtilisateur(String email) throws Exception;
}
