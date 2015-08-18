package cq.core.exception;

/**
 * 反射抛错
 * @author chenqing24@163.com
 */
public class ClassForNameException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public ClassForNameException(Exception e) {
        super(e);
    }
}
