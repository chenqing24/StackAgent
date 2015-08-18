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

/**
 * Servlet implementation class RootServlet
 */
@WebServlet("/RootServlet")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODELS = "models";	// 配置中绑定的模型的key
	
	protected transient ServletContext context;
	protected transient Models models;
	
	/**
	 * 从web.xml中读取配置
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        context = config.getServletContext();
        final String routesParam = config.getInitParameter(MODELS);
        try {
        	models = createInstance(routesParam, Models.class);
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
            final Runnable action = models.getFunc().exec();
            action.run();
        } catch (RuntimeException e) {
            throw new ServletException(e);
        } finally {
            Env.destroy();
        }
    }

}
