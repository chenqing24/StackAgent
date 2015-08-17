package cq.core;

/**
 * 模型绑定解释器
 * @author chenqing24@163.com
 */
public interface Resolver {

    Runnable exec();

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
