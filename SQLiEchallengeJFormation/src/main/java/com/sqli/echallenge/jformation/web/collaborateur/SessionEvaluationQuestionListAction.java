/**
 * 
 */
package com.sqli.echallenge.jformation.web.collaborateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.EvaluationQuestionMetier;
import com.sqli.echallenge.jformation.metier.EvaluationReponseMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;
import com.sqli.echallenge.jformation.model.entity.EvaluationReponse;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.util.SqliException;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionEvaluationQuestionListAction extends SqliActionSupport {
	private static final long serialVersionUID = -4319893417356268385L;

	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	@Autowired
	public EvaluationQuestionMetier questionMetier;
	@Autowired
	public EvaluationReponseMetier reponseMetier;
	
	private String code;//code d'inscription a la session
	
	List<EvaluationQuestion> questions;
	Collaborateur collaborateur;
	
	public String execute() throws Exception {
		try {
			//1// get collaborateur from db using code
			//2// get session from db using code
			SessionFormation session = null;
			try {
				SessionInscription inscription = inscriptionMetier.get(code);
				
				collaborateur = inscription.getCollaborateur();
				session = inscription.getSessionFormation();
			} catch (Exception e) {
				throw new SqliException(getText("collaborateur.show.inscription.fail"));
			}
			
			//3// verify if user already evaluate session
			List<EvaluationReponse> reponses = null;
			try {
				reponses = reponseMetier.getAll(collaborateur.getIdCollaborateur(), session.getIdSessionFormation());
			} catch (Exception e) {
				//do nothing
			}
			if(reponses != null && reponses.size() > 0) throw new SqliException(getText("question.response.already"));
			
			//3// get questions from db
			questions = questionMetier.getAll();
			
			return SqliActionSupport.SUCCESS;
		} catch (Exception e) {
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
