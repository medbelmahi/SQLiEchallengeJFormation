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
	
	public Profil get(Long idProfil) throws Exception {
		Query query = entityManager.createQuery("from Profil where idProfil=:idProfil");
		query.setParameter("idProfil", idProfil);
		return (Profil) query.getSingleResult();
	}
	
	public Profil get(String nomProfil) throws Exception {
		Query query = entityManager.createQuery("from Profil where nomProfil=:nomProfil");
		query.setParameter("nomProfil", nomProfil);
		return (Profil) query.getSingleResult();
	}
	
	public void delete(Long idProfil) throws Exception {
		entityManager.remove(get(idProfil));
	}
	
	//Native Query!
	public void deleteActions(Long idProfil) throws Exception {
		Query query = entityManager.createNativeQuery("DELETE FROM SQLI_ACTIONS WHERE ID_PROFIL=:idProfil");
		query.setParameter("idProfil", idProfil);
		query.executeUpdate();
	}
	//Native Query!!!
	public void addAction(Long idProfil, String action) throws Exception {
		Query query = entityManager.createNativeQuery("INSERT INTO SQLI_ACTIONS(ID_PROFIL, ACTION_KEY) VALUES(:idProfil, :action)");
		query.setParameter("idProfil", idProfil);
		query.setParameter("action", action);
		query.executeUpdate();
	}
	
	public void add(Profil profil) throws Exception {
		entityManager.persist(profil);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
