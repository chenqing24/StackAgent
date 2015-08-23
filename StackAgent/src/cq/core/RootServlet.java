package cq.core;

import static cq.core.ClassForName.createInstance;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cq.core.exception.ActionException;
import cq.core.exception.ClassForNameException;
import cq.core.ioc.BeanFactory;
import cq.core.route.Route;

/**
 * Servlet implementation class RootServlet
 */
@WebServlet("/RootServlet")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ROUTES = "routes";	// 配置中绑定的路由
    public static final String INIT_FACTORY_NAME="_MY_BEAN_FACTORY";
	
	protected transient ServletContext context;
	protected transient Route route;
	
	/**
	 * 从web.xml中读取配置
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
		super.init();
		BeanFactory beanFactory = null;
        context = config.getServletContext();
        final String routesParam = config.getInitParameter(ROUTES);
        try {
        	// ioc加载
        	String configLocation =config.getInitParameter("configLocation");  
            if (configLocation==null) {  
                //如果在web.xml里面没有配置properties文件的名字则  
                beanFactory=new BeanFactory();  
            }else {  
                beanFactory=new BeanFactory(configLocation);  
            }  
            config.getServletContext().setAttribute(INIT_FACTORY_NAME, beanFactory);
            
            
        	route = createInstance(routesParam, Route.class);
        	
        } catch (ActionException e) {
            throw new ServletException(e);
        } catch (ClassForNameException e) {
        	throw new ServletException(e);
		}
    }
    
    /**
     * 统一处理请求
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Env.create(request, response, context);
        try {
            final Runnable action = route.getBinder().bind();
            action.run();
        } catch (RuntimeException e) {
            throw new ServletException(e);
        } finally {
            Env.destroy();
        }
    }

}
