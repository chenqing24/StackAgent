package cq.core.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import cq.core.Env;
import cq.core.exception.ActionException;

/**
 * HTTP-Code的特殊转向
 * 
 * @author chenqing24@163.com
 */
public class Send {

    public void to301(Object location) {
        Env.response().setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        Env.response().setHeader("Location", String.valueOf(location));
    }

    public void to302(Object location) {
        Env.response().setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        Env.response().setHeader("Location", String.valueOf(location));
    }
    
    public void to404() {
        try {
            Env.response().sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException e) {
            throw new ActionException(e);
        }
    }
}
