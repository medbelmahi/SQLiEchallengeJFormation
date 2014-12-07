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
import com.sqli.echallenge.jformation.model.entity.SessionInscription;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class SessionInscriptionDaoImpl implements SessionInscriptionDao {

	@PersistenceContext
	private EntityManager entityManager;

	//native query!!!
	@SuppressWarnings("unchecked")
	public List<Collaborateur> getRegistredCollaborateurs(Long idSession) throws Exception {
		String s = "SELECT SQLI_COLLABORATEURS.* FROM SQLI_COLLABORATEURS WHERE SQLI_COLLABORATEURS.ID_COLLABORATEUR IN (SELECT ID_COLLABORATEUR from SQLI_SESSIONS_INSCRIPTIONS where ID_SESSION_FORMATION=:idSession)";
		Query query = entityManager.createNativeQuery(s, Collaborateur.class);
		query.setParameter("idSession", idSession);
		
		return query.getResultList();
	}

	//native query!!
	@SuppressWarnings("unchecked")
	public List<Collaborateur> getUnregistredCollaborateurs(Long idSession) throws Exception {
		String s = "SELECT SQLI_COLLABORATEURS.* FROM SQLI_COLLABORATEURS WHERE SQLI_COLLABORATEURS.ID_COLLABORATEUR NOT IN (SELECT ID_COLLABORATEUR from SQLI_SESSIONS_INSCRIPTIONS where ID_SESSION_FORMATION=:idSession)";
		Query query = entityManager.createNativeQuery(s, Collaborateur.class);
		query.setParameter("idSession", idSession);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SessionInscription> getAll(Long idSession) throws Exception {
		Query query = entityManager.createQuery("from SessionInscription where sessionFormation.idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		
		return query.getResultList();
	}
	
	public SessionInscription get(String code) throws Exception {
		Query query = entityManager.createQuery("from SessionInscription where codeInscription=:code");
		query.setParameter("code", code);
		
		return (SessionInscription) query.getSingleResult();
	}
	
	public SessionInscription get(Long idInscription)throws Exception {
		Query query = entityManager.createQuery("from SessionInscription where idSessionInscription=:idInscription");
		query.setParameter("idInscription", idInscription);
		
		return (SessionInscription) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<SessionInscription> getConfirmedInscription(Long idSession) throws Exception {
		Query query = entityManager.createQuery("from SessionInscription where sessionFormation.idSessionFormation=:idSession and confirmedInscription=:confirme");
		query.setParameter("idSession", idSession);
		query.setParameter("confirme", true);
		
		return query.getResultList();
	}
	
	public void update(SessionInscription inscription) throws Exception {
		entityManager.merge(inscription);
	}
	
	public void add(SessionInscription inscription) throws Exception {
		entityManager.persist(inscription);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
