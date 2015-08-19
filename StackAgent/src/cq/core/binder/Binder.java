package cq.core.binder;

/**
 * 路由绑定器
 * @author chenqing24@163.com
 */
public interface Binder {

    Runnable bind();

    /**
     * 跳至path并执行
     * @param method
     * @param path
     * @param runnable
     */
    void route(String method, String path, Runnable runnable);

    /**
     * 转跳
     * @param method
     * @param fromPath
     * @param targetPath
     */
    void route(String method, String fromPath, String targetPath);

    /**
     * 执行
     * @param runnable
     */
    void route(Runnable runnable);

}
