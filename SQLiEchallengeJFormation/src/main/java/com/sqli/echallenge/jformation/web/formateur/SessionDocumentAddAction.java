/**
 * 
 */
package com.sqli.echallenge.jformation.web.formateur;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.DocumentMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.model.entity.Document;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.util.SqliFileHelper;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionDocumentAddAction extends SqliActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1518719205870965502L;
	
	private HttpServletRequest servletRequest;

	@Autowired
	public SessionFormationMetier sessionMetier;
	@Autowired
	public DocumentMetier documentMetier;
	@Autowired
	public SqliFileHelper sqliFileHelper;
	
	private Long idSession;
	private SessionFormation sessionFormation;
	
	private File document;
	private String documentContentType;
	private String documentFileName;
	
	private String descriptionDocument;
	private String nomDocument;
	
	
	@Override
	public String execute() throws Exception {
		try {
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
			//1// save file physically
			String urlDocument = sqliFileHelper.saveDocument(document, documentFileName);
			
			//2// create new document + inflate it 
			Document doc = new Document();
			doc.setNomDocument(documentFileName);
			doc.setDescriptionDocument(descriptionDocument);
			doc.setUrlDocument(urlDocument);
			doc.setSessionFormation(sessionFormation);
			
			//3// save file in db
			documentMetier.add(doc);
			
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
	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}

	public String getDocumentContentType() {
		return documentContentType;
	}

	public void setDocumentContentType(String documentContentType) {
		this.documentContentType = documentContentType;
	}

	public String getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getDescriptionDocument() {
		return descriptionDocument;
	}

	public void setDescriptionDocument(String descriptionDocument) {
		this.descriptionDocument = descriptionDocument;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getNomDocument() {
		return nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
}
