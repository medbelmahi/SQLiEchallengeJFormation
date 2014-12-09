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
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
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
public class SessionEvaluationQuestionReponseAction extends SqliActionSupport {
	private static final long serialVersionUID = -4319893417356268385L;

	@Autowired
	public SessionInscriptionMetier inscriptionMetier;
	@Autowired
	public EvaluationQuestionMetier questionMetier;
	@Autowired
	public EvaluationReponseMetier reponseMetier;
	@Autowired
	public SessionFormationMetier sessionMetier;
	
	private String code;//code d'inscription a la session

	private Long[] idQuestions;
	private Integer[] scores;
	
	Collaborateur collaborateur = null;
	SessionFormation sessionFormation = null;
	
	private void sqlivalidate() throws Exception {
		try{
			if(idQuestions.length != scores.length){
				throw new SqliException(getText("global.param.error"));
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String execute() throws Exception {
		try {
			//0// validate params
			sqlivalidate();
			
			//1// get collaborateur from db using code
			//2// get session from db using code
			SessionInscription inscription;
			try {
				inscription = inscriptionMetier.get(code);
				
				collaborateur = inscription.getCollaborateur();
				sessionFormation = inscription.getSessionFormation();
			} catch (Exception e) {
				throw new SqliException(getText("collaborateur.show.inscription.fail"));
			}
			
			//2.1// verify if inscription valid or not (using code inscription)
			if(inscription == null || inscription.getConfirmedInscription() == null || inscription.getConfirmedInscription() == false){
				throw new SqliException(getText("collaborateur.NotInscritOrCodeNotValid"));
			}
			
			//3// verify if user already evaluate session
			List<EvaluationReponse> reponses = null;
			try {
				reponses = reponseMetier.getAll(collaborateur.getIdCollaborateur(), sessionFormation.getIdSessionFormation());
			} catch (Exception e) {
				//do nothing
			}
			if(reponses != null && reponses.size() > 0) throw new SqliException(getText("question.response.already"));
			
			//4// create repsonse for question
			for(int i=0; i<idQuestions.length; i++){
				//create new reponse
				EvaluationReponse reponse = new EvaluationReponse();
				
				//inflate reponse
				reponse.setScore(scores[i]);
				reponse.setQuestion(questionMetier.get(idQuestions[i]));
				reponse.setCollaborateur(collaborateur);
				reponse.setSession(sessionFormation);
				
				//add to db
				reponseMetier.add(reponse);
			}
			
			//5// show success message
			setSessionActionMessageText(getText("question.reponse.success"));
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

	@RequiredFieldValidator(shortCircuit=true)
	public Long[] getIdQuestions() {
		return idQuestions;
	}

	public void setIdQuestions(Long[] idQuestions) {
		this.idQuestions = idQuestions;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Integer[] getScores() {
		return scores;
	}

	public void setScores(Integer[] scores) {
		this.scores = scores;
	}


	public Collaborateur getCollaborateur() {
		return collaborateur;
	}


	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}
}
