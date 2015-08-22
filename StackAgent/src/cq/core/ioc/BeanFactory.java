package cq.core.ioc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Ioc工厂
 * 
 * @author chenqing24@163.com
 *
 */
public class BeanFactory {
	// 该工厂类产生的bean都放在这个map里面
	Map beans = new HashMap();
	// 默认的properties文件的名字为：beans.properties
	private String congfigLocation = "beans.properties";
	
	public BeanFactory(){
		init();
	}
	
	public BeanFactory(String configLocation){
		setCongfigLocation(configLocation);
		init();
	}
	
	private void init(){
		try {
			Properties properties=new Properties();
			
			//将properties文件load进来
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(congfigLocation));
			//将properties对象转换为一个set，便于遍历
			Set set=properties.entrySet();
			//循环遍历properties文件里面的一条条记录
			for (Iterator iterator=set.iterator(); iterator.hasNext(); ) {
				Map.Entry entry=(Map.Entry)iterator.next();
				String keyString=(String)entry.getKey();
				String className=(String)entry.getValue();
				Class clz=Class.forName(className);
				Object bean= clz.newInstance();
				//将实例化好的类放进map
				beans.put(keyString, bean);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name){
		return beans.get(name);
	}

	/**
	 * @return the congfigLocation
	 */
	public String getCongfigLocation() {
		return congfigLocation;
	}

	/**
	 * @param congfigLocation the congfigLocation to set
	 */
	public void setCongfigLocation(String congfigLocation) {
		this.congfigLocation = congfigLocation;
	}
}
