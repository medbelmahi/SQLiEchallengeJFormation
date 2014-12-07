/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.DocumentDao;
import com.sqli.echallenge.jformation.model.entity.Document;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class DocumentMetierImpl implements DocumentMetier {

	@Autowired
	private DocumentDao dao;

	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<Document> getAll(Long idSession) throws Exception {
		try{
			return dao.getAll(idSession);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.list.load.fail"));
		}
	}

	public Document get(Long idDocument) throws Exception {
		try{
			return dao.get(idDocument);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.id.notfound"));
		}
	}

	public void remove(Long[] idDocuments) throws Exception {
		try{
			for(Long id : idDocuments){
				dao.remove(id);
			}
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.remove.fail"));
		}
	}
	
	public void remove(Long idDocument) throws Exception {
		try{
			dao.remove(idDocument);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.remove.fail"));
		}
	}

	public void add(Document[] document) throws Exception {
		try{
			for(Document d : document){
				dao.add(d);
			}
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.add.fail"));
		}
	}
	
	public void add(Document document) throws Exception {
		try{
			dao.add(document);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("document.add.fail"));
		}
	}

	public DocumentDao getDao() {
		return dao;
	}

	public void setDao(DocumentDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
