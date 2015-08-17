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

import cq.core.ClassForName.ClassForNameException;

/**
 * Servlet implementation class RootServlet
 */
@WebServlet("/RootServlet")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MODELS = "models";	// 配置中绑定的模型的key
	
	protected transient ServletContext context;
	protected transient Models models;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        context = config.getServletContext();
        final String routesParam = config.getInitParameter(MODELS);
        try {
        	models = createInstance(routesParam, Models.class);
        } catch (ClassForNameException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Env.create(req, res, context);
        try {
            final Runnable action = models.getFunc().exec();
            action.run();
        } catch (RuntimeException e) {
            throw new ServletException(e);
        } finally {
            Env.destroy();
        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 获取输出流
//		PrintWriter out = response.getWriter();
//		
//		out.println("first servlet");
//	}

}
