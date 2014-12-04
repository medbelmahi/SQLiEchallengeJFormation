/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.jformation.model.entity.Collaborateur;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class CollaborateurDaoImpl implements CollaborateurDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAll() throws Exception {
		Query query = entityManager.createQuery("from Collaborateur");
		return query.getResultList();
	}

	public Collaborateur get(Long idCollaborateur) throws Exception {
		Query query = entityManager.createQuery("from Collaborateur where idCollaborateur=:idCollaborateur");
		query.setParameter("idCollaborateur", idCollaborateur);
		return (Collaborateur) query.getSingleResult();
	}

	public void add(Collaborateur collaborateur) throws Exception {
		entityManager.persist(collaborateur);
	}

	public void delete(Long idCollaborateur) throws Exception {
		entityManager.remove(get(idCollaborateur));
	}

	public void update(Collaborateur collaborateur) throws Exception {
		entityManager.merge(collaborateur);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
