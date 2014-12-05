/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.HabilitationDao;
import com.sqli.echallenge.jformation.model.entity.Habilitation;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class HablilitationMetierImpl implements HabilitationMetier {
	
	@Autowired
	private HabilitationDao dao;
	
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<Habilitation> getAll() throws Exception {
		try{
			return dao.getAll();
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.list.load.fail"));
		}
	}

	public void add(Habilitation habilitation) throws Exception {
		try{
			dao.add(habilitation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.add.fail"));
		}
	}

	public void delete(Long idHabilitation) throws Exception {
		try{
			dao.delete(idHabilitation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.delete.fail"));
		}
	}

	public Habilitation get(Long idHabilitation) throws Exception {
		try{
			return dao.get(idHabilitation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.id.notfound"));
		}
	}
	
	public List<Habilitation> getHabilitationCollaborateurs(Long idCollaborateur) throws Exception {
		try{
			return dao.getHabilitationCollaborateurs(idCollaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.list.load.fail"));
		}
	}

	public List<Habilitation> getHabilitationNonCollaborateurs(Long idCollaborateur) throws Exception {
		try{
			return dao.getHabilitationNonCollaborateurs(idCollaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.list.load.fail"));
		}
	}

	public HabilitationDao getDao() {
		return dao;
	}

	public void setDao(HabilitationDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}

}
