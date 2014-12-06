/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.SeanceDao;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class SeanceMetierImpl implements SeanceMetier {

	@Autowired
	private SeanceDao dao;
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public void deleteSeances(Long idSession) throws Exception {
		try {
			dao.deleteSeances(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.seances.delete.fail"));
		}
	}
	
	public SeanceDao getDao() {
		return dao;
	}

	public void setDao(SeanceDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
