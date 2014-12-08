/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.EvaluationReponseDao;
import com.sqli.echallenge.jformation.model.entity.EvaluationReponse;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class EvaluationReponseMetierImpl implements EvaluationReponseMetier {

	@Autowired
	private EvaluationReponseDao dao;

	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<EvaluationReponse> getAll(Long idCollaborateur, Long idSession) throws Exception {
		try{
			return dao.getAll(idCollaborateur, idSession);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("quetions.list.load.fail"));
		}
	}
	
	public void add(EvaluationReponse reponse) throws Exception {
		try{
			dao.add(reponse);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("question.add.fail"));
		}
	}
	
	public void deleteAll(Long idSession) throws Exception {
		try{
			dao.deleteAll(idSession);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("reponse.deletAll.fail"));
		}
	}
	
	public EvaluationReponseDao getDao() {
		return dao;
	}
	public void setDao(EvaluationReponseDao dao) {
		this.dao = dao;
	}
	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
