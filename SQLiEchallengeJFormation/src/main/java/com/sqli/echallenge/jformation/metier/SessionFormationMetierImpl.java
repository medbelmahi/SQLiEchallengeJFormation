/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.Date;
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
	@Autowired
	private SeanceMetier seanceMetier;
	
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
			//1//delete all seances
			seanceMetier.deleteSeances(idSession);
			
			//2//delete session
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
	
	public boolean hasSessionBetweenInterval(Long idFormateur, Date debut, Date fin) throws Exception {
		try {
			//get All sessions
			List<SessionFormation> sessions = null;
			try{
				sessions = dao.getAllOfFormateur(idFormateur);
			}catch(Exception ee){}
			
			//iterate over sessions
			if(sessions != null){
				for(SessionFormation session : sessions){
					//cond1
					if(session.getDateDebutSessionFormation().after(debut) && session.getDateDebutSessionFormation().before(debut)) return true;
					
					//cond2
					if(session.getDateFinSessionFormation().after(debut) && session.getDateFinSessionFormation().before(fin)) return true;
				}
			}
			
			return false;
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.interval.test.fail"));
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

	public SeanceMetier getSeanceMetier() {
		return seanceMetier;
	}

	public void setSeanceMetier(SeanceMetier seanceMetier) {
		this.seanceMetier = seanceMetier;
	}
}
