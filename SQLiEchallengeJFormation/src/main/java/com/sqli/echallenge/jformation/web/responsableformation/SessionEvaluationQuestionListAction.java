/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.jformation.metier.EvaluationQuestionMetier;
import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionEvaluationQuestionListAction extends SqliActionSupport {
	private static final long serialVersionUID = 2047500064495757583L;

	@Autowired
	public EvaluationQuestionMetier questionMetier;
	
	private List<EvaluationQuestion> questions;
	
	@Override
	public String execute() throws Exception {
		try{
			//get questions from db
			questions = questionMetier.getAll();
			
			//Ok
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	public List<EvaluationQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<EvaluationQuestion> questions) {
		this.questions = questions;
	}
	
}
