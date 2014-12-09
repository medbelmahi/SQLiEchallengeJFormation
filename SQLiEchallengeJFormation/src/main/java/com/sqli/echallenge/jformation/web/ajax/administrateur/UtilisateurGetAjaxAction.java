/**
 * 
 */
package com.sqli.echallenge.jformation.web.ajax.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliDateHelper;
import com.sqli.echallenge.jformation.util.UserHelper;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurGetAjaxAction extends SqliActionSupport {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private Long idUtilisateur;
	private String status;
	
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String telephone;
	private String adresse;
	private String sexe;
	private Long profil;//idProfil
	private String imageProfil;
	
	@Override
	public String execute() throws Exception {
		try {
			Utilisateur utilisateur = utilisateurMetier.getUtilisateur(idUtilisateur);
			nom = utilisateur.getNomUtilsateur();
			prenom = utilisateur.getPrenomUtilisateur();
			email = utilisateur.getEmailUtilisateur();
			dateNaissance = SqliDateHelper.getDateString(utilisateur.getDateNaissanceUtilisateur());
			telephone = utilisateur.getTelephoneUtilisateur();
			adresse = utilisateur.getAdresseUtilisateur();
			sexe = utilisateur.isSexeUtilisateur();
			imageProfil = utilisateur.getUrlPhotoUtilisateur();
			
			profil = utilisateur.getProfil().getIdProfil();
			
			status = ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	public String getImageProfil() {
		return imageProfil;
	}

	public void setImageProfil(String imageProfil) {
		this.imageProfil = imageProfil;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getProfil() {
		return profil;
	}

	public void setProfil(Long profil) {
		this.profil = profil;
	}
	
	public String getFullname(){
		return UserHelper.getFullname(nom, prenom);
	}
}
