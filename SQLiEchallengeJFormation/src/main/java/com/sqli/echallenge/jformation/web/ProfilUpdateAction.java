/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.util.SqliFileHelper;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilUpdateAction extends SqliActionSupport implements ServletRequestAware  {
	private static final long serialVersionUID = -4525937072103982290L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	@Autowired
	public SqliFileHelper sqliFileHelper;
	
	private HttpServletRequest servletRequest;
	
	private String nom;
	private String prenom;
	private String email;
	private String sexe;
	private String oldPassword;
	private String newPassword;
	private String adresse;
	private String telephone;
	private Date dateNaissance;
	private boolean changePassword;
	
	//Image (avatar) file
	private File fileImage;
	private String fileImageContentType;
	private String fileImageFileName;
	
	@Override
	public String execute() throws Exception {
		try {
			//1// get user from session
			Utilisateur utilisateur = getSessionUser();
			
			//1.1// check oldPassword = user.password
			if(changePassword){
				//1.2// 
				if((oldPassword==null || oldPassword.isEmpty())||(newPassword==null || newPassword.isEmpty())) throw new SqliException(getText("utilisateur.updateProfil.passwordNotMatch"));
				
				//1.2// hash two passwords
				String shaOldPassword = Hashing.sha1().hashString(oldPassword, Charsets.UTF_8 ).toString();
				String shaNewPassword = Hashing.sha1().hashString(newPassword, Charsets.UTF_8 ).toString();
				
				//1.3// 
				if(!utilisateur.getPasswordUtilisateur().equals(shaOldPassword)){
					throw new SqliException(getText("utilisateur.updateProfil.passwordNotMatch"));
				}
				
				//1.3// update
				utilisateur.setPasswordUtilisateur(shaNewPassword);
			}
			
			//2.1// update Utilisateur
			utilisateur.setNomUtilsateur(nom);
			utilisateur.setPrenomUtilisateur(prenom);
			utilisateur.setEmailUtilisateur(email);
			utilisateur.setAdresseUtilisateur(adresse);
			utilisateur.setTelephoneUtilisateur(telephone);
			utilisateur.setDateNaissanceUtilisateur(dateNaissance);
			utilisateur.setSexeUtilisateur(sexe);
			
			//2.2//update photo de profil
			//set Image Avatar
			if(fileImage != null){
				utilisateur.setUrlPhotoUtilisateur(sqliFileHelper.saveDocument(fileImage, fileImageFileName));
			}
			
			//3// merge utilisateur
			utilisateurMetier.update(utilisateur);
			
			//4// show success message
			setSessionActionMessageText(getText("utilisateur.updateProfil.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
	@RequiredStringValidator(shortCircuit=true)
	@RegexFieldValidator(type = ValidatorType.SIMPLE, regex = "^0?[5-6]{1}\\d{8}")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public File getFileImage() {
		return fileImage;
	}

	public void setFileImage(File fileImage) {
		this.fileImage = fileImage;
	}

	public String getFileImageContentType() {
		return fileImageContentType;
	}

	public void setFileImageContentType(String fileImageContentType) {
		this.fileImageContentType = fileImageContentType;
	}

	public String getFileImageFileName() {
		return fileImageFileName;
	}

	public void setFileImageFileName(String fileImageFileName) {
		this.fileImageFileName = fileImageFileName;
	}

	public String getSexe() {
		return sexe;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
}
