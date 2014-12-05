/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.SeanceDao;

/**
 * @author Mouad
 *
 */
@Service
public class SeanceMetierImpl implements SeanceMetier {

	@Autowired
	private SeanceDao dao;
	
	public SeanceDao getDao() {
		return dao;
	}

	public void setDao(SeanceDao dao) {
		this.dao = dao;
	}

}
