/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.jformation.metier.EvaluationQuestionMetier;
import com.sqli.echallenge.jformation.model.entity.EvaluationQuestion;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionEvaluationQuestionAddAction extends SqliActionSupport {
	private static final long serialVersionUID = 2047500064495757583L;

	@Autowired
	public EvaluationQuestionMetier questionMetier;
	
	private String questionText;
	
	@Override
	public String execute() throws Exception {
		try{
			//1// create new question + inflate
			EvaluationQuestion question = new EvaluationQuestion();
			question.setQuestion(questionText);
			
			//2// persist question to db
			questionMetier.add(question);
			
			//3// show success message
			setSessionActionMessageText(getText("question.add.new.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(shortCircuit=true)
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
}
