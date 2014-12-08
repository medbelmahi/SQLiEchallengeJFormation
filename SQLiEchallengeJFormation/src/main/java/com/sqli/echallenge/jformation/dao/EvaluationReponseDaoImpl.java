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

import com.sqli.echallenge.jformation.model.entity.EvaluationReponse;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class EvaluationReponseDaoImpl implements EvaluationReponseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<EvaluationReponse> getAll(Long idCollaborateur, Long idSession) throws Exception {
		Query query = entityManager.createQuery("from EvaluationReponse where session.idSessionFormation=:idSession and collaborateur.idCollaborateur=:idCollaborateur");
		query.setParameter("idSession", idSession);
		query.setParameter("idCollaborateur", idCollaborateur);
		return query.getResultList();
	}
	
	public void add(EvaluationReponse reponse) throws Exception {
		entityManager.persist(reponse);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
