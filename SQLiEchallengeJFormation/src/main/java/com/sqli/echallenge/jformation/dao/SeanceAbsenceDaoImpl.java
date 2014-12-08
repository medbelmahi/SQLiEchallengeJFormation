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

import com.sqli.echallenge.jformation.model.entity.SeanceAbsence;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class SeanceAbsenceDaoImpl implements SeanceAbsenceDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void add(SeanceAbsence absence) throws Exception {
		entityManager.persist(absence);
	}

	@SuppressWarnings("unchecked")
	public List<SeanceAbsence> get(Long idSeance) throws Exception {
		Query query = entityManager.createQuery("from SeanceAbsence where seance.idSeance=:idSeance");
		query.setParameter("idSeance", idSeance);
		return query.getResultList();
	}
	
	public void delete(Long idSeance) throws Exception {
		Query query = entityManager.createQuery("from SeanceAbsence where seance.idSeance.=:idSeance");
		query.setParameter("idSeance", idSeance);
		query.executeUpdate();
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
