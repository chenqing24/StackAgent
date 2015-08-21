package cq.core.route;

import cq.core.action.NotFoundAction;
import cq.core.binder.Binder;
import cq.core.binder.MapBinder;

public abstract class RouteMap implements Route {

    protected static final String POST = "POST";
    protected static final String GET = "GET";
    protected static final String HEAD = "HEAD";
    protected static final String OPTIONS = "OPTIONS";
    protected static final String PUT = "PUT";
    protected static final String DELETE = "DELETE";
    protected static final String TRACE = "TRACE";
    
    protected final Binder binder;
    protected abstract void map();
    
    public RouteMap() {
    	binder = new MapBinder();
    	binder.route(new NotFoundAction());
        map();
    }

    @Override
    public Binder getBinder() {
        return binder;
    }

    // Shortcuts methods

    protected void get(final String path, Runnable runnable) {
    	binder.route(GET, path, runnable);
    }

    protected void post(final String path, Runnable runnable) {
    	binder.route(POST, path, runnable);
    }

    protected void put(final String path, Runnable runnable) {
    	binder.route(PUT, path, runnable);
    }

    protected void head(final String path, Runnable runnable) {
    	binder.route(HEAD, path, runnable);
    }

    protected void options(final String path, Runnable runnable) {
    	binder.route(OPTIONS, path, runnable);
    }

    protected void delete(final String path, Runnable runnable) {
    	binder.route(DELETE, path, runnable);
    }

    protected void trace(final String path, Runnable runnable) {
    	binder.route(TRACE, path, runnable);
    }

    protected void route(Runnable runnable) {
    	binder.route(runnable);
    }

}
