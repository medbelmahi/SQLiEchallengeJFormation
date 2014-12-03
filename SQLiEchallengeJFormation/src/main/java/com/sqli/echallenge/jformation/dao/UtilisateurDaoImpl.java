package com.sqli.echallenge.jformation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.jformation.model.entity.Utilisateur;

@Repository
@Transactional
public class UtilisateurDaoImpl implements UtilisateurDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception {
		//return entityManager.find(Utilisateur.class, idUtilisateur);
		Query query = entityManager.createQuery("from Utilisateur where idUtilisateur=:idUtilisateur");
		query.setParameter("idUtilisateur", idUtilisateur);
		
		return (Utilisateur) query.getSingleResult();
	}

	public Utilisateur getUtilisateur(String email, String password) throws Exception {
		Query query = entityManager.createQuery("from Utilisateur where emailUtilisateur=:email and passwordUtilisateur=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		return (Utilisateur) query.getSingleResult();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
