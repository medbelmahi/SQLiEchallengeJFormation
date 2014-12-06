/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
