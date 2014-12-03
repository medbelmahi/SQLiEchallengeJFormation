package com.sqli.echallenge.jformation.metier;

import com.sqli.echallenge.jformation.model.entity.Utilisateur;

public interface UtilisateurMetier {
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception;
	public Utilisateur getUtilisateur(String email, String password) throws Exception;
}
