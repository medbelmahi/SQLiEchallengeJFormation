/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.bean.AbsenceSessionBean;
import com.sqli.echallenge.jformation.dao.SessionFormationDao;
import com.sqli.echallenge.jformation.model.bean.EvaluationSessionBean;
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
	@Autowired
	private SessionInscriptionMetier inscriptionMetier;
	@Autowired
	private DocumentMetier documentMetier;
	@Autowired
	private EvaluationReponseMetier reponseMetier;
	
	public List<SessionFormation> getAll(Long idFormation) throws Exception {
		try {
			return dao.getAll(idFormation);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.list.load.fail"));
		}
	}
	
	public List<SessionFormation> getAllOfFormateur(Long idFormation) throws Exception {
		try {
			return dao.getAllOfFormateur(idFormation);
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
			
			//2// delete inscriptions
			inscriptionMetier.deleteAll(idSession);
			
			//3// delete documents
			documentMetier.deleteAll(idSession);

			//4// evaluation response
			reponseMetier.deleteAll(idSession);
			
			//5//delete session
			dao.remove(idSession);
		} catch (Exception e) {
			e.printStackTrace();
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
			//1// get All sessions
			List<SessionFormation> sessions = null;
			try{
				sessions = dao.getAllOfFormateur(idFormateur);
			}catch(Exception x){
				//cuz formateur does not have any sessions
				return false;
			}
			
			//2// iterate over sessions
			if(sessions != null){
				for(SessionFormation session : sessions){
					//2.1// datedebut (new) between datedebut (session) & datefin(session)
					if((debut.after(session.getDateDebutSessionFormation()) || debut.equals(session.getDateDebutSessionFormation())) 
						&& 
						(debut.before(session.getDateFinSessionFormation()) || debut.equals(session.getDateFinSessionFormation())))
					{
						return true;
					}
				}
			}
			
			//3// return false (can have session)
			return false;
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("session.interval.test.fail"));
		}
	}
	
	public List<EvaluationSessionBean> getEvaluationResult(Long idSession) throws Exception {
		try {
			List<Object[]> list = dao.getEvaluationResult(idSession);
			
			List<EvaluationSessionBean> evs = new ArrayList<EvaluationSessionBean>();
			
			for(Object[] o : list){
				
				EvaluationSessionBean ev = new EvaluationSessionBean();
				ev.setIdQuestion(Long.valueOf(String.valueOf(o[0])));
				ev.setAvgScore(Double.valueOf(String.valueOf(o[1])));
				ev.setQuestion((String) o[2]);
				
				evs.add(ev);
			}
			
			return evs;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SqliException(propretiesHelper.getText(""));
		}
	}
	
	public List<AbsenceSessionBean> getAbsenceList(Long idSession) throws Exception {
		try {
			List<Object[]> list = dao.getAbsenceList(idSession);
			
			List<AbsenceSessionBean> asb = new ArrayList<AbsenceSessionBean>();
			
			for(Object[] o : list){
				AbsenceSessionBean ab = new AbsenceSessionBean();
				ab.setIdSeance(Long.valueOf(String.valueOf(o[0])));
				ab.setAbsenceCount(Double.valueOf(String.valueOf(o[1])));
				
				asb.add(ab);
			}
			
			return asb;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SqliException(propretiesHelper.getText(""));
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
