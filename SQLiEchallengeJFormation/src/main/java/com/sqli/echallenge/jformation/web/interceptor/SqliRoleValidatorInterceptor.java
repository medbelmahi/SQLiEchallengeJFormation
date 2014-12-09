package com.sqli.echallenge.jformation.web.interceptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.sqli.echallenge.jformation.model.entity.Utilisateur;
import com.sqli.echallenge.jformation.web.SqliActionSupport;

public class SqliRoleValidatorInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 2070420400409725564L;
	
	private Map<String, Set<String>> roleActions = Collections.emptyMap();
	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//Get conncted utilisateur from Session
		Utilisateur utilisateur = (Utilisateur) invocation.getInvocationContext().getSession().get(SqliActionSupport.SESSION_USER_FIELD);
		
		if(isUtilisateurInRole(utilisateur)){
			if(isUtilisateurHasActions(utilisateur)){
				return invocation.invoke();
				
			}else{
				//!!!!!!!Exception
				//((SqliActionSupport) invocation.getAction()).setSessionActionErrorText(((SqliActionSupport) invocation.getAction()).getText("role.action.not.autorized"));
				
				//set Warning message
				String errorMessage = ((SqliActionSupport) invocation.getAction()).getText("role.action.not.autorized");
				invocation.getInvocationContext().getSession().put(SqliActionSupport.SESSION_ACTION_ERROR_FIELD, errorMessage);
				
				return SqliActionSupport.PARTIAL_AUTHORIZATION_REQUIRED_RESULT;
			}
		}
		
		return SqliActionSupport.COMPLETE_AUTHORIZATION_REQUIRED_RESULT;
	}
	
	//allowedRoles is the parametre from struts.xml
	//Example: "admin: Read, Write;" to "{admin : [Read, Write]}"
	public void setAllowedRoles(String allowedRoles) {
        StringTokenizer roleActionsParamTokenizer = new StringTokenizer(allowedRoles,";");
        roleActions = new HashMap<String, Set<String>>(roleActionsParamTokenizer.countTokens());
        
        while(roleActionsParamTokenizer.hasMoreTokens()) {
                String roleActionArray[] = roleActionsParamTokenizer.nextToken().trim().split(":");
              
                if(roleActionArray.length == 2) {
                        String role = roleActionArray[0].toLowerCase();
                        Set<String> actions = TextParseUtil.commaDelimitedStringToSet(roleActionArray[1]);
                        this.roleActions.put(role,actions);
                }
        }
        
        System.out.println(roleActions);
	}
	
	
	private boolean isUtilisateurInRole(Utilisateur utilisateur){
		//Get role if existe
		String role = (roleActions.keySet().iterator().hasNext()) ? roleActions.keySet().iterator().next() : null;
		
		// All utilisateurs are allowed
		if (role == null || role.equals("*")) {
			return true;
		}
		
		//Check if the utilisateur is In role to invoke the Action
		if(utilisateur!= null){
			if(utilisateur.getProfil() != null && utilisateur.getProfil().getRoleBase().toLowerCase().equals(role)){
				return true;
			}
		}
		
		//The utilisateur is not allowed to invoke the Action
		return false;
	}
	
	private boolean isUtilisateurHasActions(Utilisateur utilisateur){
		//Get actions utilisateur must have
		Set<String> actions = ((roleActions.values().iterator().hasNext())? roleActions.values().iterator().next() : null);
		
		//All utilisateur has or not Actions roles are allowed (*)
		if(actions==null || actions.iterator().next().equals("*")){
			return true;
		}
		
		//Check if utilisateur has ALL the priviliges "actions" that must have to invoke the Action
		//1// 
		if(utilisateur.getProfil().getActions() == null || utilisateur.getProfil().getActions().size() < 1){
			return false;
		}
		
		//2// 
		List<String> userActions = utilisateur.getProfil().getActions();
		for(String action : actions){
			if(!userActions.contains(action)){
				return false;
			}
		}
		return true;
	}
	
}
