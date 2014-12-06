/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.jformation.dao.SessionInscriptionDao;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
@Transactional
public class SessionInscriptionMetierImpl implements SessionInscriptionMetier {

	@Autowired
	private SessionInscriptionDao dao;
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<Collaborateur> getRegistredCollaborateurs(Long idSession) throws Exception {
		try {
			return dao.getRegistredCollaborateurs(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.inscription.registred.load.list.fail"));
		}
	}

	public List<Collaborateur> getUnregistredCollaborateurs(Long idSession) throws Exception {
		try {
			return dao.getUnregistredCollaborateurs(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.inscription.unreegistred.load.list.fail"));
		}
	}

	public List<SessionInscription> getAll(Long idSession) throws Exception {
		try {
			return dao.getAll(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.inscription.load.list.fail"));
		}
	}
	
	public void add(SessionInscription inscription) throws Exception {
		try {
			dao.add(inscription);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.inscription.add.new.fail"));
		}
	}
	
	public SessionInscriptionDao getDao() {
		return dao;
	}

	public void setDao(SessionInscriptionDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}

}
