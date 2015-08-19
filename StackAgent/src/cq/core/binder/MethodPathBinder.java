package cq.core.binder;

import cq.core.Env;
import cq.core.exception.ActionException;

/**
 * 访问url绑定抽象
 * 
 * @author chenqing24@163.com
 */
public abstract class MethodPathBinder implements Binder {

    private static final String UNDEFINED_PATH = "Undefined path";

    @Override
    public Runnable bind() throws ActionException {
        String path = extractPath();
        String method = Env.request().getMethod();
        Runnable route = bind(method, path);
        return route;
    }

    // 绑定访问方法和path
    protected abstract Runnable bind(String method, String path);

    // 获取访问path
    private String extractPath() throws ActionException {
        String path = Env.request().getPathInfo();
        if (path == null) {
            path = Env.request().getServletPath();
            if (path == null) {
                throw new ActionException(UNDEFINED_PATH);
            }
        }
        return path;
    }

}
