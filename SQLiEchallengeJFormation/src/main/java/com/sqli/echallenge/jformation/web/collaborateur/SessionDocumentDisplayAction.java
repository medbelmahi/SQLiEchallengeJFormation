/**
 * 
 */
package com.sqli.echallenge.jformation.web.collaborateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.DocumentMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Document;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionDocumentDisplayAction extends SqliActionSupport {
	private static final long serialVersionUID = -867281139644932294L;

	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	@Autowired
	public DocumentMetier documentMetier;
	
	private String code;
	private SessionInscription inscription;
	
	private List<Document> documents;
	
	@Override
	public String execute() throws Exception {
		try {
			//1// get inscription form db
			inscription = inscriptionMetier.get(code);
			
			//2// get all documents of session
			documents = documentMetier.getAll(inscription.getSessionFormation().getIdSessionFormation());
			
			//3// show success message
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			// show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SessionInscription getInscription() {
		return inscription;
	}

	public void setInscription(SessionInscription inscription) {
		this.inscription = inscription;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
}
