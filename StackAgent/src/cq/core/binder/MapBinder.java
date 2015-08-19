package cq.core.binder;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 绑定map实现
 * 
 * @author chenqing24@163.com
 */
public class MapBinder extends MethodPathBinder {
    private Runnable notFoundRoute;

    /** 
     * { method => { path => action-route } }
     */
    private final Map<String, Map<String, Runnable>> methodPathMap = new TreeMap<String, Map<String, Runnable>>();

    public Runnable getNotFoundRoute() {
        return notFoundRoute;
    }

    @Override
    public Runnable bind(String method, String path) {
        Runnable route = findRoute(method, path);
        if(route != null) {
            return route;
        }
        return getNotFoundRoute();
    }

    @Override
    public void route(Runnable runnable) {
        notFoundRoute = runnable;
    }

    public void route(final String path, Runnable runnable) {
        route(null, path, runnable);
    }

    public void route(final String method, final String path, Runnable runnable) {
        r(method, path, runnable);
    }

    private Runnable findRoute(String method, String path) {
        Map<String, Runnable> methodMap = methodPathMap.get(method);
        
        if (methodMap == null) {
            methodMap = methodPathMap.get(null);
        }

        return methodMap != null? methodMap.get(path) : null;
    }

    private void r(final String method, final String path, Runnable action) {
        Map<String, Runnable> methodMap = methodPathMap.get(method);
        if(methodMap == null) {
            methodMap = new HashMap<String, Runnable>();
            methodPathMap.put(method, methodMap);
        }
        methodMap.put(path, action);
    }

    @Override
    public void route(String method, String fromPath, String targetPath) {
        throw new IllegalAccessError("Not implemented");
    }

}
