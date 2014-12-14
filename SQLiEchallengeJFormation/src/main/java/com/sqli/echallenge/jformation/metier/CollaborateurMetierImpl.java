/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.CollaborateurDao;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class CollaborateurMetierImpl implements CollaborateurMetier {
	
	@Autowired
	private CollaborateurDao dao;
	@Autowired
	private HabilitationMetier habilitationMetier;
	
	@Autowired
	private PropretiesHelper propretiesHelper;

	public List<Collaborateur> getAll() throws Exception {
		try{
			return dao.getAll();
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.list.load.fail"));
		}
	}

	public Collaborateur get(Long idCollaborateur) throws Exception {
		try{
			return dao.get(idCollaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.id.notfound"));
		}
	}

	public void add(Collaborateur collaborateur) throws Exception {
		try{
			dao.add(collaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.add.fail"));
		}
	}

	public void delete(Long idCollaborateur) throws Exception {
		try{
			//delete habilitations
			habilitationMetier.deleteHabilitationsFromCollaborateur(idCollaborateur);
			
			//delete Collaborateur
			dao.delete(idCollaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.delete.fail"));
		}
	}

	public void update(Collaborateur collaborateur) throws Exception {
		try{
			dao.update(collaborateur);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.update.fail"));
		}
	}

	public CollaborateurDao getDao() {
		return dao;
	}

	public void setDao(CollaborateurDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}

	public HabilitationMetier getHabilitationMetier() {
		return habilitationMetier;
	}

	public void setHabilitationMetier(HabilitationMetier habilitationMetier) {
		this.habilitationMetier = habilitationMetier;
	}

}
