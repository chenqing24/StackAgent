package cq.core;

import cq.core.exception.ClassForNameException;

/**
 * 反射
 * @author chenqing24@163.com
 */
public class ClassForName {

    public static <T> T createInstance(String implClassName, Class<T> interfaceClass) 
    		throws ClassForNameException {
        Class<? extends T> implClass;
        try {
        	implClass = forName(implClassName, interfaceClass);
            T instance = implClass.newInstance();
            
            return instance;
        } catch (ClassNotFoundException e) {
            throw new ClassForNameException(e);
        } catch (InstantiationException e) {
            throw new ClassForNameException(e);
        } catch (IllegalAccessException e) {
            throw new ClassForNameException(e);
        }
    }

    public static <T> Class<? extends T> forName(String implClassName, Class<T> interfaceClass) 
    		throws ClassNotFoundException {
        Class<?> clazz = Class.forName(implClassName);
        Class<? extends T> impl = clazz.asSubclass(interfaceClass);
        
        return impl;
    }

}
