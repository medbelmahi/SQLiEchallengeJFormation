/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.FormationDao;
import com.sqli.echallenge.jformation.model.entity.Formation;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class FormationMetierImpl implements FormationMetier {

	@Autowired
	private FormationDao dao;

	@Autowired
	private PropretiesHelper propretiesHelper;

	public List<Formation> getAll() throws Exception {
		try{
			return dao.getAll();
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("formation.list.load.fail"));
		}
	}
	
	public void add(Formation formation) throws Exception {
		try{
			dao.add(formation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("formation.add.fail"));
		}
	}
	
	public Formation get(Long idFormation) throws Exception {
		try{
			return dao.get(idFormation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("formation.id.notfound"));
		}
	}
	
	public void update(Formation formation) throws Exception {
		try{
			dao.update(formation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("formation.update.fail"));
		}
	}
	
	public FormationDao getDao() {
		return dao;
	}

	public void setDao(FormationDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}

}
