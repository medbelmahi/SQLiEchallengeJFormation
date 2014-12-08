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
	

	public SessionInscription get(String code) throws Exception {
		try {
			return dao.get(code);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("collaborateur.show.inscription.fail"));
		}
	}
	
	public SessionInscription get(Long idInscription) throws Exception {
		try {
			return dao.get(idInscription);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("collaborateur.show.inscription.fail"));
		}
	}
	
	public void update(SessionInscription inscription) throws Exception {
		try {
			dao.update(inscription);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("collaborateur.update.inscription.fail"));
		}
	}
	
	public List<SessionInscription> getConfirmedInscription(Long idSession) throws Exception {
		try {
			return dao.getConfirmedInscription(idSession);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.inscription.confirmedList.empty"));
		}
	}
	
	public void deleteAll(Long idSession) throws Exception {
		try {
			dao.deleteAll(idSession);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SqliException(propretiesHelper.getText("session.inscription.deleteAll.fail"));
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
