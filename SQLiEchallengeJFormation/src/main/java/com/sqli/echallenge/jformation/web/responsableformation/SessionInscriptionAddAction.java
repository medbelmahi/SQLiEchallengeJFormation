/**
 * 
 */
package com.sqli.echallenge.jformation.web.responsableformation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.jformation.metier.CollaborateurMetier;
import com.sqli.echallenge.jformation.metier.SessionFormationMetier;
import com.sqli.echallenge.jformation.metier.SessionInscriptionMetier;
import com.sqli.echallenge.jformation.model.entity.Collaborateur;
import com.sqli.echallenge.jformation.model.entity.SessionFormation;
import com.sqli.echallenge.jformation.model.entity.SessionInscription;
import com.sqli.echallenge.jformation.util.SqliEmailModel;
import com.sqli.echallenge.jformation.util.SqliMailThread;
import com.sqli.echallenge.jformation.util.SqliRandomGenerator;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

/**
 * @author Mouad
 *
 */
@Controller
public class SessionInscriptionAddAction extends SqliActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 2047500064495757583L;
	private static final String TEMPLATE_MAIL = "template/collaborateur-session-inscription-template.vm";
	
	@Autowired
	public SessionInscriptionMetier sessionInscriptionMetier;
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	@Autowired
	public SessionFormationMetier sessionFormationMetier;
	@Autowired
	public SqliRandomGenerator random;
	@Autowired
	public SqliMailThread emailSender;
	
	private HttpServletRequest servletRequest;
	
	private Long idFormation;
	private Long idSession;
	
	private Long[] idCollaborateurs;
	
	@Override
	public String execute() throws Exception {
		try{
			//get session from db
			SessionFormation session = sessionFormationMetier.get(idSession);
			
			//Email Models List that should be sent
			List<SqliEmailModel> models = new ArrayList<SqliEmailModel>();
			List<String> emails = new ArrayList<String>();
			
			//Create new SessionInscriptions
			if(idCollaborateurs != null){
				for(Long idCollaborateur : idCollaborateurs){
					//get collaborateur from db
					Collaborateur collaborateur = collaborateurMetier.get(idCollaborateur);
					
					//check if collaborateur not registred in other session with same date!!!!!!!!!
					
					//Inflate inscription with data
					SessionInscription inscription = new SessionInscription();
					inscription.setCollaborateur(collaborateur);
					inscription.setSessionFormation(session);
					inscription.setConfirmedInscription(null);//not traited yet
					inscription.setCodeInscription(random.generateRandomString());//generated random code
					
					//save inscription to db & send email
					sessionInscriptionMetier.add(inscription);
					
					//perpare email to be sent
					SqliEmailModel model = new SqliEmailModel();
					model.addModel(collaborateur.getFullname());
					model.addModel(session.getTitreSessionFormation());
					
					model.addModel(servletRequest.getServerName());
					model.addModel(String.valueOf(servletRequest.getServerPort()));
					model.addModel(servletRequest.getContextPath());
					model.addModel(inscription.getCodeInscription());
					//...
					models.add(model);
					emails.add(collaborateur.getEmailCollaborateur());
					
					System.out.println("DEBUG: url: " + servletRequest.getRequestURL());
				}
			}
			//send email to collaborateurs
			emailSender.setModel(models);
			emailSender.setEmail(emails);
			emailSender.setTemplate(TEMPLATE_MAIL);
			emailSender.start();
			
			//show success message
			setSessionActionMessageText(getText("session.inscription.add.new.success"));
			return SqliActionSupport.SUCCESS;
		}catch(Exception e){
			
			//show error message
			setSessionActionErrorText(e.getMessage());
			return SqliActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public Long[] getIdCollaborateurs() {
		return idCollaborateurs;
	}

	public void setIdCollaborateurs(Long[] idCollaborateurs) {
		this.idCollaborateurs = idCollaborateurs;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
}
