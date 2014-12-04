/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqli.echallenge.jformation.dao.ProfilDao;
import com.sqli.echallenge.jformation.model.entity.Profil;
import com.sqli.echallenge.jformation.util.PropretiesHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Service
public class ProfilMetierImpl implements ProfilMetier {

	@Autowired
	private ProfilDao dao;
	
	@Autowired
	private PropretiesHelper propretiesHelper;
	
	public List<Profil> getAll() throws Exception {
		return dao.getAll();
	}
	
	public Profil get(Long idProfil) throws Exception {
		try{
			return dao.get(idProfil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.id.notfound"));
		}
		
	}
	
	public Profil get(String nomProfil) throws Exception {
		try{
			return dao.get(nomProfil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.nom.notfound"));
		}
		
	}
	
	public void delete(Long idProfil) throws Exception {
		try{
			//check if profil elementaire
			dao.delete(idProfil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.delete.fail"));
		}
	}
	
	public void deleteActions(Long idProfil) throws Exception {
		try{
			//check if profil elementaire
			dao.deleteActions(idProfil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.actions.delete.fail"));
		}
	}

	public void updateActions(Long idProfil, String[] actions) throws Exception {
		try{
			for(String action : actions){
				dao.addAction(idProfil, action);
			}
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.action.add.fail"));
		}
	}
	
	public void add(Profil profil) throws Exception {
		try{
			dao.add(profil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.add.deplicated.name.fail"));
		}
	}
	
	public ProfilDao getDao() {
		return dao;
	}

	public void setDao(ProfilDao dao) {
		this.dao = dao;
	}

	public PropretiesHelper getPropretiesHelper() {
		return propretiesHelper;
	}

	public void setPropretiesHelper(PropretiesHelper propretiesHelper) {
		this.propretiesHelper = propretiesHelper;
	}
}
