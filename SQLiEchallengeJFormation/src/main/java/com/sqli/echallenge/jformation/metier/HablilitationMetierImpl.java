/**
 * 
 */
package com.sqli.echallenge.jformation.metier;

import java.util.ArrayList;
import java.util.Iterator;
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
			List<Habilitation> habilitations = new ArrayList<Habilitation>();
			
			Iterator<Object[]> it = dao.getHabilitationCollaborateurs(idCollaborateur).iterator();
			
			while(it.hasNext()){
				Object[] row = (Object[])it.next();
				
				Habilitation habilitation = new Habilitation();
				habilitation.setIdHabilitation(Long.valueOf(row[0].toString()));
				habilitation.setNomHabilitation(row[1].toString());
				habilitation.setDescriptionHabilitation(row[2].toString());
				
				habilitations.add(habilitation);
			}
			
			return habilitations;
			
		}catch(Exception e){

			throw new SqliException(propretiesHelper.getText("habilitation.list.load.fail"));
		}
	}

	public List<Habilitation> getHabilitationNonCollaborateurs(Long idCollaborateur) throws Exception {
		try{
			List<Habilitation> habilitations = new ArrayList<Habilitation>();

			Iterator<Object[]> it = dao.getHabilitationNonCollaborateurs(idCollaborateur).iterator();
			
			while(it.hasNext()){
				Object[] row = (Object[])it.next();
				
				Habilitation habilitation = new Habilitation();
				habilitation.setIdHabilitation(Long.valueOf(row[0].toString()));
				habilitation.setNomHabilitation(row[1].toString());
				habilitation.setDescriptionHabilitation(row[2].toString());
				
				habilitations.add(habilitation);
			}
			
			return habilitations;
			
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("habilitation.list.load.fail"));
		}
	}
	
	public void addHabilitationToCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception {
		try{
			dao.addHabilitationToCollaborateur(idCollaborateur, idHabilitation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.habilitation.add.fail"));
		}
	}

	public void deleteHabilitationFromCollaborateur(Long idCollaborateur, Long idHabilitation) throws Exception {
		try{
			dao.deleteHabilitationFromCollaborateur(idCollaborateur, idHabilitation);
		}catch(Exception e){
			throw new SqliException(propretiesHelper.getText("collaborateur.habilitation.delete.fail"));
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
