/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import com.sqli.echallenge.jformation.model.entity.Document;

/**
 * @author Mouad
 *
 */
public interface DocumentMetier {
	public List<Document> getAll(Long idSession) throws Exception;
	public Document get(Long idDocument) throws Exception;
	public void remove(Long[] idDocument) throws Exception;
	public void add(Document[] document) throws Exception;
	public void add(Document document) throws Exception;
}
