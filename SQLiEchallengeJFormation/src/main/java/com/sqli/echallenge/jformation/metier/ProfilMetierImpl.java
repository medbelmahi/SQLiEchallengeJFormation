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
	
	public Profil getProfil(Long idProfil) throws Exception {
		try{
			return dao.getProfil(idProfil);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("profil.id.notfound"));
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
