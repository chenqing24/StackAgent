package cq.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import cq.core.Env;
import cq.core.exception.ActionException;

/**
 * 指向目标
 * 
 * @author chenqing24@163.com
 */
public class Forward {

    public void go(final String target) {
        final RequestDispatcher dispatcher = Env.context().getRequestDispatcher(target);
        try {
            dispatcher.forward(Env.request(), Env.response());
        } catch (ServletException e) {
            throw new ActionException(e);
        } catch (IOException e) {
            throw new ActionException(e);
        }
    }

    public void redirect(String location) {
        try {
            Env.response().sendRedirect(location);
        } catch (IOException e) {
            throw new ActionException(e);
        }
    }
}
