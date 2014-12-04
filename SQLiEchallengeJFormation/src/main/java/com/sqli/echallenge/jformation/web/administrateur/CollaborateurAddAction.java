/**
 * 
 */
package com.sqli.echallenge.jformation.web.administrateur;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.util.FileHelper;
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailThread;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurAddAction extends SqliActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = -7968028204363016406L;
	private static final String SAVE_DIR = "src/main/resources/avatars";
	private static final String DEFAULT_AVATAR = "avatar.png";
	private static final String TEMPLATE_MAIL = "template/collaborateur-new-created-template.vm";
	
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	@Autowired
	public SqliMailThread sqliMailThread;
	
	private HttpServletRequest servletRequest;
	
	//Image (avatar) file
	private File fileImage;
	private String fileImageContentType;
	private String fileImageFileName;
	
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String telephone;
	private String adresse;
	private String sexe;//Homme or Femme

	@Override
	public String execute() throws Exception {
		
		try{
			//Create new Collaborateur
			Collaborateur collaborateur = new Collaborateur();
			collaborateur.setNomCollaborateur(nom);
			collaborateur.setPrenomCollaborateur(prenom);
			collaborateur.setEmailCollaborateur(email);
			collaborateur.setDateNaissanceCollaborateur(dateNaissance);
			collaborateur.setTelephoneCollaborateur(telephone);
			collaborateur.setAdresseCollaborateur(adresse);
			collaborateur.setSexeCollaborateur(sexe);
			
			//set Image Avatar
			collaborateur.setUrlPhotoCollaborateur(saveImage());
			
			//add collaboretuer
			collaborateurMetier.add(collaborateur);
			
			//Send Mail to New utilisateur (Thread)!!!!!
			SqliEmailModel model = new SqliEmailModel();
			model.addModel(collaborateur.getFullname());
			//Prepare Mail Thread
			sqliMailThread.setEmail(collaborateur.getEmailCollaborateur());
			sqliMailThread.setModel(model);
			sqliMailThread.setTemplate(TEMPLATE_MAIL);
			sqliMailThread.start();
			
			setSessionActionMessageText(getText("collaborateur.new.add.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
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

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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
	@RequiredStringValidator(shortCircuit=true)
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	@SuppressWarnings("deprecation")
	private String saveImage() throws IOException{
		if(fileImage == null){
			String contextPath = servletRequest.getContextPath();
			File saveDirContext = new File(contextPath, SAVE_DIR);
			File fileToSaveContext = new File(saveDirContext, DEFAULT_AVATAR);
			
			return fileToSaveContext.toString();
		}
		
		//Get paths reat + context
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
}