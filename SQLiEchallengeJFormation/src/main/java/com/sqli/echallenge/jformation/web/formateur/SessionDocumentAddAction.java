/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.DocumentMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.Document;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.FileHelper;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionDocumentAddAction extends SqliActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1518719205870965502L;
	private static final String SAVE_DIR = "src/main/resources/documents";
	
	private HttpServletRequest servletRequest;

	@Autowired
	public SessionFormationMetier sessionMetier;
	@Autowired
	public DocumentMetier documentMetier;
	
	private Long idSession;
	private SessionFormation sessionFormation;
	
	private File[] document;
	private String[] documentContentType;
	private String[] documentFileName;
	
	private String[] descriptionDocument;
	
	private void sqlivalidate() throws Exception {
		//1// parmas
		if(document.length != descriptionDocument.length){
			throw new SqliException(getText("global.param.error"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		try {
			//validate params
			sqlivalidate();
			
			//get Formateur from session
			Utilisateur formateur = getSessionUser();
			
			//get session from db (get seances inside sessionFormation)
			sessionFormation = sessionMetier.get(idSession);
			
			//Check:
			//1// is connected formateur the owner of this session
			if(!sessionFormation.getFormateur().getIdUtilisateur().equals(formateur.getIdUtilisateur())){
				throw new SqliException(getText("session.id.notfound"));
			}
			
			//add documents
			for(int i=0; i<document.length; i++){
				//1// save file physically
				String urlDocument = saveDocument(document[i], documentFileName[i]);
				
				//2// create new document + inflate it 
				Document doc = new Document();
				doc.setNomDocument(documentFileName[i]);
				doc.setDescriptionDocument(descriptionDocument[i]);
				doc.setUrlDocument(urlDocument);
				doc.setSessionFormation(sessionFormation);
				
				//3// save file in db
				documentMetier.add(doc);
			}
			
			//show message success
			setSessionActionMessageText(getText("document.add.success"));
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {

			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public File[] getDocument() {
		return document;
	}

	public void setDocument(File[] document) {
		this.document = document;
	}

	public String[] getDocumentContentType() {
		return documentContentType;
	}

	public void setDocumentContentType(String[] documentContentType) {
		this.documentContentType = documentContentType;
	}

	public String[] getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String[] documentFileName) {
		this.documentFileName = documentFileName;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String[] getDescriptionDocument() {
		return descriptionDocument;
	}

	public void setDescriptionDocument(String[] descriptionDocument) {
		this.descriptionDocument = descriptionDocument;
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	@SuppressWarnings("deprecation")
	private String saveDocument(File document, String documentFileName) throws IOException {
		//get paths reat + context
		String serverRealPath = servletRequest.getRealPath("/");
		String contextPath = servletRequest.getContextPath();

		//create Files
		File saveDirContext = new File(contextPath, SAVE_DIR);
		File saveDirReal = new File(serverRealPath, SAVE_DIR);
		
		//generate names and prepare URI
		String generatedName = new FileHelper().setRandomName(documentFileName);
		File fileToSaveReal = new File(saveDirReal, generatedName);
		File fileToSaveContext = new File(saveDirContext, generatedName);

		System.out.println(">URIreal: " + fileToSaveReal);
		System.out.println(">URIcontext: " + fileToSaveContext);
		
		//save file
		FileUtils.copyFile(document, fileToSaveReal);
		
		return fileToSaveContext.toString();
	}

}
