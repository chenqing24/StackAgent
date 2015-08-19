package cq.core.route;

import com.ghosthack.turismo.Resolver;
import com.ghosthack.turismo.Routes;
import com.ghosthack.turismo.action.NotFoundAction;
import com.ghosthack.turismo.resolver.MapResolver;

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
    
    public RouteMap() {
    	binder = new MapBinder();
    	// TODO 2015-08-19
    	binder.route(new NotFoundAction());
        map();
    }

    @Override
    public Resolver getResolver() {
        return resolver;
    }

    protected abstract void map();

    // Shortcuts methods

    protected void get(final String path, Runnable runnable) {
        resolver.route(GET, path, runnable);
    }

    protected void post(final String path, Runnable runnable) {
        resolver.route(POST, path, runnable);
    }

    protected void put(final String path, Runnable runnable) {
        resolver.route(PUT, path, runnable);
    }

    protected void head(final String path, Runnable runnable) {
        resolver.route(HEAD, path, runnable);
    }

    protected void options(final String path, Runnable runnable) {
        resolver.route(OPTIONS, path, runnable);
    }

    protected void delete(final String path, Runnable runnable) {
        resolver.route(DELETE, path, runnable);
    }

    protected void trace(final String path, Runnable runnable) {
        resolver.route(TRACE, path, runnable);
    }

    protected void route(Runnable runnable) {
        resolver.route(runnable);
    }


}
