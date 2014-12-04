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

import com.sqli.echallenge.jformation.model.entity.Profil;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class ProfilDaoImpl implements ProfilDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Profil> getAll() throws Exception {
		Query query = entityManager.createQuery("from Profil order by roleBase");
		return query.getResultList();
	}
	
	public Profil getProfil(Long idProfil) throws Exception {
		Query query = entityManager.createQuery("from Profil where idProfil=:idProfil");
		query.setParameter("idProfil", idProfil);
		return (Profil) query.getSingleResult();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
