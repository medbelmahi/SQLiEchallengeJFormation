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

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
