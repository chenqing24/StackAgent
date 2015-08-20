package cq.core.action;

import java.io.IOException;

import cq.core.Env;
import cq.core.exception.ActionException;

/**
 * 输出
 * 
 * @author chenqing24@163.com
 */
public final class Out {

    public void print(String string) {
        try {
            Env.response().getWriter().write(string);
        } catch (IOException e) {
            throw new ActionException(e);
        }
    }

}
