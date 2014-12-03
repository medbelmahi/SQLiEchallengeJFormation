package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.UtilisateurDao;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {

	@Autowired
	private UtilisateurDao dao;
	
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception {
		try {
			return dao.getUtilisateur(idUtilisateur);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("utilisateur.id.notfound"));
		}
		
	}	
	
	public Utilisateur getUtilisateur(String email, String password) throws Exception {
		try {
			return dao.getUtilisateur(email, password);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("utilisateur.email.password.notfound"));
		}
	}
	
	public Utilisateur getUtilisateur(String email) throws Exception {
		try {
			return dao.getUtilisateur(email);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("utilisateur.email.notfound"));
		}
	}
	
	public List<Utilisateur> getAll(Utilisateur utilisateur) throws Exception {
		try {
			return dao.getAll(utilisateur);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("utilisateur.list.empty"));
		}
	}

	public UtilisateurDao getDao() {
		return dao;
	}

	public void setDao(UtilisateurDao dao) {
		this.dao = dao;
	}
}
