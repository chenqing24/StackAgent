package cq.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Action模板
 * @author chenqing24@163.com
 */
public class BaseAction {
	protected static Log logger = LogFactory.getLog(BaseAction.class);
	
	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;	
	protected String json;	//	反馈的json
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	public HttpSession getSession() {
		return session;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
		
}
