/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.administrateur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.ProfilMetier;
import com.sqli.echallenge.jformation.model.entity.Profil;
import com.sqli.echallenge.jformation.util.ActionHelper;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Component
public class ProfilGetActionsAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 3033367694911935579L;
	
	@Autowired
	public ProfilMetier profilMetier;
	@Autowired
	public ActionHelper actionHelper;
	
	private Long idProfil;
	private String nomProfil;
	private Map<String, String> allActionsMap = new HashMap<String, String>();
	private Map<String, String> profilActionsMap = new HashMap<String, String>();
	private String status;
	
	@Override
	public String execute() throws Exception {
		try {
			//get profil from db
			Profil profil = profilMetier.get(idProfil);
			List<String> actions = profil.getActions();
			
			//Model title
			nomProfil = profil.getNomProfil();
			
			//inflate profilActionsMap
			for(String action : actions){
				profilActionsMap.put(action, actionHelper.getAction(action));
			}
			
			//get profilBase from db
			Profil profilBase = profilMetier.get(profil.getRoleBase());
			List<String> baseActions = profilBase.getActions();
			
			//inflate profilActionsMap
			for(String action : baseActions){
				allActionsMap.put(action, actionHelper.getAction(action));
			}
			
			status = ActionSupport.SUCCESS;
		} catch (Exception e) {
		
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}

	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, String> getAllActionsMap() {
		return allActionsMap;
	}

	public void setAllActionsMap(Map<String, String> allActionsMap) {
		this.allActionsMap = allActionsMap;
	}

	public Map<String, String> getProfilActionsMap() {
		return profilActionsMap;
	}

	public void setProfilActionsMap(Map<String, String> profilActionsMap) {
		this.profilActionsMap = profilActionsMap;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

}
