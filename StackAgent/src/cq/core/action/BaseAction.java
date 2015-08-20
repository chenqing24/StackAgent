package cq.core.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cq.core.Env;

/**
 * Action基本类
 * 
 * @author chenqing24@163.com
 */
public abstract class BaseAction implements Runnable {

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

}
