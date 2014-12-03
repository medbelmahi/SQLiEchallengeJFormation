package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Utilisateur;

public interface UtilisateurMetier {
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception;
	public Utilisateur getUtilisateur(String email, String password) throws Exception;
	public Utilisateur getUtilisateur(String email) throws Exception;
	public List<Utilisateur> getAll(Utilisateur utilisateur) throws Exception;
	public void add(Utilisateur utilisateur) throws Exception;
}
