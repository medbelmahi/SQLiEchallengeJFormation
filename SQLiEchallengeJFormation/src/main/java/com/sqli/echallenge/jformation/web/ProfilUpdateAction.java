/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.sqli.echallenge.jformation.util.FileHelper;
import com.sqli.echallenge.jformation.util.SqliException;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilUpdateAction extends SqliActionSupport implements ServletRequestAware  {
	private static final long serialVersionUID = -4525937072103982290L;
	private static final String SAVE_DIR = "src/main/resources/avatars";

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private HttpServletRequest servletRequest;
	
	private String nom;
	private String prenom;
	private String email;
	private String oldPassword;
	private String newPassword;
	private String adresse;
	private String telephone;
	private Date dateNaissance;
	
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
			String shaOldPassword = Hashing.sha1().hashString( oldPassword, Charsets.UTF_8 ).toString();
			if(!shaOldPassword.equals(utilisateur.getPasswordUtilisateur())){
				throw new SqliException(getText("utilisateur.updateProfil.passwordNotMatch"));
			}
			
			//1.2// hash new password
			String shaNewPassword = Hashing.sha1().hashString( newPassword, Charsets.UTF_8 ).toString();
			
			//2.1// update Utilisateur
			utilisateur.setNomUtilsateur(nom);
			utilisateur.setPrenomUtilisateur(prenom);
			utilisateur.setEmailUtilisateur(email);
			utilisateur.setPasswordUtilisateur(shaNewPassword);
			utilisateur.setAdresseUtilisateur(adresse);
			utilisateur.setTelephoneUtilisateur(telephone);
			utilisateur.setDateNaissanceUtilisateur(dateNaissance);
			
			//2.2//update photo de profil
			//set Image Avatar
			if(fileImage != null) utilisateur.setUrlPhotoUtilisateur(saveImage());
			
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

	private String saveImage() throws Exception {
		//Get paths reat + context
		@SuppressWarnings("deprecation")
		String serverRealPath = servletRequest.getRealPath("/");
		String contextPath = servletRequest.getContextPath();

		//create Files
		File saveDirContext = new File(contextPath, SAVE_DIR);
		File saveDirReal = new File(serverRealPath, SAVE_DIR);
		
		//generate names and prepare URI
		String generatedName = new FileHelper().setRandomName(fileImageFileName);
		File fileToSaveReal = new File(saveDirReal, generatedName);
		File fileToSaveContext = new File(saveDirContext, generatedName);

		System.out.println(">URIreal: " + fileToSaveReal);
		System.out.println(">URIcontext: " + fileToSaveContext);
		
		//save image
		FileUtils.copyFile(fileImage, fileToSaveReal);
		
		return fileToSaveContext.toString();
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
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
	@RequiredStringValidator(shortCircuit=true)
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
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
}
