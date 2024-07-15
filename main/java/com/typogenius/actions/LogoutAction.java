package com.typogenius.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute()
	{
		 HttpSession session = ServletActionContext.getRequest().getSession();
	        session.invalidate();
	        return SUCCESS;
	}
}
