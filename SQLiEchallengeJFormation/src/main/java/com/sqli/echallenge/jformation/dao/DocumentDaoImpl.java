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

import com.sqli.echallenge.jformation.model.entity.Document;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class DocumentDaoImpl implements DocumentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Document> getAll(Long idSession) throws Exception {
		Query query = entityManager.createQuery("from Document where sessionFormation.idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		return query.getResultList();
	}

	public Document get(Long idDocument) throws Exception {
		Query query = entityManager.createQuery("from Document where idDocument=:idDocument");
		query.setParameter("idDocument", idDocument);
		return (Document) query.getSingleResult();
	}
	
	public void deleteAll(Long idSession) throws Exception {
		Query query = entityManager.createQuery("delete from Document where sessionFormation.idSessionFormation=:idSession");
		query.setParameter("idSession", idSession);
		query.executeUpdate();
	}

	public void remove(Long idDocument) throws Exception {
		entityManager.remove(get(idDocument));
	}

	public void add(Document document) throws Exception {
		entityManager.persist(document);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
