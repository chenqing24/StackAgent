package cq.core.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cq.core.Config;

/**
 * IoC管理的bean工厂
 * @author chenqing24@163.com
 */
public class BeanFactory {
	private ApplicationContext applicationContext;
	
    public void init(Config config) {
    	this.applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
    }
	
    /**
     * Find all beans in container.
     */
    public List<Object> findAllBeans() {
        String[] beanNames = this.applicationContext.getBeanDefinitionNames();
        List<Object> beans = new ArrayList<Object>(beanNames.length);
        for (int i=0; i<beanNames.length; i++) {
            beans.add(this.applicationContext.getBean(beanNames[i]));
        }
        return beans;
    }
}
