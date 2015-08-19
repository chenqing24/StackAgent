package cq.core.old;

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
	protected String json;					// 反馈的json
	protected Pages pages;				  	// 分页对象
	
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
	
	public void setPage(int page) {
		if (pages == null) {
			pages = new Pages();
		}
		pages.setCpage(page);
	}

	public void setRows(int rows) {
		if (pages == null) {
			pages = new Pages();
		}
		pages.setPageNum(rows);
	}
	
	public void setSidx (String sidx) {
		if (pages == null) {
			pages = new Pages();
		}
		pages.setSidx(sidx);
	}

	public void setSord (String sord) {
		if (pages == null) {
			pages = new Pages();
		}
		pages.setSord(sord);
	}

	public Pages getPages() {
		return pages;
	}

	public void setPages(Pages pages) {
		this.pages = pages;
	}
}
