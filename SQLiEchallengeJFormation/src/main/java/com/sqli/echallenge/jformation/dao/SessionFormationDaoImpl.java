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

import com.sqli.echallenge.jformation.model.entity.SessionFormation;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class SessionFormationDaoImpl implements SessionFormationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<SessionFormation> getAll(Long idFormation) throws Exception {
		Query query = entityManager.createQuery("from SessionFormation where formation.idFormation=:idFormation");
		query.setParameter("idFormation", idFormation);
		return query.getResultList();
	}
	
	public void remove(Long idSession) throws Exception {
		//entityManager.remove(get(idSession));
		Query query = entityManager.createQuery("delete from SessionFormation where idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		query.executeUpdate();
	}

	public SessionFormation get(Long idSession) throws Exception {
		Query query = entityManager.createQuery("from SessionFormation where idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		return (SessionFormation) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<SessionFormation> getAllOfFormateur(Long idFormateur) throws Exception {
		Query query = entityManager.createQuery("from SessionFormation where formateur.idUtilisateur=:idFormateur");
		query.setParameter("idFormateur", idFormateur);
		return query.getResultList();
	}

	//NativeQuery
	@SuppressWarnings("unchecked")
	public List<Object[]> getEvaluationResult(Long idSession) throws Exception {
		Query query = entityManager.createNativeQuery("SELECT ID_QUESTION, AVG(SCORE) AS SCORE, QUESTION FROM SQLI_EVALUATIONS_REPONSES AS r, SQLI_EVALUATIONS_QUESTIONS AS q WHERE ID_SESSION=:idSession AND r.ID_QUESTION=q.ID_EVALUATION_QUESTION GROUP BY ID_QUESTION");
		query.setParameter("idSession", idSession);
		return query.getResultList();
	}
	
	//nativeQuery
	@SuppressWarnings("unchecked")
	public List<Object[]> getAbsenceList(Long idSession) throws Exception {
		Query query = entityManager.createNativeQuery("SELECT ID_SEANCE, COUNT(ID_SEANCE) FROM SQLI_SEANCES_ABSENCES WHERE ID_SEANCE IN (SELECT ID_SEANCE FROM SQLI_SEANCES WHERE ID_SESSION_FORMATION=:idSession) GROUP BY ID_SEANCE;");
		query.setParameter("idSession", idSession);
		return query.getResultList();
	}
	
	public void update(SessionFormation session) throws Exception {
		entityManager.merge(session);
	}

	public void add(SessionFormation session) throws Exception {
		entityManager.persist(session);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
