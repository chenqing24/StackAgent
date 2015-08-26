package cq.core.action;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

import cq.core.Env;

/**
 * Action基本类
 * 
 * @author chenqing24@163.com
 */
public abstract class BaseAction implements Runnable {
	private HashMap<String, Object> tplMap = new HashMap<String, Object>();	// 模板map

	protected String params(String key) {
		return Env.params(key);
	}

	protected HttpServletRequest request() {
		return Env.request();
	}

	protected HttpServletResponse response() {
		return Env.response();
	}

	protected ServletContext context() {
		return Env.context();
	}

	protected void forward(String target) {
		new Forward().go(target);
	}

	protected void movedPermanently(String newLocation) {
		new Send().to301(newLocation);
	}

	protected void movedTemporarily(String newLocation) {
		new Send().to302(newLocation);
	}

	protected void notFound() {
		new Send().to404();
	}

	protected void redirect(String newLocation) {
		new Forward().redirect(newLocation);
	}

	protected void print(String string) {
		new Out().print(string);
	}

	/**
	 * @return the tplMap
	 */
	public HashMap<String, Object> getTplMap() {
		return tplMap;
	}

	/**
	 * @param tplMap the tplMap to set
	 */
	public void setTplMap(HashMap<String, Object> tplMap) {
		this.tplMap = tplMap;
	}

	/**
	 * 向模板map中设参
	 * @param key
	 * @param value
	 */
	protected void putTplMap(String key, Object value){
		this.tplMap.put(key, value);
	}

	/**
	 * 
	 * @param string
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected void tplPrint(String expression) throws Exception {
		// 创建模板引擎
		JexlContext jc = JexlHelper.createContext();
		Expression e = ExpressionFactory.createExpression(expression); 
		for (String key : tplMap.keySet()){
			jc.getVars().put(key, tplMap.get(key));
		}
		
		String outPrint = "";
		if (null != e.evaluate(jc))
			outPrint = (String) e.evaluate(jc);
		
		new Out().print(outPrint);
	}
}
