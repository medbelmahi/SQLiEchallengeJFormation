package com.sqli.echallenge.jformation.web;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;

public class SqliActionSupport extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1201971517740720167L;
	
	public static final String SESSION_USER_FIELD = "utilisateur";
	public static final String SESSION_ACTION_ERROR_FIELD = "action_error";
	public static final String SESSION_ACTION_MESSAGE_FIELD = "action_message";
	
	
	public static final String PARTIAL_AUTHORIZATION_REQUIRED_RESULT = "forbiddenAction";
	public static final String COMPLETE_AUTHORIZATION_REQUIRED_RESULT = "forbiddenRessource";
	
	public static final String INDEX_ADMINISTRATEUR_RESULT = "index_administrateur";
	public static final String INDEX_RESPO_FORMATION_RESULT = "index_respo_formation";
	public static final String INDEX_FORMATEUR_RESULT = "index_formateur";
	
	private SessionMap<String, Object> session;
	
	//SessionAware Method
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	
	public SessionMap<String, Object> getSession() {
		return session;
	}
	
	//Session Hundler
	public void setSessionField(String key, Object value){
		session.put(key, value);
	}
	
	public void setSessionUser(Utilisateur utilisateur){
		setSessionField(SESSION_USER_FIELD, utilisateur);
	}
	
	public Utilisateur getSessionUser(){
		return (Utilisateur) session.get(SESSION_USER_FIELD);
	}
	
	public void setSessionActionErrorText(String error){
		setSessionField(SESSION_ACTION_ERROR_FIELD, error);
	}
	
	public void setSessionActionMessageText(String message){
		setSessionField(SESSION_ACTION_MESSAGE_FIELD, message);
	}
	
	public String getSessionActionErrorText(){
		String error = (String) session.get(SESSION_ACTION_ERROR_FIELD);
		session.remove(SESSION_ACTION_ERROR_FIELD);
		return error;
	}
	
	public String getSessionActionMessageText(){
		String message = (String) session.get(SESSION_ACTION_MESSAGE_FIELD);
		session.remove(SESSION_ACTION_MESSAGE_FIELD);
		return message;
	}
	
	public boolean isSessionActionError(){
		return (session.get(SESSION_ACTION_ERROR_FIELD) != null) ? true : false;
	}
	
	public boolean isSessionActionMessage(){
		return (session.get(SESSION_ACTION_MESSAGE_FIELD) != null) ? true : false;
	}
	
	public void sessionDestroy(){
		session.invalidate();
	}
	//End Session Hundler
}
