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
			Collaborateur collaborateur = null;
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
			
			//4// create repsonse for question
			for(int i=0; i<idQuestions.length; i++){
				//create new reponse
				EvaluationReponse reponse = new EvaluationReponse();
				
				//inflate reponse
				reponse.setScore(scores[i]);
				reponse.setQuestion(questionMetier.get(idQuestions[i]));
				reponse.setCollaborateur(collaborateur);
				reponse.setSession(session);
				
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
	
}
