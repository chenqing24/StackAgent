package cq.core.exception;

/**
 * 执行url抛错
 * @author chenqing24@163.com
 */
public class ActionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ActionException() {
        super();
    }

    public ActionException(String msg) {
        super(msg);
    }

    public ActionException(Throwable cause) {
        super(cause);
    }

}
