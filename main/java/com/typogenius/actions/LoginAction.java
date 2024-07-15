
package com.typogenius.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.AdminDAO;
import com.typogenius.models.Admin;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();

		Admin admin = AdminDAO.getInstance().loginCheck(username, password);
		if (admin != null) {
			session.setAttribute("AdminData", admin);
			session.setAttribute("successMessage", "Login Successful");
			return SUCCESS;
		} else {
			addActionError("Login Failed");
			session.setAttribute("errorMessage", "Login Failed");
			return ERROR;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

/*
 * package com.typogenius.actions;
 * 
 * import javax.servlet.http.HttpSession; import
 * org.apache.struts2.ServletActionContext; import
 * com.opensymphony.xwork2.ActionSupport; import
 * com.typogenius.database.AdminDAO; import com.typogenius.models.Admin; import
 * java.util.HashMap; import java.util.Map; import
 * org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
 * 
 * public class LoginAction extends ActionSupport { private static final Logger
 * logger = LogManager.getLogger(LoginAction.class);
 * 
 * private String username; private String password; private Map<String, Object>
 * jsonResponse = new HashMap<>();
 * 
 * public String execute() { logger.info("Executing login action for user: {}",
 * username); HttpSession session =
 * ServletActionContext.getRequest().getSession(); Admin admin =
 * AdminDAO.getInstance().loginCheck(username, password);
 * 
 * if (admin != null) { session.setAttribute("AdminData", admin);
 * jsonResponse.put("status", "success"); jsonResponse.put("message",
 * "Login Successful"); jsonResponse.put("admin", admin);
 * logger.info("Login successful for user: {}", username); return SUCCESS; }
 * else { addActionError("Login Failed"); jsonResponse.put("status", "error");
 * jsonResponse.put("message", "Login Failed");
 * logger.warn("Login failed for user: {}", username); return ERROR; } }
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public Map<String, Object> getJsonResponse() { return jsonResponse; }
 * 
 * public void setJsonResponse(Map<String, Object> jsonResponse) {
 * this.jsonResponse = jsonResponse; } }
 */