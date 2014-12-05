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

import com.sqli.echallenge.jformation.model.entity.Habilitation;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class HabilitationDaoImpl implements HabilitationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Habilitation> getAll() throws Exception {
		Query query = entityManager.createQuery("from Habilitation");
		return query.getResultList();
	}

	public void add(Habilitation habilitation) throws Exception {
		entityManager.persist(habilitation);
	}

	public void delete(Long idHabilitation) throws Exception {
		entityManager.remove(get(idHabilitation));
	}

	public Habilitation get(Long idHabilitation) throws Exception {
		Query query = entityManager.createQuery("from Habilitation where idHabilitation=:idHabilitation");
		query.setParameter("idHabilitation", idHabilitation);
		return (Habilitation) query.getSingleResult();
	}
	
	//native query!!!!
	@SuppressWarnings("unchecked")
	public List<Object[]> getHabilitationCollaborateurs(Long idCollaborateur)throws Exception {
		Query query = entityManager.createNativeQuery("SELECT * FROM SQLI_HABILITATIONS WHERE ID_HABILITATION IN (SELECT ID_HABILITATION FROM SQLI_COLLABORATEURS_HABILITATIONS WHERE ID_COLLABORATEUR=:idCollaborateur)");
		query.setParameter("idCollaborateur", idCollaborateur);
		
		return query.getResultList();
	}

	//native Queryy!!!
	@SuppressWarnings("unchecked")
	public List<Object[]> getHabilitationNonCollaborateurs(Long idCollaborateur) throws Exception {
		Query query = entityManager.createNativeQuery("SELECT * FROM SQLI_HABILITATIONS WHERE ID_HABILITATION NOT IN (SELECT ID_HABILITATION FROM SQLI_COLLABORATEURS_HABILITATIONS WHERE ID_COLLABORATEUR=:idCollaborateur)");
		query.setParameter("idCollaborateur", idCollaborateur);
		
		return query.getResultList();
	}
	//native Query!!!!
	public void addHabilitationToCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception {
		Query query = entityManager.createNativeQuery("INSERT INTO SQLI_COLLABORATEURS_HABILITATIONS (ID_HABILITATION, ID_COLLABORATEUR) VALUES(:idHabilitation, :idCollaborateur)");
		query.setParameter("idHabilitation", idHabilitation);
		query.setParameter("idCollaborateur", idCollaborateur);
		
		query.executeUpdate();
	}
	//native query:!!!
	public void deleteHabilitationFromCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception {
		Query query = entityManager.createNativeQuery("DELETE FROM SQLI_COLLABORATEURS_HABILITATIONS WHERE ID_HABILITATION=:idHabilitation AND ID_COLLABORATEUR=:idCollaborateur");
		query.setParameter("idHabilitation", idHabilitation);
		query.setParameter("idCollaborateur", idCollaborateur);
		
		query.executeUpdate();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
