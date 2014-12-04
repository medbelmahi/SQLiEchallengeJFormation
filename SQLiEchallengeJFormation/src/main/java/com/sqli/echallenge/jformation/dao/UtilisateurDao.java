package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Utilisateur;


public interface UtilisateurDao {
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception;
	public Utilisateur getUtilisateur(String email, String password) throws Exception;
	public Utilisateur getUtilisateur(String email) throws Exception;
	public List<Utilisateur> getAll(Utilisateur utilisateur) throws Exception;
	public void add(Utilisateur utilisateur) throws Exception;
	public void delete(Long idUtilisateur) throws Exception;
	public void update(Utilisateur utilisateur) throws Exception;
}
