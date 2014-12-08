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

import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class EvaluationQuestionDaoImpl implements EvaluationQuestionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<EvaluationQuestion> getAll() throws Exception {
		Query query = entityManager.createQuery("from EvaluationQuestion");
		return query.getResultList();
	}

	public EvaluationQuestion get(Long idQuestion) throws Exception {
		Query query = entityManager.createQuery("from EvaluationQuestion where idEvaluationQuestion=:idQuestion");
		query.setParameter("idQuestion", idQuestion);
		return (EvaluationQuestion) query.getSingleResult();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
