package com.sqli.echallenge.jformation.dao;

import java.util.List;

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
	
	public Utilisateur getUtilisateur(String email) throws Exception {
		Query query = entityManager.createQuery("from Utilisateur where emailUtilisateur=:email");
		query.setParameter("email", email);
		
		return (Utilisateur) query.getSingleResult();
	}
	
	//get all users except Admin
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAll(Utilisateur utilisateur) throws Exception {
		Query query = entityManager.createQuery("from Utilisateur where idUtilisateur!=:idUtilisateur order by prenomUtilisateur");
		query.setParameter("idUtilisateur", utilisateur.getIdUtilisateur());
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllByRole(String role) throws Exception {
		Query query = entityManager.createQuery("from Utilisateur where profil.roleBase=:role order by prenomUtilisateur");
		query.setParameter("role", role);
		
		return query.getResultList();
	}
	
	public void delete(Long idUtilisateur) throws Exception {
		entityManager.remove(getUtilisateur(idUtilisateur));
	}
	
	public void add(Utilisateur utilisateur) throws Exception {
		entityManager.persist(utilisateur);
	}
	
	public void update(Utilisateur utilisateur) throws Exception {
		entityManager.merge(utilisateur);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
