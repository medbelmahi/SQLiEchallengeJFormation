/**
 * 
 */
package com.sqli.echallenge.jformation.dao;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Document;

/**
 * @author Mouad
 *
 */
public interface DocumentDao {
	public List<Document> getAll(Long idSession) throws Exception;
	public Document get(Long idDocument) throws Exception;
	public void remove(Long idDocument) throws Exception;
	public void add(Document document) throws Exception;
	public void deleteAll(Long idSession) throws Exception;
}
