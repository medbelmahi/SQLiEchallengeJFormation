/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.SessionFormationDao;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class SessionFormationMetierImpl implements SessionFormationMetier {

	@Autowired
	private SessionFormationDao dao;
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<SessionFormation> getAll(Long idFormation) throws Exception {
		try {
			return dao.getAll(idFormation);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.list.load.fail"));
		}
	}
	
	public void add(SessionFormation session) throws Exception {
		try {
			dao.add(session);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.add.fail"));
		}
	}
	
	public void remove(Long idSession) throws Exception {
		try {
			dao.remove(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.delete.fail"));
		}
	}
	
	public SessionFormation get(Long idSession) throws Exception {
		try {
			return dao.get(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.id.notfound"));
		}
	}

	public void update(SessionFormation session) throws Exception {
		try {
			dao.update(session);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.update.fail"));
		}
	}
	
	public SessionFormationDao getDao() {
		return dao;
	}

	public void setDao(SessionFormationDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
