package cq.core;

import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Runtime变量副本
 * @author chenqing24@163.com
 */
public class Env {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext context;
    private Map<String, String> params = Collections.emptyMap(); 
    
    private static ThreadLocal<Env> locals = new ThreadLocal<Env>(); 

    private Env(HttpServletRequest request, HttpServletResponse response,
            ServletContext context) {
        this.request = request;
        this.response = response;
        this.context = context;
    }
        
    public static void create(HttpServletRequest request, HttpServletResponse response,
            ServletContext context) {
        locals.set(new Env(request, response, context));
    }
    
    public static void destroy() {
        locals.remove();
    }

    public static Env get() {
        return locals.get();
    }
    
    public static HttpServletRequest request() {
        return get().getRequest();
    }

    public static HttpServletResponse response() {
        return get().getResponse();
    }
    
    public static ServletContext context() {
        return get().getContext();
    }

    public static void setResourceParams(Map<String, String> params) {
        get().setParams(params);
    }

    public static String params(String key) {
        Map<String, String> _params = get().getParams();
        String string = _params.get(key);
        if(string == null) {
            return Env.request().getParameter(key);
        }
        return string;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getParams() {
        return params;
    }

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @return the context
	 */
	public ServletContext getContext() {
		return context;
	}

}
