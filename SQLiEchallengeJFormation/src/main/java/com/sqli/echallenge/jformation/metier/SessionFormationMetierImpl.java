/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.SessionFormationDao;

/**
 * @author Mouad
 *
 */
@Service
public class SessionFormationMetierImpl implements SessionFormationMetier {

	@Autowired
	private SessionFormationDao dao;

	public SessionFormationDao getDao() {
		return dao;
	}

	public void setDao(SessionFormationDao dao) {
		this.dao = dao;
	}
	
}
