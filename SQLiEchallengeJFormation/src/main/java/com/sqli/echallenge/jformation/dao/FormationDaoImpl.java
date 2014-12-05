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

import com.sqli.echallenge.jformation.model.entity.Formation;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class FormationDaoImpl implements FormationDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Formation> getAll() throws Exception {
		Query query = entityManager.createQuery("from Formation");
		return query.getResultList();
	}
	
	public void add(Formation formation) throws Exception {
		entityManager.persist(formation);
	}
	
	public Formation get(Long idFormation) throws Exception {
		Query query = entityManager.createQuery("from Formation where idFormation=:idFormation");
		query.setParameter("idFormation", idFormation);
		return (Formation) query.getSingleResult();
	}
	
	public void delete(Long idFormation) throws Exception {
		entityManager.remove(get(idFormation));
	}
	
	public void update(Formation formation) throws Exception {
		entityManager.merge(formation);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
