package cq.action;

import java.sql.ResultSet;
import java.sql.Statement;

import cq.core.RootServlet;
import cq.core.action.BaseAction;
import cq.core.ioc.BeanFactory;
import cq.core.orm.DbTool;

/**
 * 测试Action
 * @author chenqing24@163.com
 */
public class TestAction extends BaseAction {

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.putTplMap("hi", "hello");
        try {
        	BeanFactory beanFactory = (BeanFactory) this.context().getAttribute(RootServlet.INIT_FACTORY_NAME);
        	DbTool dt = (DbTool) beanFactory.getBean("DbTool");
        	Statement st =  dt.getConn().createStatement();
	        ResultSet rs= st.executeQuery("SELECT * FROM TEST ORDER BY ID");
	        while(rs.next()){
	            System.out.println(rs.getString("NAME"));
	        }
	        
	        rs.close();
	        st.close();
	        
			this.tplPrint("hi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
