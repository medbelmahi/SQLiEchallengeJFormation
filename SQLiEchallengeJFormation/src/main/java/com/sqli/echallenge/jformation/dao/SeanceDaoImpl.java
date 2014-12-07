/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.jformation.model.entity.Seance;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class SeanceDaoImpl implements SeanceDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void deleteSeances(Long idSession) throws Exception {
		Query query = entityManager.createQuery("delete from Seance where sessionFormation.idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		query.executeUpdate();
	}
	
	public Seance get(Long idSeance) throws Exception {
		Query query = entityManager.createQuery("from Seance where idSeance=:idSeance");
		query.setParameter("idSeance", idSeance);
		return (Seance) query.getSingleResult();
	}
	
	public void update(Seance seance) throws Exception {
		entityManager.merge(seance);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
