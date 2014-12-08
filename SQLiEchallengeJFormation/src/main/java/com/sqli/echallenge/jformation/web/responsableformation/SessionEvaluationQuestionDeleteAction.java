/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.EvaluationQuestionMetier;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionEvaluationQuestionDeleteAction extends SqliActionSupport {
	private static final long serialVersionUID = 2047500064495757583L;

	@Autowired
	public EvaluationQuestionMetier questionMetier;
	
	private Long idQuestion;
	
	@Override
	public String execute() throws Exception {
		try{
			//delete questions from db
			questionMetier.delete(idQuestion);
			
			//show success message
			setSessionActionMessageText(getText("question.delete.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}
	
}
