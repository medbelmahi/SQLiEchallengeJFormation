/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sqli.echallenge.jformation.metier.ProfilMetier;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliRandomGenerator;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurAddAction extends SqliActionSupport {
	private static final long serialVersionUID = -7968028204363016406L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	@Autowired
	public SqliRandomGenerator sqliRandomGenerator;
	@Autowired
	public ProfilMetier profilMetier;
	
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String telephone;
	private String adresse;
	private Long profil;//idProfil
	private String sexe;//Homme or Femme

	@Override
	public String execute() throws Exception {
		try{
			//Create new Utilisateur
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNomUtilsateur(nom);
			utilisateur.setPrenomUtilisateur(prenom);
			utilisateur.setEmailUtilisateur(email);
			utilisateur.setTelephoneUtilisateur(telephone);
			utilisateur.setAdresseUtilisateur(adresse);
			utilisateur.setSexeUtilisateur(sexe);
			
			//generate password
			utilisateur.setPasswordUtilisateur(sqliRandomGenerator.generateRandomString());
			
			//get profil from db and set it
			utilisateur.setProfil(profilMetier.getProfil(profil));
			
			//add Utilisateur
			utilisateurMetier.add(utilisateur);
			
			setSessionActionMessageText(getText("utilisateur.new.add.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			//show error message
			setSessionActionMessageText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	@EmailValidator(shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	@RegexFieldValidator(type = ValidatorType.SIMPLE, regex = "^0?[5-6]{1}\\d{8}")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getProfil() {
		return profil;
	}

	public void setProfil(Long profil) {
		this.profil = profil;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
}
