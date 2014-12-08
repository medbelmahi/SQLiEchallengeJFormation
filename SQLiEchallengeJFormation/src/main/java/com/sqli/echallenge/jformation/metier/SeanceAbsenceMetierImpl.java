/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.SeanceAbsenceDao;
import com.sqli.echallenge.jformation.model.entity.Seance;
import com.sqli.echallenge.jformation.model.entity.SeanceAbsence;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class SeanceAbsenceMetierImpl implements SeanceAbsenceMetier {
	
	@Autowired
	private SeanceAbsenceDao dao;
	@Autowired
	private PropretiesHelper propretiesHelper;
	@Autowired
	private SessionFormationMetier sessionMetier;
	
	public void add(SeanceAbsence absence) throws Exception {
		try {
			dao.add(absence);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("absence.add.fail"));
		}
	}
	
	public List<SeanceAbsence> getOfSeance(Long idSeance) throws Exception {
		try {
			return dao.get(idSeance);
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("absence.get.fail"));
		}
	}

	public void deleteAll(Long idSession) throws Exception {
		try {
			Set<Seance> seances = sessionMetier.get(idSession).getSceances();
			for(Seance seance : seances){
				dao.delete(seance.getIdSeance());
			}
		} catch (Exception e) {
			throw new SqliException(propretiesHelper.getText("absence.deleteAll.fail"));
		}
	}
	
	public SeanceAbsenceDao getDao() {
		return dao;
	}

	public void setDao(SeanceAbsenceDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
