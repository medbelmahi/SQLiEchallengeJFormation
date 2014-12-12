/**
 * 
 */
package com.sqli.echallenge.jformation.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.jformation.metier.UtilisateurMetier;


@Controller
public class TestAction extends ActionSupport implements ServletRequestAware  {
	private static final long serialVersionUID = 7127140319576353508L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	private HttpServletRequest servletRequest;
	
	@Override
	public synchronized String execute() throws Exception {
		
		System.out.println("context: " + servletRequest.getContextPath());
		System.out.println("addr: " + servletRequest.getLocalAddr());
		System.out.println("name: " + servletRequest.getLocalName());
		System.out.println("port: " + servletRequest.getLocalPort());
		System.out.println("method: " + servletRequest.getMethod());
		System.out.println("path info: " + servletRequest.getPathInfo());
		System.out.println("path translate: " + servletRequest.getPathTranslated());
		System.out.println("query: " + servletRequest.getQueryString());
		System.out.println("remote add: " + servletRequest.getRemoteAddr());
		System.out.println("remote host: " + servletRequest.getRemoteHost());
		System.out.println("remote port: " + servletRequest.getRemotePort());
		System.out.println("request uri: " + servletRequest.getRequestURI());
		System.out.println("shema: " + servletRequest.getScheme());
		System.out.println("servername: " + servletRequest.getServerName());
		System.out.println("servlet port: " + servletRequest.getServerPort());
		System.out.println("request url: " + servletRequest.getRequestURL());

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
}
