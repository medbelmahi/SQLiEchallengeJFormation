/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.EvaluationQuestionDao;
import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class EvaluationQuestionMetierImpl implements EvaluationQuestionMetier {

	@Autowired
	private EvaluationQuestionDao dao;

	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<EvaluationQuestion> getAll() throws Exception {
		try{
			return dao.getAll();
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("quetions.list.load.fail"));
		}
	}
	
	public EvaluationQuestion get(Long idQuestion) throws Exception {
		try{
			return dao.get(idQuestion);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("question.id.notfound"));
		}
	}
	
	public void delete(Long idQuestion) throws Exception {
		try{
			dao.delete(idQuestion);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("question.delete.fail"));
		}
	}

	public void add(EvaluationQuestion question) throws Exception {
		try{
			dao.add(question);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("question.add.fail"));
		}
	}
	
	public EvaluationQuestionDao getDao() {
		return dao;
	}
	public void setDao(EvaluationQuestionDao dao) {
		this.dao = dao;
	}
	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}

}
