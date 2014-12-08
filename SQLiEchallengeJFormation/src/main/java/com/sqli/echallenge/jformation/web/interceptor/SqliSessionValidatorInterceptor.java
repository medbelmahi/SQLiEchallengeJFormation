package com.sqli.echallenge.jformation.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

public class SqliSessionValidatorInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -6756906607547156248L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//Get conncted user from Session
		Utilisateur user = (Utilisateur) invocation.getInvocationContext().getSession().get(SqliActionSupport.SESSION_USER_FIELD);
		
		//Check if user not connected invoke LoginAction
		if(user == null){
			return invocation.invoke();
		}
		//else (redirect to index)
		return ActionSupport.SUCCESS;
	}
}
